package pl.jutupe.core.repository.local.dao.model

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import pl.jutupe.core.repository.local.entity.DebtorGroupCrossRef
import pl.jutupe.core.repository.local.entity.DebtorLocal
import pl.jutupe.core.repository.local.entity.GroupLocal

internal data class GroupWithDebtors(
    @Embedded var groupLocal: GroupLocal,
    @Relation(
        parentColumn = "groupId",
        entityColumn = "debtorId",
        associateBy = Junction(DebtorGroupCrossRef::class)
    )
    var debtors: List<DebtorLocal>
)