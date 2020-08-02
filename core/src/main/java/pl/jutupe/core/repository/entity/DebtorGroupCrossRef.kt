package pl.jutupe.core.repository.entity

import androidx.room.Entity

@Entity(
    tableName = "debtors_groups",
    primaryKeys = ["debtorId", "groupId"]
)
internal data class DebtorGroupCrossRef(
    var debtorId: Long,
    var groupId: Long
)