package pl.jutupe.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import pl.jutupe.ui.R
import pl.jutupe.ui.databinding.ItemRetryLoadBinding

class RetryLoadAdapter (
    private val retry: () -> Unit
) : LoadStateAdapter<RetryLoadViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        loadState: LoadState
    ): RetryLoadViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_retry_load, parent, false)
        val binding = ItemRetryLoadBinding.bind(view)
        return RetryLoadViewHolder(binding, retry)
    }

    override fun onBindViewHolder(
        holder: RetryLoadViewHolder,
        loadState: LoadState
    ) {
        holder.bind(loadState)
    }
}