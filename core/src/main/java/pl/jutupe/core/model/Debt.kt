package pl.jutupe.core.model

import java.util.*

data class Debt(
    val id: Int,
    val name: String,
    val amount: Int,
    val deadline: Date
)