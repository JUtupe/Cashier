package pl.jutupe.home.statistics

import org.koin.android.viewmodel.ext.android.viewModel
import pl.jutupe.base.view.BaseFragment
import pl.jutupe.home.R
import pl.jutupe.home.databinding.FragmentStatisticsBinding

class StatisticsFragment : BaseFragment<FragmentStatisticsBinding, StatisticsViewModel>(
    layoutId = R.layout.fragment_statistics
) {

    override val viewModel by viewModel<StatisticsViewModel>()

    override fun onInitDataBinding() {
        binding.viewModel = viewModel
    }
}