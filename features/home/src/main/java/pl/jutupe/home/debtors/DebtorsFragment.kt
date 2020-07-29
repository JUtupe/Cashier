package pl.jutupe.home.debtors

import android.os.Bundle
import android.view.View
import org.koin.android.viewmodel.ext.android.viewModel
import pl.jutupe.base.NavActions
import pl.jutupe.base.view.BaseFragment
import pl.jutupe.home.BR
import pl.jutupe.home.R
import pl.jutupe.home.databinding.FragmentDebtorsBinding

class DebtorsFragment : BaseFragment<FragmentDebtorsBinding, DebtorsViewModel>(),
    DebtorsNavigator {

    override val viewModel by viewModel<DebtorsViewModel>()
    override fun getLayoutId(): Int = R.layout.fragment_debtors
    override fun getBindingVariable(): Int = BR.viewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.navigator = this
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.loadDebtors()
    }

    override fun openCreateDebtorView() {
        context?.let {
            startActivity(NavActions.actionCreateDebtor(it))
        }
    }
}