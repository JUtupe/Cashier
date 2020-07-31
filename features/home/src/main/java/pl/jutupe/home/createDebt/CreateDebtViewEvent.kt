package pl.jutupe.home.createDebt

sealed class CreateDebtViewEvent {
    object NavigateUp : CreateDebtViewEvent()
    object ShowDebtCreatedInformation : CreateDebtViewEvent()
}