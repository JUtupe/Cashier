package pl.jutupe.core.repository.dao

import androidx.paging.DataSource
import androidx.paging.PagingSource
import androidx.room.*
import kotlinx.coroutines.flow.Flow
import pl.jutupe.core.repository.entity.Debtor

@Dao
internal interface DebtorDao {
    @Query("SELECT * FROM debtors")
    fun getAll(): Flow<List<Debtor>>

    @Query("SELECT * FROM debtors")
    fun getDebtorsPaged(): DataSource.Factory<Int, Debtor>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(debtors: List<Debtor>)

    @Delete
    suspend fun deleteAll(debtors: List<Debtor>)
}