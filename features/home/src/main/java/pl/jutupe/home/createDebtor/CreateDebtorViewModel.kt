package pl.jutupe.home.createDebtor

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import pl.jutupe.base.SingleLiveData
import pl.jutupe.core.repository.DebtorRepository
import pl.jutupe.core.repository.entity.Debtor
import timber.log.Timber

class CreateDebtorViewModel(
    private val debtorRepository: DebtorRepository
) : ViewModel() {

    val firstName = MutableLiveData<String>()
    val lastName = MutableLiveData<String>()
    val events = SingleLiveData<CreateDebtorViewEvent>()

    fun onCreateButtonClicked() {
        val firstNameString = firstName.value
        val lastNameString = lastName.value

        if (isValidName(firstNameString, lastNameString)) {
            return
        }

        viewModelScope.launch {
            val debtor = Debtor(0, firstNameString!!, lastNameString!!)

            try {
                debtorRepository.insertAll(listOf(debtor))

                events.value = CreateDebtorViewEvent.ShowDebtorCreatedInformation
                events.value = CreateDebtorViewEvent.NavigateBack
            } catch (e: Exception) {
                Timber.e(e, "onAddDebtorClicked error:")
            }
        }
    }

    private fun isValidName(firstNameString: String?, lastNameString: String?): Boolean {
        var isError = false

        if (firstNameString == null) {
            events.value = CreateDebtorViewEvent.ShowFirstNameError
            isError = true
        }

        if (lastNameString == null) {
            events.value = CreateDebtorViewEvent.ShowLastNameError
            isError = true
        }

        return isError
    }
}