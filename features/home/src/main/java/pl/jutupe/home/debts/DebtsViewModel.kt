package pl.jutupe.home.debts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import pl.jutupe.base.SingleLiveData
import pl.jutupe.core.repository.DebtRepository
import pl.jutupe.home.delayed

class DebtsViewModel(
    private val debtRepository: DebtRepository
) : ViewModel() {

    val events = SingleLiveData<DebtsViewEvent>()
    val debts =
        Pager(
            config = PagingConfig(
                pageSize = 20,
                enablePlaceholders = false
            )
        ) { debtRepository.getAllPaging().delayed() }
            .flow
            .cachedIn(viewModelScope)

    fun onAddDebtClicked() {
        events.value = DebtsViewEvent.OpenCreateDebt
    }
}