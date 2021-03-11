package com.example.homefoodactivity

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject

class LifecycleObserver : LifecycleObserver {

    val lifecycle: Observable<Lifecycle.Event>
        get() = _lifecycle
    private val _lifecycle = PublishSubject.create<Lifecycle.Event>()

    @Suppress("UNUSED_PARAMETER")
    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    fun onAny(source: LifecycleOwner, event: Lifecycle.Event) {
        _lifecycle.onNext(event)
    }
}
