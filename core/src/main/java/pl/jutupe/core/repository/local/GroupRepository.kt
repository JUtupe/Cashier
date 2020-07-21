package pl.jutupe.core.repository.local

import io.reactivex.Completable
import io.reactivex.Observable
import pl.jutupe.core.model.Group
import pl.jutupe.core.repository.local.dao.GroupDao
import pl.jutupe.core.repository.local.dao.model.GroupWithDebtors
import pl.jutupe.core.repository.local.entity.GroupLocal

class GroupRepository internal constructor(
    private val groupDao: GroupDao,
    private val debtorRepository: DebtorRepository
) {

    fun getAll(): Observable<List<Group>> =
        groupDao.getGroupWithDebtors()
            .map { it.map { it.toGroup() } }

    fun insertAll(groups: List<Group>): Completable =
        groupDao.insertAll(groups.map { it.toGroupLocal() })

    fun deleteAll(groups: List<Group>): Completable =
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