package pl.jutupe.home.createGroup

sealed class CreateGroupViewEvent {
    object NavigateBack : CreateGroupViewEvent()
    object ShowGroupCreatedInformation : CreateGroupViewEvent()
}