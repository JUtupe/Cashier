package pl.jutupe.core.repository

import pl.jutupe.core.repository.dao.PaymentDao
import pl.jutupe.core.repository.entity.Payment

internal class PaymentRepository(
    private val paymentDao: PaymentDao
) {
    suspend fun insertAll(payments: List<Payment>) =
        paymentDao.insertAll(payments)

    suspend fun deleteAll(payments: List<Payment>) =
        paymentDao.deleteAll(payments)
}