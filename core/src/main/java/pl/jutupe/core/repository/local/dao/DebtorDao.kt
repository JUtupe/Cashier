package pl.jutupe.core.repository.local.dao

import androidx.room.*
import io.reactivex.Completable
import io.reactivex.Observable
import pl.jutupe.core.model.Debtor
import pl.jutupe.core.repository.local.entity.DebtorLocal

@Dao
internal interface DebtorDao {
    @Query("SELECT * FROM debtors")
    fun getAll(): Observable<List<DebtorLocal>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(debtors: List<DebtorLocal>): Completable

    @Delete
    fun deleteAll(debtors: List<DebtorLocal>): Completable
}