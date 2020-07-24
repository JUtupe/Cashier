package pl.jutupe.base.view

import androidx.lifecycle.ViewModel
//import io.reactivex.disposables.CompositeDisposable
import pl.jutupe.base.weak

abstract class BaseViewModel<N> : ViewModel() {

    var navigator: N? by weak()
}