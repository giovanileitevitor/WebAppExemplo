package br.applabbs.webappexemplo.View

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import br.applabbs.webappexemplo.Model.Adapter
import br.applabbs.webappexemplo.Model.Modelo
import br.applabbs.webappexemplo.R
import kotlinx.android.synthetic.main.activity_lista.*
import okhttp3.*
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException


class ListaActivity : AppCompatActivity() {

    private lateinit var context : Context
    private lateinit var listView_details: ListView

    var arrayList_details : ArrayList<Modelo> = ArrayList()
    val client = OkHttpClient()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista)

        initVars()

        initActions()

    }


    private fun initVars(){
        context = this@ListaActivity

        listView_details = findViewById<ListView>(R.id.lv_cidades) as ListView

        //Endereço do JSON que será consumido pelo app
        run("http://relatorios.spotpromo.com.br/teste/mobile/jsonTest.php")
    }


    private fun initActions(){
        //btn_voltar
        btn_voltar.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

    }


    private fun run(url : String) {

        val request = Request.Builder().url(url).build()

        client.newCall(request).enqueue(object : Callback {

            override fun onFailure(call: Call, e: IOException) {
                //em caso de falha na leitura
                //exibe um toast
            }

            override fun onResponse(call: Call, response: Response) {
                var str_response = response.body!!.string()
                val json_contact : JSONObject = JSONObject(str_response)
                var jsonarray_info: JSONArray = json_contact.getJSONArray("CIDADES")
                var i : Int = 0
                var size:Int = jsonarray_info.length()

                arrayList_details = ArrayList()

                //Faz um loop pra varrer todo o objeto JSON [cidades]
                for (i in 0.. size - 1) {
                    var json_objectdetail:JSONObject = jsonarray_info.getJSONObject(i)
                    var model: Modelo = Modelo()
                    model.cidade = json_objectdetail.getString("cidade")
                    model.estado = json_objectdetail.getString("uf")
                    model.codigo = json_objectdetail.getString("codCidade")

                    //Adiciona os objetos encontrados dentro da String
                    arrayList_details.add(model)
                }

                runOnUiThread {
                    //Atualiza a lista usando o adapter
                    val obj_adapter : Adapter
                    obj_adapter = Adapter(applicationContext, arrayList_details)
                    listView_details.adapter = obj_adapter
                }

            }
        })
    }

}
