package fr.formation.velosnantes.api

import fr.formation.velosnantes.model.Pump
import retrofit2.Response
import retrofit2.http.GET

interface PumpApi {
    @GET("/api/pumps")
    suspend fun getStations() : Response<List<Pump>>
}