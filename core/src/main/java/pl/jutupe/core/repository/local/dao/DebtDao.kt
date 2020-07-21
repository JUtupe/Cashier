package pl.jutupe.core.repository.local.dao

import androidx.room.*
import io.reactivex.Completable
import io.reactivex.Observable
import pl.jutupe.core.repository.local.entity.DebtLocal

@Dao
internal interface DebtDao {
    @Query("SELECT * FROM debts")
    fun getAll(): Observable<List<DebtLocal>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(debtors: List<DebtLocal>): Completable

    @Delete
    fun deleteAll(debtors: List<DebtLocal>): Completable
}