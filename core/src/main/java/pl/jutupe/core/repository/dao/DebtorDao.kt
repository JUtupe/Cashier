package pl.jutupe.core.repository.dao

import androidx.paging.PagingSource
import androidx.room.*
import pl.jutupe.core.repository.entity.Debtor

@Dao
internal interface DebtorDao {
    @Query("SELECT * FROM debtors")
    fun getDebtorsPaged(): PagingSource<Int, Debtor>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(debtors: List<Debtor>)

    @Delete
    suspend fun deleteAll(debtors: List<Debtor>)
}