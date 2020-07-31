package pl.jutupe.home.debtors

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.observe
import kotlinx.coroutines.flow.collectLatest
import org.koin.android.viewmodel.ext.android.viewModel
import pl.jutupe.base.NavActions
import pl.jutupe.base.view.BaseFragment
import pl.jutupe.home.R
import pl.jutupe.home.databinding.FragmentDebtorsBinding
import pl.jutupe.home.debtors.adapter.DebtorAdapter

class DebtorsFragment : BaseFragment<FragmentDebtorsBinding, DebtorsViewModel>(
    layoutId = R.layout.fragment_debtors
) {

    override val viewModel by viewModel<DebtorsViewModel>()

    private val debtorAdapter = DebtorAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.events.observe(viewLifecycleOwner, this::onViewEvent)
        lifecycleScope.launchWhenCreated {
            viewModel.debtors.collectLatest {
                debtorAdapter.submitData(it)
            }
        }
    }

    override fun onInitDataBinding() {
        binding.viewModel = viewModel
        binding.recyclerView.adapter = debtorAdapter
    }

    private fun onViewEvent(event: DebtorsViewEvent) {
        when (event) {
            DebtorsViewEvent.OpenCreateDebtor ->
                startActivity(NavActions.actionCreateDebtor(requireContext()))
        }
    }
}