package pl.jutupe.core.repository.local.dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import pl.jutupe.core.repository.local.dao.model.GroupWithDebtors
import pl.jutupe.core.repository.local.entity.GroupLocal

@Dao
internal interface GroupDao {
    @Transaction
    @Query("SELECT * FROM groups")
    fun getGroupWithDebtors(): Flow<List<GroupWithDebtors>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(groups: List<GroupLocal>)

    @Delete
    suspend fun deleteAll(groups: List<GroupLocal>)
}