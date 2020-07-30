package pl.jutupe.home.groups.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import pl.jutupe.core.repository.entity.Group
import pl.jutupe.home.databinding.ItemGroupBinding

class GroupAdapter : PagingDataAdapter<Group, GroupViewHolder>(GROUP_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemGroupBinding.inflate(inflater, parent, false)
        return GroupViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GroupViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        val GROUP_COMPARATOR = object : DiffUtil.ItemCallback<Group>() {
            override fun areItemsTheSame(oldItem: Group, newItem: Group): Boolean =
                oldItem.groupId == newItem.groupId

            override fun areContentsTheSame(oldItem: Group, newItem: Group): Boolean =
                oldItem == newItem
        }
    }
}