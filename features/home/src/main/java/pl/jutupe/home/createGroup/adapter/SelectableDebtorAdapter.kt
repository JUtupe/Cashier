package pl.jutupe.home.createGroup.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import pl.jutupe.core.repository.entity.Debtor
import pl.jutupe.home.createGroup.LongSelectionTracker
import pl.jutupe.home.databinding.ItemSelectableDebtorBinding
import pl.jutupe.home.debtors.adapter.DebtorAdapter

class SelectableDebtorAdapter : PagingDataAdapter<Debtor, SelectableDebtorViewHolder>(
    DebtorAdapter.DEBTOR_COMPARATOR
) {

    lateinit var selectionTracker: LongSelectionTracker

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SelectableDebtorViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemSelectableDebtorBinding.inflate(inflater, parent, false)
        return SelectableDebtorViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SelectableDebtorViewHolder, position: Int) {
        val debtor = getItem(position)
        holder.bind(debtor, selectionTracker.isSelected(debtor?.debtorId), selectionTracker::onSelected)
    }
}