package br.applabbs.webappexemplo.View

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.applabbs.webappexemplo.R
import kotlinx.android.synthetic.main.activity_editar.*

class EditarActivity : AppCompatActivity() {

    private lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editar)

        initVar()

        initActions()
    }

    fun initVar(){
        context = this@EditarActivity

        val dados: Bundle = intent.extras

        edt_cidade.setText(dados.getString("TK_Cidade"))
        edt_estado.setText(dados.getString("TK_Estado"))
        edt_codigo.setText(dados.getInt("TK_Codigo"))

        btn_salvar_alteracoes.requestFocus()
    }

    fun initActions(){

        btn_salvar_alteracoes.setOnClickListener {
            //TODO - Flavio
            //Implementar a rotina para salvar o dado localmente
            //Depois de salvo, carregar a activity anterior (ListaActivity)
            startActivity(Intent(this, ListaActivity::class.java))
        }

        btn_sair.setOnClickListener {
            //TODO - Flavio
            //Não irá atualizar os dados no banco
            //Depois vai carregar a activity anterior (ListaActivity)
            startActivity(Intent(this, ListaActivity::class.java))
        }

    }


}

