package pl.jutupe.core.repository.local

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import pl.jutupe.core.model.Debtor
import pl.jutupe.core.repository.local.dao.DebtorDao
import pl.jutupe.core.repository.local.entity.DebtorLocal

class DebtorRepository internal constructor(
    private val debtorDao: DebtorDao
) {

    fun getAll(): Flow<List<Debtor>> =
        debtorDao.getAll()
            .map { it.map { it.toDebtor() } }

    suspend fun insertAll(debtors: List<Debtor>) =
        debtorDao.insertAll(debtors.map { it.toDebtorLocal() })

    suspend fun deleteAll(debtors: List<Debtor>) =
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