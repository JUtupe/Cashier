package pl.jutupe.home.createDebt

import androidx.lifecycle.ViewModel
import pl.jutupe.base.SingleLiveData

class CreateDebtViewModel : ViewModel() {

    val events = SingleLiveData<CreateDebtViewEvent>()

    fun onCreateButtonClicked() {
        //todo

        events.value = CreateDebtViewEvent.ShowDebtCreatedInformation
        events.value = CreateDebtViewEvent.NavigateUp
    }
}