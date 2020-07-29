package pl.jutupe.core.repository

import kotlinx.coroutines.flow.Flow
import pl.jutupe.core.repository.dao.PaymentDao
import pl.jutupe.core.repository.entity.Payment

internal class PaymentRepository(
    private val paymentDao: PaymentDao
) {

    fun getAll(): Flow<List<Payment>> =
        paymentDao.getAll()

    suspend fun insertAll(payments: List<Payment>) =
        paymentDao.insertAll(payments)

    suspend fun deleteAll(payments: List<Payment>) =
        paymentDao.deleteAll(payments)
}