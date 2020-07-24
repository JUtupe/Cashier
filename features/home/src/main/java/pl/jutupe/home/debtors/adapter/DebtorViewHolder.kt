package pl.jutupe.home.debtors.adapter

import androidx.recyclerview.widget.RecyclerView
import pl.jutupe.core.model.Debtor
import pl.jutupe.home.databinding.ItemDebtorBinding

class DebtorViewHolder(
    private val binding: ItemDebtorBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(debtor: Debtor) {
        binding.debtor = debtor
        binding.executePendingBindings()
    }
}