package pl.jutupe.core.repository.local

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import pl.jutupe.core.model.Debt
import pl.jutupe.core.repository.local.dao.DebtDao
import pl.jutupe.core.repository.local.entity.DebtLocal

class DebtRepository internal constructor(
    private val debtDao: DebtDao
) {
    fun getAll(): Flow<List<Debt>> =
        debtDao.getAll()
            .map { it.map { it.toDebt() } }

    suspend fun insertAll(debts: List<Debt>) =
        debtDao.insertAll(debts.map { it.toDebtLocal() })

    suspend fun deleteAll(debts: List<Debt>) =
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