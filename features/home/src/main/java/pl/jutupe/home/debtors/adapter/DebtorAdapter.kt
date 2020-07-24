package pl.jutupe.home.debtors.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pl.jutupe.base.adapter.BindableAdapter
import pl.jutupe.core.model.Debtor
import pl.jutupe.home.databinding.ItemDebtorBinding

class DebtorAdapter : RecyclerView.Adapter<DebtorViewHolder>(), BindableAdapter<Debtor> {

    var adapterItems = listOf<Debtor>()

    override fun setItems(items: List<Debtor>) {
        adapterItems = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DebtorViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemDebtorBinding.inflate(inflater, parent, false)
        return DebtorViewHolder(binding)
    }

    override fun getItemCount(): Int = adapterItems.size

    override fun onBindViewHolder(holder: DebtorViewHolder, position: Int) {
        holder.bind(adapterItems[position])
    }
}