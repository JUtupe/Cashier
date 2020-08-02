package pl.jutupe.core.repository.dao

import androidx.paging.PagingSource
import androidx.room.*
import kotlinx.coroutines.flow.Flow
import pl.jutupe.core.repository.dao.model.GroupWithDebtors
import pl.jutupe.core.repository.entity.DebtorGroupCrossRef
import pl.jutupe.core.repository.entity.Group

@Dao
internal interface GroupDao {
    @Query("SELECT * FROM groups")
    fun getAllPaging(): PagingSource<Int, Group>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(group: Group): Long

    @Transaction
    suspend fun insertGroupWithDebtors(group: Group, debtorIds: List<Int>) {
        val groupId = insert(group).toInt()

        val refs = mutableListOf<DebtorGroupCrossRef>()

        debtorIds.forEach {
            refs += DebtorGroupCrossRef(it, groupId)
        }

        insertAllRefs(refs)
    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(groups: List<Group>)

    @Insert
    suspend fun insertAllRefs(refs: List<DebtorGroupCrossRef>)

    @Delete
    suspend fun deleteAllRefs(refs: List<DebtorGroupCrossRef>)
}