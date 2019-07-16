package br.applabbs.webappexemplo

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SimpleAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_lista.*
import java.net.URL

class ListaActivity : AppCompatActivity() {

    private lateinit var context : Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista)

        initVars()

        initActions()

    }

    fun initVars(){
        context = this@ListaActivity

        val De = arrayOf(HMAux.CIDADE, HMAux.ESTADO, HMAux.CODIGO)
        val Para = intArrayOf(R.id.celula_tv_cidade, R.id.celula_tv_estado, R.id.celula_tv_codigo)

        lv_cidades.adapter = SimpleAdapter(
            context,
            genProd(20),
            R.layout.celula,
            De,
            Para
        )

    }

    fun initActions(){
        //btn_voltar
        btn_voltar.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }


        //btn_apagar
        btn_apagar.setOnClickListener {

        }

        lv_cidades.setOnItemClickListener { parent, view, position, id ->
            var item = parent.getItemAtPosition(position) as HMAux

            //Carregar o objeto da lista para a outra activity
            Toast.makeText(context, item[HMAux.CIDADE],Toast.LENGTH_SHORT).show()

            val intent = Intent(this,EditarActivity::class.java);
            intent.putExtra("TK_Cidade", item[HMAux.CIDADE])
            intent.putExtra("TK_Estado", item[HMAux.ESTADO])
            intent.putExtra("TK_Codigo", item[HMAux.CODIGO])

            startActivity(intent)
        }

    }

    private fun genProd(quantidade: Int): ArrayList<HMAux> {
        var cidades = ArrayList<HMAux>()
        //
        for (i in 1..quantidade) {
            var pAux = Cidade()

            pAux.cidade = "Cidade - $i"
            pAux.estado = "Estado -> $i"
            pAux.codigo = i+10

            cidades.add(pAux.toHMAux())
        }
        //
        return cidades
    }


}
