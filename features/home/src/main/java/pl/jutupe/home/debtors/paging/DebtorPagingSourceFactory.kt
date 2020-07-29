package pl.jutupe.home.debtors.paging

import androidx.lifecycle.MutableLiveData
import androidx.paging.PagingSource
import pl.jutupe.core.repository.DebtorRepository
import pl.jutupe.core.repository.entity.Debtor

class DebtorPagingSourceFactory (
    private val debtorRepository: DebtorRepository
): () -> PagingSource<Int, Debtor> {

    val source = MutableLiveData<PagingSource<Int, Debtor>>()

    override fun invoke(): PagingSource<Int, Debtor> {
        val dataSource = debtorRepository.getAllPaging()

        source.postValue(dataSource)

        return dataSource
    }

    fun refresh() {
        source.value?.invalidate()
    }
}