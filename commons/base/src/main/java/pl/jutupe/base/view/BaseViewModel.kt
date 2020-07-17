package pl.jutupe.base.view

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import pl.jutupe.base.util.weak

abstract class BaseViewModel<N> : ViewModel() {

    val disposables: CompositeDisposable = CompositeDisposable()
    var navigator: N? by weak()

    override fun onCleared() {
        super.onCleared()

        disposables.dispose()
    }
}