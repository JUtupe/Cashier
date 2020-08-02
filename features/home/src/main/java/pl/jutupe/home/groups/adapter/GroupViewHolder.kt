package pl.jutupe.home.groups.adapter

import androidx.recyclerview.widget.RecyclerView
import pl.jutupe.core.repository.entity.Group
import pl.jutupe.home.databinding.ItemGroupBinding

class GroupViewHolder(
    private val binding: ItemGroupBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(group: Group?) {
        binding.group = group
        binding.executePendingBindings()
    }
}