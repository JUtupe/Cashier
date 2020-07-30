package pl.jutupe.core.repository

import androidx.paging.PagingSource
import pl.jutupe.core.repository.dao.DebtDao
import pl.jutupe.core.repository.entity.Debt

class DebtRepository internal constructor(
    private val debtDao: DebtDao
) {
    fun getAllPaging(): PagingSource<Int, Debt> =
        debtDao.getAllPaging()

    suspend fun insertAll(debts: List<Debt>) =
        debtDao.insertAll(debts)

    suspend fun deleteAll(debts: List<Debt>) =
        debtDao.deleteAll(debts)
}