package pl.jutupe.home.createGroup

class DebtorSelectionTracker {

    /**
     * List of selected debtor ids
     */
    private val selection = mutableListOf<Long>()

    fun onSelected(debtorId: Long, checked: Boolean) {
        if (checked) {
            if(!isSelected(debtorId)) {
                selection.add(debtorId)
            }
        } else {
            selection.remove(debtorId)
        }
    }

    fun isSelected(debtorId: Long?): Boolean =
        selection.contains(debtorId)

    fun getSelection(): List<Long> =
        selection
}