package eu.tutorial.thingtheapp.Network

import eu.tutorial.thingtheapp.Model.User
import eu.tutorial.thingtheapp.Network.ApiClient.client
import io.ktor.client.call.body
import io.ktor.client.request.get

class ApiRepository {

    suspend fun getAllUser(): List<User> = client.get(ApiRoutes.USER).body()


}
