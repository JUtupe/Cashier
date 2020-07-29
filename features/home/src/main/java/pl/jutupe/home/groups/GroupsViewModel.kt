package pl.jutupe.home.groups

import pl.jutupe.base.view.BaseViewModel

class GroupsViewModel : BaseViewModel<GroupsNavigator>() {

    fun loadGroups() {

    }

    fun onAddGroupClicked() {
        navigator?.openCreateGroupView()
    }
}