package pl.jutupe.core.repository

import kotlinx.coroutines.flow.Flow
import pl.jutupe.core.repository.dao.DebtDao
import pl.jutupe.core.repository.entity.Debt

internal class DebtRepository(
    private val debtDao: DebtDao
) {
    fun getAll(): Flow<List<Debt>> =
        debtDao.getAll()

    suspend fun insertAll(debts: List<Debt>) =
        debtDao.insertAll(debts)

    suspend fun deleteAll(debts: List<Debt>) =
        debtDao.deleteAll(debts)
}