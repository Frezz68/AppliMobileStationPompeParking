package fr.formation.velosnantes.api

import fr.formation.velosnantes.model.Parking
import retrofit2.Response
import retrofit2.http.GET

interface ParkingApi {
    @GET("/api/parkings")
    suspend fun getParkings() : Response<List<Parking>>
}