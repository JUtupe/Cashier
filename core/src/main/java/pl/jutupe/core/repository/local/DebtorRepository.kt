package pl.jutupe.core.repository.local

import io.reactivex.Completable
import io.reactivex.Observable
import pl.jutupe.core.model.Debtor
import pl.jutupe.core.repository.local.dao.DebtorDao
import pl.jutupe.core.repository.local.entity.DebtorLocal

class DebtorRepository internal constructor(
    private val debtorDao: DebtorDao
) {

    fun getAll(): Observable<List<Debtor>> =
        debtorDao.getAll()
            .map { it.map { it.toDebtor() } }

    fun insertAll(debtors: List<Debtor>): Completable =
        debtorDao.insertAll(debtors.map { it.toDebtorLocal() })

    fun deleteAll(debtors: List<Debtor>): Completable =
        debtorDao.deleteAll(debtors.map { it.toDebtorLocal() })

    internal fun DebtorLocal.toDebtor(): Debtor =
        Debtor(
            this.debtorId,
            this.firstName,
            this.lastName
        )

    internal fun Debtor.toDebtorLocal(): DebtorLocal =
        DebtorLocal(
            this.id,
            this.firstName,
            this.lastName
        )
}