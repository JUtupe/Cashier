package pl.jutupe.core.repository.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "debtors")
data class Debtor(
    @PrimaryKey(autoGenerate = true) var debtorId: Long,
    var firstName: String,
    var lastName: String,
    var phone: String? = null
)