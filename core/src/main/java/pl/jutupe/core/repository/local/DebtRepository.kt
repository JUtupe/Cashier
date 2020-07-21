package pl.jutupe.core.repository.local

import io.reactivex.Completable
import io.reactivex.Observable
import pl.jutupe.core.model.Debt
import pl.jutupe.core.repository.local.dao.DebtDao
import pl.jutupe.core.repository.local.entity.DebtLocal

class DebtRepository internal constructor(
    private val debtDao: DebtDao
) {
    fun getAll(): Observable<List<Debt>> =
        debtDao.getAll()
            .map { it.map { it.toDebt() } }

    fun insertAll(debts: List<Debt>): Completable =
        debtDao.insertAll(debts.map { it.toDebtLocal() })

    fun deleteAll(debts: List<Debt>): Completable =
        debtDao.deleteAll(debts.map { it.toDebtLocal() })

    internal fun DebtLocal.toDebt(): Debt =
        Debt(
            this.debtId,
            this.name,
            this.amount,
            this.deadline
        )

    internal fun Debt.toDebtLocal(): DebtLocal =
        DebtLocal(
            this.id,
            this.name,
            this.amount,
            this.deadline
        )
}