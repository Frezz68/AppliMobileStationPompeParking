package fr.formation.velosnantes.adapter

import android.content.Context
import android.content.Intent
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import fr.formation.velosnantes.R
import fr.formation.velosnantes.model.Station
import fr.formation.velosnantes.model.currentLocation
import fr.formation.velosnantes.model.stationSelected
import fr.formation.velosnantes.ui.home.HomeFragment
import fr.formation.velosnantes.ui.home.MapsActivity

class StationAdapter(private val stations:List<Station>, private val ctx : Context, private val framgent: HomeFragment) : RecyclerView.Adapter<StationAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardView : CardView = itemView.findViewById(R.id.cardViewPump)
        val name: TextView = itemView.findViewById(R.id.stationName)
        val addresse : TextView = itemView.findViewById(R.id.addresseTextViewPump)
        val status : ImageView = itemView.findViewById(R.id.isOnlineImageView)
        val available : TextView = itemView.findViewById(R.id.availableTextView)
        val distance : TextView = itemView.findViewById(R.id.bikeDistanceTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view_item, parent, false)
        return ViewHolder(view)
    }

    // pour chaque viewItem on alimente la vue
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var station : Station = stations[position]
        holder.name.text = station.name
        holder.addresse.text = station.adresse
        holder.available.text = "\uD83D\uDEB2${station.availableBikes} \uD83D\uDCE3${station.availableBikeStands} ???${station.bikeStands}"
        if(station.availableBikes == 0) {
            holder.name.setTextColor(ctx.getColor(R.color.empty_bike))
        } else {
            holder.name.setTextColor(ctx.getColor(R.color.black))
        }
        if(station.status == "OPEN") {
            holder.status.setImageResource(R.drawable.ic_baseline_radio_button_checked_24)
        } else {
            holder.status.setImageResource(R.drawable.ic_baseline_radio_button_unchecked_24)
        }

        holder.status.setOnClickListener {
            framgent.changeStatusStation(station)
        }

        holder.cardView.setOnClickListener {
            val intent : Intent = Intent(ctx, MapsActivity::class.java)
            stationSelected = station
            ctx.startActivity(intent)
        }

        if(currentLocation != null) {
            holder.distance.text = String.format("%.2f", currentLocation!!.distanceTo(station.toLocation()) / 1000) + "KM"
        } else {

        }
    }

    // return stations size
    override fun getItemCount(): Int {
        return stations.size;
    }
}