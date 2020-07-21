package pl.jutupe.core.repository.local

import io.reactivex.Completable
import io.reactivex.Observable
import pl.jutupe.core.model.Payment
import pl.jutupe.core.repository.local.dao.PaymentDao
import pl.jutupe.core.repository.local.entity.PaymentLocal

class PaymentRepository internal constructor(
    private val paymentDao: PaymentDao
) {

    fun getAll(): Observable<List<Payment>> =
        paymentDao.getAll()
            .map { it.map { it.toPayment() } }

    fun insertAll(payments: List<Payment>): Completable =
        paymentDao.insertAll(payments.map { it.toPaymentLocal() })

    fun deleteAll(payments: List<Payment>): Completable =
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