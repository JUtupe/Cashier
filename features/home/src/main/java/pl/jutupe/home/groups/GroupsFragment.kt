package pl.jutupe.home.groups

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.observe
import androidx.paging.LoadState
import kotlinx.coroutines.flow.collectLatest
import org.koin.android.viewmodel.ext.android.viewModel
import pl.jutupe.base.NavActions
import pl.jutupe.base.view.BaseFragment
import pl.jutupe.home.R
import pl.jutupe.home.databinding.FragmentGroupsBinding
import pl.jutupe.home.groups.adapter.GroupAdapter
import pl.jutupe.ui.adapter.RetryLoadAdapter

class GroupsFragment : BaseFragment<FragmentGroupsBinding, GroupsViewModel>(
    layoutId = R.layout.fragment_groups
) {

    override val viewModel by viewModel<GroupsViewModel>()

    private val groupAdapter = GroupAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.events.observe(viewLifecycleOwner, this::onViewEvent)
        lifecycleScope.launchWhenCreated {
            viewModel.groups.collectLatest {
                groupAdapter.submitData(it)
            }
        }

        lifecycleScope.launchWhenCreated {
            groupAdapter.loadStateFlow.collectLatest { loadState ->
                binding.list.isVisible = loadState.source.refresh is LoadState.NotLoading
                binding.progressBar.isVisible = loadState.source.refresh is LoadState.Loading
                binding.retryButton.isVisible = loadState.source.refresh is LoadState.Error

                binding.emptyView.isVisible =
                    loadState.append.endOfPaginationReached &&
                            groupAdapter.itemCount == 0
            }
        }
    }

    override fun onInitDataBinding() {
        binding.viewModel = viewModel
        binding.list.adapter = groupAdapter.withLoadStateFooter(
            RetryLoadAdapter { groupAdapter.retry() }
        )
        binding.retryButton.setOnClickListener { groupAdapter.retry() }
    }

    private fun onViewEvent(event: GroupsViewEvent) {
        when(event) {
            GroupsViewEvent.OpenCreateGroup ->
                startActivity(NavActions.actionCreateGroup(requireContext()))
        }
    }
}