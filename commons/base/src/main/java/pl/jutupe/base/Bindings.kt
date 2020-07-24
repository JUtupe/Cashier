package pl.jutupe.base

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import pl.jutupe.base.adapter.BindableAdapter
import timber.log.Timber

@BindingAdapter("items")
@Suppress("UNCHECKED_CAST")
fun <T> setItems(view: RecyclerView, items: List<T>?) {
    val adapter = view.adapter

    if (adapter is BindableAdapter<*>) {
        (adapter as BindableAdapter<T>).setItems(items ?: emptyList())
    } else {
        Timber.e("tried to bind items to non-bindable adapter")
    }
}