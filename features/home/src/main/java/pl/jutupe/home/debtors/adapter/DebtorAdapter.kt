package pl.jutupe.home.debtors.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import pl.jutupe.core.repository.entity.Debtor
import pl.jutupe.home.databinding.ItemDebtorBinding

class DebtorAdapter : PagingDataAdapter<Debtor, DebtorViewHolder>(DEBTOR_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DebtorViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemDebtorBinding.inflate(inflater, parent, false)
        return DebtorViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DebtorViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }

    companion object {
        val DEBTOR_COMPARATOR = object : DiffUtil.ItemCallback<Debtor>() {
            override fun areItemsTheSame(oldItem: Debtor, newItem: Debtor): Boolean =
                oldItem.debtorId == newItem.debtorId

            override fun areContentsTheSame(oldItem: Debtor, newItem: Debtor): Boolean =
                oldItem == newItem
        }
    }
}