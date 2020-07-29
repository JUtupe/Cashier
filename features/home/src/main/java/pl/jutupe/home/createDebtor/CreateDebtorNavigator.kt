package pl.jutupe.home.createDebtor

interface CreateDebtorNavigator {
    fun showFirstNameError()
    fun showLastNameError()
    fun showDebtorCreatedText()
    fun navigateBack()
}