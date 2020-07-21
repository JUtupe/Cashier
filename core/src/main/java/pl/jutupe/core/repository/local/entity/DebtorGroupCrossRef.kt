package pl.jutupe.core.repository.local.entity

import androidx.room.Entity

@Entity(
    tableName = "debtors_groups",
    primaryKeys = ["debtorId", "groupId"]
)
internal data class DebtorGroupCrossRef(
    var debtorId: Int,
    var groupId: Int
)