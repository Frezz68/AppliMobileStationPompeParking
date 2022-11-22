package fr.formation.velosnantes.ui.notifications

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import fr.formation.velosnantes.model.Parking

class NotificationsViewModel : ViewModel() {

    private val _parkings = MutableLiveData<List<Parking>>().apply {
        value = ArrayList()
    }
    val parkings: MutableLiveData<List<Parking>> = _parkings
}