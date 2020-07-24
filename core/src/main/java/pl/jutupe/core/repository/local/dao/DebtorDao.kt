package pl.jutupe.core.repository.local.dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import pl.jutupe.core.repository.local.entity.DebtorLocal

@Dao
internal interface DebtorDao {
    @Query("SELECT * FROM debtors")
    fun getAll(): Flow<List<DebtorLocal>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(debtors: List<DebtorLocal>)

    @Delete
    suspend fun deleteAll(debtors: List<DebtorLocal>)
}