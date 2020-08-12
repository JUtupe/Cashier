package pl.jutupe.home.debtors

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.observe
import androidx.paging.CombinedLoadStates
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadState
import androidx.paging.PagingData
import kotlinx.coroutines.flow.*
import org.koin.android.ext.android.bind
import org.koin.android.viewmodel.ext.android.viewModel
import pl.jutupe.base.NavActions
import pl.jutupe.base.view.BaseFragment
import pl.jutupe.core.repository.entity.Debtor
import pl.jutupe.home.R
import pl.jutupe.home.databinding.FragmentDebtorsBinding
import pl.jutupe.home.debtors.adapter.DebtorAdapter
import pl.jutupe.ui.adapter.RetryLoadAdapter

class DebtorsFragment : BaseFragment<FragmentDebtorsBinding, DebtorsViewModel>(
    layoutId = R.layout.fragment_debtors
) {

    override val viewModel by viewModel<DebtorsViewModel>()

    private val debtorAdapter = DebtorAdapter()

    @ExperimentalPagingApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.events.observe(viewLifecycleOwner, this::onViewEvent)
        lifecycleScope.launchWhenCreated {
            viewModel.debtors.collectLatest {
                debtorAdapter.submitData(it)
            }
        }

        lifecycleScope.launchWhenCreated {
            debtorAdapter.loadStateFlow.collectLatest { loadState ->
                binding.list.isVisible = loadState.source.refresh is LoadState.NotLoading
                binding.progressBar.isVisible = loadState.source.refresh is LoadState.Loading
                binding.retryButton.isVisible = loadState.source.refresh is LoadState.Error

                binding.emptyView.isVisible =
                    loadState.append.endOfPaginationReached &&
                            debtorAdapter.itemCount == 0
            }
        }
    }

    override fun onInitDataBinding() {
        binding.viewModel = viewModel
        binding.list.adapter = debtorAdapter.withLoadStateFooter(
            RetryLoadAdapter { debtorAdapter.retry() }
        )
        binding.retryButton.setOnClickListener { debtorAdapter.retry() }
    }

    private fun onViewEvent(event: DebtorsViewEvent) {
        when (event) {
            DebtorsViewEvent.OpenCreateDebtor ->
                startActivity(NavActions.actionCreateDebtor(requireContext()))
        }
    }
}