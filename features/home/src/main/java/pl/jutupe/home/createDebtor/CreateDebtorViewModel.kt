package pl.jutupe.home.createDebtor

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import pl.jutupe.base.view.BaseViewModel
import pl.jutupe.core.repository.DebtorRepository
import pl.jutupe.core.repository.entity.Debtor
import timber.log.Timber

class CreateDebtorViewModel(
    private val debtorRepository: DebtorRepository
) : BaseViewModel<CreateDebtorNavigator>() {
    val firstName = MutableLiveData<String>()
    val lastName = MutableLiveData<String>()

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

                navigator?.showDebtorCreatedText()
                navigator?.navigateBack()
            } catch (e: Exception) {
                Timber.e(e, "onAddDebtorClicked error:")
            }
        }
    }

    private fun isValidName(firstNameString: String?, lastNameString: String?): Boolean {
        var isError = false

        if (firstNameString == null) {
            navigator?.showFirstNameError()
            isError = true
        }

        if (lastNameString == null) {
            navigator?.showLastNameError()
            isError = true
        }

        return isError
    }
}