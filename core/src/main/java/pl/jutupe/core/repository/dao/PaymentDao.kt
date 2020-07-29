package pl.jutupe.core.repository.dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import pl.jutupe.core.repository.entity.Payment

@Dao
internal interface PaymentDao {
    @Query("SELECT * FROM payments")
    fun getAll(): Flow<List<Payment>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(payments: List<Payment>)

    @Delete
    suspend fun deleteAll(payments: List<Payment>)
}