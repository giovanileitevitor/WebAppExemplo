package br.applabbs.webappexemplo

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_editar.*

class EditarActivity : AppCompatActivity() {

    private lateinit var context: Context

//    companion object {
//        const val TK_Cidade = "cidade"
//        const val TK_Estado = "estado"
//        const val TK_Codigo = "codigo"
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editar)

        initVar()

        initActions()
    }

    fun initVar(){
        context = this@EditarActivity
        val cidade = intent.getStringExtra("TK_Cidade")
        val estado = intent.getStringExtra("TK_Estado")
        val codigo = intent.getStringExtra("TK_Codigo")

        edt_cidade.setText(cidade)
        edt_estado.setText(estado)
        edt_codigo.setText(codigo)

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

