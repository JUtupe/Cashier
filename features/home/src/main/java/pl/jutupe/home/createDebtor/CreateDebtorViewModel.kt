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

        if (!assertValidModel(firstNameString, lastNameString)) {
            return
        }

        viewModelScope.launch {
            val debtor = Debtor(0, firstNameString!!, lastNameString!!)

            try {
                debtorRepository.insertAll(listOf(debtor))

                events.value = CreateDebtorViewEvent.ShowDebtorCreatedInformation
                events.value = CreateDebtorViewEvent.NavigateBack
            } catch (e: Exception) {
                Timber.e(e, "insert debtor error:")

                events.value = CreateDebtorViewEvent.ShowCreateDebtorError
            }
        }
    }

    private fun assertValidModel(firstNameString: String?, lastNameString: String?): Boolean {
        var isValid = true

        if (firstNameString.isNullOrBlank()) {
            isValid = false
            events.value = CreateDebtorViewEvent.ShowFirstNameError
        }

        if (lastNameString.isNullOrBlank()) {
            isValid = false
            events.value = CreateDebtorViewEvent.ShowLastNameError
        }

        return isValid
    }
}