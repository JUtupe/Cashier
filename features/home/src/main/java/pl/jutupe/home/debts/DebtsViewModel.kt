package pl.jutupe.home.debts

import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import pl.jutupe.base.view.BaseViewModel
import pl.jutupe.core.repository.DebtRepository
import pl.jutupe.home.debts.adapter.DebtAdapter

class DebtsViewModel(
    private val debtRepository: DebtRepository
) : BaseViewModel<DebtsNavigator>() {

    val debtAdapter = DebtAdapter()

    fun loadDebts() {
        viewModelScope.launch(Dispatchers.Default) {
            Pager(
                config = PagingConfig(
                    pageSize = 20
                )
            ) { debtRepository.getAllPaging() }
                .flow
                .collectLatest {
                    debtAdapter.submitData(it)
                }
        }
    }

    fun onAddDebtClicked() {
        navigator?.openCreateDebtView()
    }
}