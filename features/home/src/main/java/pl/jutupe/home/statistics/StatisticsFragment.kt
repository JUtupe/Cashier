package pl.jutupe.home.statistics

import android.os.Bundle
import android.view.View
import org.koin.android.viewmodel.ext.android.viewModel
import pl.jutupe.base.view.BaseFragment
import pl.jutupe.home.BR
import pl.jutupe.home.R
import pl.jutupe.home.databinding.FragmentStatisticsBinding

class StatisticsFragment : BaseFragment<FragmentStatisticsBinding, StatisticsViewModel>(), StatisticsNavigator {

    override val viewModel by viewModel<StatisticsViewModel>()
    override fun getLayoutId(): Int = R.layout.fragment_statistics
    override fun getBindingVariable(): Int = BR.viewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.navigator = this
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.loadStatistics()
    }
}