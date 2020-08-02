package pl.jutupe.core.repository

import androidx.paging.*
import pl.jutupe.core.repository.dao.DebtorDao
import pl.jutupe.core.repository.entity.Debtor

class DebtorRepository internal constructor(
    private val debtorDao: DebtorDao
) {
    fun getAllPaging(): PagingSource<Int, Debtor> =
        debtorDao.getDebtorsPaged()

    suspend fun insert(debtor: Debtor) =
        debtorDao.insert(debtor)

    suspend fun insertAll(debtors: List<Debtor>) =
        debtorDao.insertAll(debtors)

    suspend fun deleteAll(debtors: List<Debtor>) =
        debtorDao.deleteAll(debtors)
}