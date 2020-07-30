package pl.jutupe.home.debtors.adapter

import androidx.recyclerview.widget.RecyclerView
import pl.jutupe.core.repository.entity.Debtor
import pl.jutupe.home.databinding.ItemDebtorBinding

class DebtorViewHolder(
    private val binding: ItemDebtorBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(debtor: Debtor?) {
        //todo handle null as placeholder
        binding.debtor = debtor
        binding.executePendingBindings()
    }
}