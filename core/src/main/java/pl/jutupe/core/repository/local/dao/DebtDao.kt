package pl.jutupe.core.repository.local.dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import pl.jutupe.core.repository.local.entity.DebtLocal

@Dao
internal interface DebtDao {
    @Query("SELECT * FROM debts")
    fun getAll(): Flow<List<DebtLocal>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(debtors: List<DebtLocal>)

    @Delete
    suspend fun deleteAll(debtors: List<DebtLocal>)
}