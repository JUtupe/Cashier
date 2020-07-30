package pl.jutupe.home.debts.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import pl.jutupe.core.repository.entity.Debt
import pl.jutupe.home.databinding.ItemDebtBinding

class DebtAdapter : PagingDataAdapter<Debt, DebtViewHolder>(DEBT_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DebtViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemDebtBinding.inflate(inflater, parent, false)
        return DebtViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DebtViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        val DEBT_COMPARATOR = object : DiffUtil.ItemCallback<Debt>() {
            override fun areItemsTheSame(oldItem: Debt, newItem: Debt): Boolean =
                oldItem.debtId == newItem.debtId

            override fun areContentsTheSame(oldItem: Debt, newItem: Debt): Boolean =
                oldItem == newItem
        }
    }
}