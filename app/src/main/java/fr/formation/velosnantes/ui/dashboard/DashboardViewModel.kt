package fr.formation.velosnantes.ui.dashboard

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import fr.formation.velosnantes.model.Pump

class DashboardViewModel : ViewModel() {

    private val _pumps = MutableLiveData<List<Pump>>().apply {
        value = ArrayList()
    }
    val pumps: MutableLiveData<List<Pump>> = _pumps
}