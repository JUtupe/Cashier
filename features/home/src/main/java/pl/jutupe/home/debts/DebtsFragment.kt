package pl.jutupe.home.debts

import android.os.Bundle
import android.view.View
import org.koin.android.viewmodel.ext.android.viewModel
import pl.jutupe.base.NavActions
import pl.jutupe.base.view.BaseFragment
import pl.jutupe.home.BR
import pl.jutupe.home.R
import pl.jutupe.home.databinding.FragmentDebtsBinding

class DebtsFragment : BaseFragment<FragmentDebtsBinding, DebtsViewModel>(), DebtsNavigator {

    override val viewModel by viewModel<DebtsViewModel>()
    override fun getLayoutId(): Int = R.layout.fragment_debts
    override fun getBindingVariable(): Int = BR.viewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.navigator = this
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.loadDebts()
    }

    override fun openCreateDebtView() {
        context?.let {
            startActivity(NavActions.actionCreateDebt(it))
        }
    }
}