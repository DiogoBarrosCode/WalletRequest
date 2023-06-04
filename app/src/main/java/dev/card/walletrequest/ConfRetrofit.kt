package dev.card.walletrequest

import android.service.carrier.CarrierService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RetroConfig {
    val retroConf = Retrofit.Builder().baseUrl("https://wallet-backend-theta.vercel.app/").addConverterFactory(GsonConverterFactory.create())
        .build()
    val serviceCard:ServiceCard = retroConf.create(ServiceCard::class.java)
}