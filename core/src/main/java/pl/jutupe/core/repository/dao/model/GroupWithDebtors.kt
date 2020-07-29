package pl.jutupe.core.repository.dao.model

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import pl.jutupe.core.repository.entity.DebtorGroupCrossRef
import pl.jutupe.core.repository.entity.Debtor
import pl.jutupe.core.repository.entity.Group

data class GroupWithDebtors(
    @Embedded var group: Group,
    @Relation(
        parentColumn = "groupId",
        entityColumn = "debtorId",
        associateBy = Junction(DebtorGroupCrossRef::class)
    )
    var debtors: List<Debtor>
)