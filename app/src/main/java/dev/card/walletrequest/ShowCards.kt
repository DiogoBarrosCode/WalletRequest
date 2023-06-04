package dev.card.walletrequest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ShowCards : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_allcards)
        request()



    }

    private fun request(){

        val configuracao = RetroConfig()
        val service = configuracao.serviceCard
        service.findAll().enqueue(object: Callback<List<Card>> {
            override fun onResponse(call: Call<List<Card>>, response: Response<List<Card>>) {
                Toast.makeText(this@ShowCards,"Ok!",Toast.LENGTH_LONG).show()
                getList(response.body()!!)

            }

            override fun onFailure(call: Call<List<Card>>, t: Throwable) {
                Toast.makeText(this@ShowCards,"404!",Toast.LENGTH_LONG).show()
            }

        })

    }
    private fun getList(listaCard:List<Card>){
        val recycler = findViewById<RecyclerView>(R.id.listContent)
        recycler.adapter = Adapter(listaCard)
    }
}