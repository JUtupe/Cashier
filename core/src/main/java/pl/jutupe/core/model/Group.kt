package pl.jutupe.core.model

data class Group(
    val id: Int,
    val name: String,
    val debtors: List<Debtor>
)