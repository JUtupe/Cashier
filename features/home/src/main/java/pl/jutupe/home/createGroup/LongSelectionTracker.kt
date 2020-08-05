package pl.jutupe.home.createGroup

class LongSelectionTracker {

    /**
     * List of selected ids
     */
    private val selection = mutableListOf<Long>()

    fun onSelected(id: Long, checked: Boolean) {
        if (checked) {
            if(!isSelected(id)) {
                selection.add(id)
            }
        } else {
            selection.remove(id)
        }
    }

    fun isSelected(id: Long?): Boolean =
        selection.contains(id)

    fun getSelection(): List<Long> =
        selection
}