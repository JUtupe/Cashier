package pl.jutupe.home.debtors

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import pl.jutupe.base.SingleLiveData
import pl.jutupe.core.repository.DebtorRepository
import pl.jutupe.home.delayed

class DebtorsViewModel(
    private val debtorRepository: DebtorRepository
) : ViewModel() {

    val events = SingleLiveData<DebtorsViewEvent>()
    val debtors =
        Pager(
            config = PagingConfig(
                pageSize = 20
            )
        ) { debtorRepository.getAllPaging().delayed() }
            .flow
            .cachedIn(viewModelScope)

    fun onAddDebtorClicked() {
        events.value = DebtorsViewEvent.OpenCreateDebtor
    }
}