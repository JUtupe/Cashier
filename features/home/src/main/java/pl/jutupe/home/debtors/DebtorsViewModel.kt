package pl.jutupe.home.debtors

import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import pl.jutupe.base.view.BaseViewModel
import pl.jutupe.core.repository.DebtorRepository
import pl.jutupe.home.debtors.adapter.DebtorAdapter

class DebtorsViewModel(
    private val debtorRepository: DebtorRepository
) : BaseViewModel<DebtorsNavigator>() {

    val debtorAdapter = DebtorAdapter()

    fun loadDebtors() {
        viewModelScope.launch(Dispatchers.Default) {
            Pager(
                config = PagingConfig(
                    pageSize = 20
                )
            ) { debtorRepository.getAllPaging() }
                .flow
                .collectLatest {
                    debtorAdapter.submitData(it)
                }
        }
    }

    fun onAddDebtorClicked() {
        navigator?.openCreateDebtorView()
    }
}