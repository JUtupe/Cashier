package pl.jutupe.core.repository.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "debtors")
internal data class DebtorLocal(
    @PrimaryKey(autoGenerate = true) var debtorId: Int,
    var firstName: String,
    var lastName: String
)