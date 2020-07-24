package pl.jutupe.core.repository.local.dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import pl.jutupe.core.repository.local.entity.PaymentLocal

@Dao
internal interface PaymentDao {
    @Query("SELECT * FROM payments")
    fun getAll(): Flow<List<PaymentLocal>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(payments: List<PaymentLocal>)

    @Delete
    suspend fun deleteAll(payments: List<PaymentLocal>)
}