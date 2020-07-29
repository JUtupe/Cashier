package pl.jutupe.home.debtors

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import pl.jutupe.base.view.BaseViewModel
import pl.jutupe.home.debtors.adapter.DebtorAdapter
import pl.jutupe.home.debtors.paging.DebtorPagingSourceFactory

class DebtorsViewModel(
    private val debtorPagingSourceFactory: DebtorPagingSourceFactory
) : BaseViewModel<DebtorsNavigator>() {

    val debtorAdapter = DebtorAdapter()
    val isRefreshing = MutableLiveData<Boolean>(false)

    fun loadDebtors() {
        viewModelScope.launch(Dispatchers.Default) {
            Pager(
                config = PagingConfig(
                    pageSize = 20,
                    enablePlaceholders = false
                ),
                pagingSourceFactory = debtorPagingSourceFactory
            ).flow
                .collectLatest {
                    debtorAdapter.submitData(it)
                }
        }
    }

    fun onRefreshLayoutSwiped() {
        debtorPagingSourceFactory.refresh()
        isRefreshing.postValue(false)
    }

    fun onAddDebtorClicked() {
        navigator?.openCreateDebtorView()
    }
}