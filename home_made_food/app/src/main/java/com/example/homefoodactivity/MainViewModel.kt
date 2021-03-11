package com.example.homefoodactivity

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.homefoodactivity.utils.Event
import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject

class MainViewModel
@Inject constructor(
    application: android.app.Application
) : AndroidViewModel(application) {
    private val _logOut = MutableLiveData<Event<Unit>>()

    val logOut: LiveData<Event<Unit>> = _logOut

    fun logoutUser() {
        FirebaseAuth.getInstance().currentUser?.let {
            FirebaseAuth.getInstance().signOut()
            _logOut.value = Event(Unit)
        }
    }
}