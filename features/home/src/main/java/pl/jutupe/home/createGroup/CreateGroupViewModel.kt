package pl.jutupe.home.createGroup

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import pl.jutupe.base.SingleLiveData

class CreateGroupViewModel : ViewModel() {

    val groupName = MutableLiveData<String>()
    val events = SingleLiveData<CreateGroupViewEvent>()

    fun onCreateButtonClicked() {
        //todo

        events.value = CreateGroupViewEvent.ShowGroupCreatedInformation
        events.value = CreateGroupViewEvent.NavigateBack
    }
}