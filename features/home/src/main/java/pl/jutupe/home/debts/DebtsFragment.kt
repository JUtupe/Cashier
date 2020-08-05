package pl.jutupe.home.debts

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.observe
import androidx.paging.LoadState
import kotlinx.coroutines.flow.collectLatest
import org.koin.android.ext.android.bind
import org.koin.android.viewmodel.ext.android.viewModel
import pl.jutupe.base.NavActions
import pl.jutupe.base.view.BaseFragment
import pl.jutupe.home.R
import pl.jutupe.home.databinding.FragmentDebtsBinding
import pl.jutupe.home.debts.adapter.DebtAdapter

class DebtsFragment : BaseFragment<FragmentDebtsBinding, DebtsViewModel>(
    layoutId = R.layout.fragment_debts
) {

    override val viewModel by viewModel<DebtsViewModel>()

    private val debtAdapter = DebtAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.events.observe(viewLifecycleOwner, this::onViewEvent)
        lifecycleScope.launchWhenCreated {
            viewModel.debts.collectLatest {
                debtAdapter.submitData(it)
            }
        }
        debtAdapter.addLoadStateListener { loadState ->
            binding.list.isVisible = loadState.source.refresh is LoadState.NotLoading
            binding.progressBar.isVisible = loadState.source.refresh is LoadState.Loading
        }
    }

    override fun onInitDataBinding() {
        binding.viewModel = viewModel
        binding.list.adapter = debtAdapter
    }

    private fun onViewEvent(event: DebtsViewEvent) {
        when (event) {
            DebtsViewEvent.OpenCreateDebt ->
                startActivity(NavActions.actionCreateDebt(requireContext()))
        }
    }
}