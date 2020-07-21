package pl.jutupe.core.model

import java.util.*

data class Payment(
    val debtorId: Int,
    val debtId: Int,
    val isPaid: Boolean,
    val paidDate: Date
)