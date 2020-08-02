package pl.jutupe.home.createGroup

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import kotlinx.coroutines.launch
import pl.jutupe.base.SingleLiveData
import pl.jutupe.core.repository.DebtorRepository
import pl.jutupe.core.repository.GroupRepository
import pl.jutupe.core.repository.entity.Group
import timber.log.Timber

class CreateGroupViewModel(
    private val groupRepository: GroupRepository,
    private val debtorRepository: DebtorRepository,
    val selectionTracker: DebtorSelectionTracker
) : ViewModel() {

    val groupName = MutableLiveData<String>()
    val events = SingleLiveData<CreateGroupViewEvent>()
    val debtors = Pager(
        config = PagingConfig(
            pageSize = 20
        )
    ) { debtorRepository.getAllPaging() }
        .flow

    fun onCreateButtonClicked() {
        val selection = selectionTracker.getSelection()
        val groupNameString = groupName.value

        if (!assertValidModel(selection, groupNameString)) {
            return
        }

        viewModelScope.launch {
            val group = Group(0, groupNameString!!)

            try {
                groupRepository.insertGroupWithDebtors(group, selection)

                events.value = CreateGroupViewEvent.ShowGroupCreatedInformation
                events.value = CreateGroupViewEvent.NavigateBack
            } catch (e: Exception) {
                Timber.e(e, "insert group with debtors error")
                events.value = CreateGroupViewEvent.ShowCreateGroupError
            }
        }
    }

    private fun assertValidModel(selection: List<Long>, groupNameString: String?): Boolean {
        var isValid = true

        if (selection.isEmpty()) {
            isValid = false
            events.value = CreateGroupViewEvent.ShowGroupCreatedInformation
        }

        if (groupNameString.isNullOrBlank()) {
            isValid = false
            events.value = CreateGroupViewEvent.ShowInvalidGroupNameError
        }

        return isValid
    }
}