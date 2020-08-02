package pl.jutupe.home.createDebtor

sealed class CreateDebtorViewEvent {
    object NavigateBack : CreateDebtorViewEvent()
    object ShowFirstNameError : CreateDebtorViewEvent()
    object ShowLastNameError : CreateDebtorViewEvent()
    object ShowDebtorCreatedInformation : CreateDebtorViewEvent()
    object ShowCreateDebtorError : CreateDebtorViewEvent()
}