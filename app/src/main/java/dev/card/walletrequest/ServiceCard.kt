package dev.card.walletrequest

import android.telephony.mbms.StreamingServiceInfo
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ServiceCard {

    @GET("cards")
    fun findAll(): Call<List<Card>>

    @GET("cards/{id}")
    fun findByid(@Path("id") cardId: String):Call<Card>

    @POST("cards/")
    fun createCard(@Body card:Card) : Call<Card>

    @PUT("cards/{id}")
    fun updateCard(@Path("id") cardId: String,@Body card:Card): Call<Card>

    @DELETE("cards/{id}")
    fun deleteById(@Path("id") CardId:String) : Call<Card>

    @DELETE("cards/")
    fun deleteAll() : Call<Any>

}