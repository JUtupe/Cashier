package pl.jutupe.home.debts.adapter

import androidx.recyclerview.widget.RecyclerView
import pl.jutupe.core.repository.entity.Debt
import pl.jutupe.home.databinding.ItemDebtBinding

class DebtViewHolder(
    private val binding: ItemDebtBinding
): RecyclerView.ViewHolder(binding.root) {

    fun bind(debt: Debt?) {
        //todo handle null as placeholder
        binding.debt = debt
        binding.executePendingBindings()
    }
}