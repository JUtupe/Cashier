package pl.jutupe.home

import androidx.paging.ExperimentalPagingApi
import androidx.paging.PagingSource
import androidx.paging.PagingState
import kotlinx.coroutines.delay

//todo move to another module
/**
 * PagingSource created to simulate network latency.
 *
 * default [delay] is set to one second.
 */
class SlowPagingSource<K : Any, V : Any>(
    private val pagingSource: PagingSource<K, V>,
    private val delay: Long = 1000
) : PagingSource<K, V>() {

    override suspend fun load(params: LoadParams<K>): LoadResult<K, V> {
        delay(delay)

        return pagingSource.load(params)
    }

    override val jumpingSupported: Boolean
        get() = pagingSource.jumpingSupported
    override val keyReuseSupported: Boolean
        get() = pagingSource.keyReuseSupported

    @ExperimentalPagingApi
    override fun getRefreshKey(state: PagingState<K, V>): K? {
        return pagingSource.getRefreshKey(state)
    }

    override fun invalidate() {
        pagingSource.invalidate()
    }
}

fun <K : Any, V : Any> PagingSource<K,V>.delayed(delay: Long = 1000) =
    SlowPagingSource(this, delay)