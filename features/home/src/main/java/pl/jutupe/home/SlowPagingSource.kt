package pl.jutupe.home

import androidx.paging.ExperimentalPagingApi
import androidx.paging.PagingSource
import androidx.paging.PagingState
import kotlinx.coroutines.delay
import java.lang.RuntimeException

//todo move to another module
/**
 * PagingSource created to simulate network latency.
 *
 * @param delay is milliseconds delay between [pagingSource] load call,
 *        default [delay] is set to one second.
 * @param enableErrors enable occasional errors to simulate network errors.
 */
class SlowPagingSource<K : Any, V : Any>(
    private val pagingSource: PagingSource<K, V>,
    private val delay: Long = 1000,
    private val enableErrors: Boolean = false
) : PagingSource<K, V>() {

    var error = false

    override suspend fun load(params: LoadParams<K>): LoadResult<K, V> {
        delay(delay)

        error = error.not()

        return if (enableErrors && error) LoadResult.Error(RuntimeException("example error message"))
        else pagingSource.load(params)
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

fun <K : Any, V : Any> PagingSource<K,V>.delayed(
    delay: Long = 1000,
    enableErrors: Boolean = true
) =
    SlowPagingSource(this, delay, enableErrors)