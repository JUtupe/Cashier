package pl.jutupe.core.repository

import kotlinx.coroutines.flow.Flow
import pl.jutupe.core.repository.dao.DebtorGroupCrossRefDao
import pl.jutupe.core.repository.dao.GroupDao
import pl.jutupe.core.repository.dao.model.GroupWithDebtors
import pl.jutupe.core.repository.entity.DebtorGroupCrossRef
import pl.jutupe.core.repository.entity.Group

internal class GroupRepository(
    private val groupDao: GroupDao,
    private val debtorGroupCrossRefDao: DebtorGroupCrossRefDao
) {

    fun getAll(): Flow<List<GroupWithDebtors>> =
        groupDao.getGroupWithDebtors()

    suspend fun insert(groupWithDebtors: GroupWithDebtors): Int  {
        val id = groupDao.insert(groupWithDebtors.group).toInt()

        insertDebtorsToGroup(id, groupWithDebtors.debtors.map { it.debtorId })

        return id
    }

    private suspend fun insertDebtorsToGroup(groupId: Int, debtorIds: List<Int>) {
        val refs = mutableListOf<DebtorGroupCrossRef>()

        debtorIds.forEach { debtorId ->
            refs += DebtorGroupCrossRef(debtorId, groupId)
        }

        debtorGroupCrossRefDao.insertAll(refs)
    }

    suspend fun deleteAll(groups: List<Group>) =
        groupDao.deleteAll(groups)
}