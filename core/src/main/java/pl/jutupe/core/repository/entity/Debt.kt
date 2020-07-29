package pl.jutupe.core.repository.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "debts")
data class Debt(
    @PrimaryKey(autoGenerate = true) var debtId: Int,
    var name: String,
    var amount: Int,
    var deadline: Date
)