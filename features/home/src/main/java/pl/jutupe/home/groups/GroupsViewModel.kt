package pl.jutupe.home.groups

import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import pl.jutupe.base.view.BaseViewModel
import pl.jutupe.core.repository.GroupRepository
import pl.jutupe.home.groups.adapter.GroupAdapter

class GroupsViewModel(
    private val groupRepository: GroupRepository
) : BaseViewModel<GroupsNavigator>() {

    val groupAdapter = GroupAdapter()

    fun loadGroups() {
        viewModelScope.launch(Dispatchers.Default) {
            Pager(
                config = PagingConfig(
                    pageSize = 20
                )
            ) { groupRepository.getAllPaging() }
                .flow
                .collectLatest {
                    groupAdapter.submitData(it)
                }
        }
    }

    fun onAddGroupClicked() {
        navigator?.openCreateGroupView()
    }
}