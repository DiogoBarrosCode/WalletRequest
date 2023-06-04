package dev.card.walletrequest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ConfirmCard : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirm_card)
        val cardId = intent.getStringExtra(CadastroActivity.KEY_CARD).toString()

        val nameCardholder = findViewById<TextView>(R.id.tvnameTitular)

        val cardNumber = findViewById<TextView>(R.id.tvnumberCard)

        val expirationCard = findViewById<TextView>(R.id.tvVenci)

        val cvvCard = findViewById<TextView>(R.id.tvCodseg)

        var cardType = findViewById<TextView>(R.id.tvColorcard)

        var btReturnmain = findViewById<Button>(R.id.btPagemain)

        btReturnmain.setOnClickListener {
            var intentPagemain =  Intent(this,MainActivity::class.java)
            startActivity(intentPagemain)

        }

        val retroconfig : RetroConfig = RetroConfig()
        val service = retroconfig.serviceCard
        cardId?.let {
            service.findByid(cardId).enqueue(object: Callback<Card>{
                override fun onResponse(call: Call<Card>, response: Response<Card>) {
                    val card = response.body()
                    nameCardholder.text = card?.name
                    cardNumber.text = card?.number
                    expirationCard.text = card?.expirationDate
                    cvvCard.text = card?.cvv
                    cardType.text = card?.cardType


                }

                override fun onFailure(call: Call<Card>, t: Throwable) {
                    TODO("404")
                }

            })
        }

    }
}