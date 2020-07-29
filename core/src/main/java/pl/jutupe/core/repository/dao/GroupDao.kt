package pl.jutupe.core.repository.dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import pl.jutupe.core.repository.dao.model.GroupWithDebtors
import pl.jutupe.core.repository.entity.Group

@Dao
internal interface GroupDao {
    @Transaction
    @Query("SELECT * FROM groups")
    fun getGroupWithDebtors(): Flow<List<GroupWithDebtors>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(groups: List<Group>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(group: Group): Long

    @Delete
    suspend fun deleteAll(groups: List<Group>)
}