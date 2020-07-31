package pl.jutupe.home.debtors

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import pl.jutupe.base.SingleLiveData
import pl.jutupe.core.repository.DebtorRepository

class DebtorsViewModel(
    private val debtorRepository: DebtorRepository
) : ViewModel() {

    val events = SingleLiveData<DebtorsViewEvent>()
    val debtors =
        Pager(
            config = PagingConfig(
                pageSize = 20
            )
        ) { debtorRepository.getAllPaging() }
            .flow

    fun onAddDebtorClicked() {
        events.value = DebtorsViewEvent.OpenCreateDebtor
    }
}