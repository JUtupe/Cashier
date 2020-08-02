package pl.jutupe.home.createGroup.adapter

import androidx.recyclerview.widget.RecyclerView
import pl.jutupe.core.repository.entity.Debtor
import pl.jutupe.home.databinding.ItemSelectableDebtorBinding

class SelectableDebtorViewHolder(
    private val binding: ItemSelectableDebtorBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(debtor: Debtor?, isChecked: Boolean, onChecked: (Int, Boolean) -> Unit) {
        debtor?.let {
            binding.checkbox.setOnCheckedChangeListener { _, checked -> onChecked(it.debtorId, checked) }
        }
        binding.debtor = debtor
        binding.isChecked = isChecked
        binding.executePendingBindings()
    }
}