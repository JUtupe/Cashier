package pl.jutupe.home.createGroup

sealed class CreateGroupViewEvent {
    object NavigateBack : CreateGroupViewEvent()
    object ShowGroupCreatedInformation : CreateGroupViewEvent()
    object ShowEmptySelectionError: CreateGroupViewEvent()
    object ShowInvalidGroupNameError : CreateGroupViewEvent()
    object ShowCreateGroupError : CreateGroupViewEvent()
}