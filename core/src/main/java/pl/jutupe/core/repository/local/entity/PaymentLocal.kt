package pl.jutupe.core.repository.local.entity

import androidx.room.Entity
import java.util.Date

@Entity(
    tableName = "payments",
    primaryKeys = ["debtorId", "debtId"]
)
internal data class PaymentLocal(
    val debtorId: Int,
    val debtId: Int,
    var isPaid: Boolean,
    var paidDate: Date
)