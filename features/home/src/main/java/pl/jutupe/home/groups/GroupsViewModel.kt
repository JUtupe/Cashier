package pl.jutupe.home.groups

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import pl.jutupe.base.SingleLiveData
import pl.jutupe.core.repository.GroupRepository

class GroupsViewModel(
    private val groupRepository: GroupRepository
) : ViewModel() {

    val events = SingleLiveData<GroupsViewEvent>()
    val groups =
        Pager(
            config = PagingConfig(
                pageSize = 20
            )
        ) { groupRepository.getAllPaging() }
            .flow

    fun onAddGroupClicked() {
        events.value = GroupsViewEvent.OpenCreateGroup
    }
}