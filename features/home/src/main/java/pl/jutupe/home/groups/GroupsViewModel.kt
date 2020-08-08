package pl.jutupe.home.groups

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import pl.jutupe.base.SingleLiveData
import pl.jutupe.core.repository.GroupRepository
import pl.jutupe.home.delayed

class GroupsViewModel(
    private val groupRepository: GroupRepository
) : ViewModel() {

    val events = SingleLiveData<GroupsViewEvent>()
    val groups =
        Pager(
            config = PagingConfig(
                pageSize = 20,
                enablePlaceholders = false
            )
        ) { groupRepository.getAllPaging().delayed() }
            .flow
            .cachedIn(viewModelScope)

    fun onAddGroupClicked() {
        events.value = GroupsViewEvent.OpenCreateGroup
    }
}