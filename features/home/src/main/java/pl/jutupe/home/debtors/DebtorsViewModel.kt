package pl.jutupe.home.debtors

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import pl.jutupe.base.view.BaseViewModel
import pl.jutupe.core.model.Debtor
import pl.jutupe.core.repository.local.DebtorRepository
import pl.jutupe.home.debtors.adapter.DebtorAdapter
import timber.log.Timber

class DebtorsViewModel(
    private val debtorRepository: DebtorRepository
) : BaseViewModel<DebtorsNavigator>() {

    val debtorAdapter = DebtorAdapter()
    val debtors = MutableLiveData<List<Debtor>>()

    fun loadDebtors() {
        viewModelScope.launch {
            try {
                debtorRepository.getAll().collect {
                    Timber.d("fetched debtors: $it")
                    debtors.postValue(it)
                }
            } catch (e: Exception) {
                Timber.e(e, "loadDebtors error:")
            }
        }
    }

    fun onAddDebtorClicked() {
        viewModelScope.launch {
            val debtor = Debtor(0, "Ken", "Doe")

            try {
                debtorRepository.insertAll(listOf(debtor))

                Timber.d("debtor added")
            } catch (e: Exception) {
                Timber.e(e, "onAddDebtorClicked error:")
            }
        }
    }
}