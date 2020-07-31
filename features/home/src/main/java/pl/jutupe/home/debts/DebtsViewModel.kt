package pl.jutupe.home.debts

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import pl.jutupe.base.SingleLiveData
import pl.jutupe.core.repository.DebtRepository

class DebtsViewModel(
    private val debtRepository: DebtRepository
) : ViewModel() {

    val events = SingleLiveData<DebtsViewEvent>()
    val debts =
        Pager(
            config = PagingConfig(
                pageSize = 20
            )
        ) { debtRepository.getAllPaging() }
            .flow

    fun onAddDebtClicked() {
        events.value = DebtsViewEvent.OpenCreateDebt
    }
}