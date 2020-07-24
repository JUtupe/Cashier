package pl.jutupe.core.repository.local

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import pl.jutupe.core.model.Payment
import pl.jutupe.core.repository.local.dao.PaymentDao
import pl.jutupe.core.repository.local.entity.PaymentLocal

class PaymentRepository internal constructor(
    private val paymentDao: PaymentDao
) {

    fun getAll(): Flow<List<Payment>> =
        paymentDao.getAll()
            .map { it.map { it.toPayment() } }

    suspend fun insertAll(payments: List<Payment>) =
        paymentDao.insertAll(payments.map { it.toPaymentLocal() })

    suspend fun deleteAll(payments: List<Payment>) =
        paymentDao.deleteAll(payments.map { it.toPaymentLocal() })

    internal fun PaymentLocal.toPayment(): Payment =
        Payment(
            this.debtorId,
            this.debtId,
            this.isPaid,
            this.paidDate
        )

    internal fun Payment.toPaymentLocal(): PaymentLocal =
        PaymentLocal(
            this.debtorId,
            this.debtId,
            this.isPaid,
            this.paidDate
        )
}