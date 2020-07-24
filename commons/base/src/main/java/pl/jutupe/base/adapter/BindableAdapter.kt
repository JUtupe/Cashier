package pl.jutupe.base.adapter

interface BindableAdapter<T> {
    fun setItems(items: List<T>)
}