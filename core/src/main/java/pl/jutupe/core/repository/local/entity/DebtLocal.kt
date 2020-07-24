package pl.jutupe.core.repository.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "debts")
internal data class DebtLocal(
    @PrimaryKey(autoGenerate = true) var debtId: Int,
    var name: String,
    var amount: Int,
    var deadline: Date
)