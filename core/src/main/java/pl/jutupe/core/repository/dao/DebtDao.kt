package pl.jutupe.core.repository.dao

import androidx.paging.PagingSource
import androidx.room.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import pl.jutupe.core.repository.entity.Debt

@Dao
internal interface DebtDao {
    @Query("SELECT * FROM debts")
    fun getAllPaging(): PagingSource<Int, Debt>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(debtors: List<Debt>)

    @Delete
    suspend fun deleteAll(debtors: List<Debt>)
}