package pl.jutupe.core.repository.local

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import pl.jutupe.core.model.Group
import pl.jutupe.core.repository.local.dao.GroupDao
import pl.jutupe.core.repository.local.dao.model.GroupWithDebtors
import pl.jutupe.core.repository.local.entity.GroupLocal

class GroupRepository internal constructor(
    private val groupDao: GroupDao,
    private val debtorRepository: DebtorRepository
) {

    fun getAll(): Flow<List<Group>> =
        groupDao.getGroupWithDebtors()
            .map { it.map { it.toGroup() } }

    suspend fun insertAll(groups: List<Group>) =
        groupDao.insertAll(groups.map { it.toGroupLocal() })

    suspend fun deleteAll(groups: List<Group>) =
        groupDao.deleteAll(groups.map { it.toGroupLocal() })

    internal fun Group.toGroupLocal(): GroupLocal =
        GroupLocal(
            this.id,
            this.name
        )

    internal fun GroupWithDebtors.toGroup(): Group =
        Group(
            this.groupLocal.groupId,
            this.groupLocal.name,
            with(debtorRepository) {
                this@toGroup.debtors.map { it.toDebtor() }
            }
        )
}