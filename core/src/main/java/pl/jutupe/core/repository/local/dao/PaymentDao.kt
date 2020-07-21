package pl.jutupe.core.repository.local.dao

import androidx.room.*
import io.reactivex.Completable
import io.reactivex.Observable
import pl.jutupe.core.repository.local.entity.PaymentLocal

@Dao
internal interface PaymentDao {
    @Query("SELECT * FROM payments")
    fun getAll(): Observable<List<PaymentLocal>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(payments: List<PaymentLocal>): Completable

    @Delete
    fun deleteAll(payments: List<PaymentLocal>): Completable
}