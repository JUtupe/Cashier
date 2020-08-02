package pl.jutupe.core.repository.entity

import androidx.room.Entity
import java.util.Date

@Entity(
    tableName = "payments",
    primaryKeys = ["debtorId", "debtId"]
)
data class Payment(
    val debtorId: Long,
    val debtId: Long,
    var isPaid: Boolean,
    var paidDate: Date
)