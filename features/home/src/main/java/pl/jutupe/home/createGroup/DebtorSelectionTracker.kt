package pl.jutupe.home.createGroup

class DebtorSelectionTracker {

    /**
     * List of selected debtor ids
     */
    private val selection = mutableListOf<Int>()

    fun onSelected(debtorId: Int, checked: Boolean) {
        if (checked) {
            if(!isSelected(debtorId)) {
                selection.add(debtorId)
            }
        } else {
            selection.remove(debtorId)
        }
    }

    fun isSelected(debtorId: Int?): Boolean =
        selection.contains(debtorId)

    fun getSelection(): List<Int> =
        selection
}