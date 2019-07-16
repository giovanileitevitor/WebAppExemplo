package br.applabbs.webappexemplo

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var context: Context
    private lateinit var enderecoBase: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        initVars()

        initActions()
    }

    fun initVars(){
        context = this@MainActivity
        edt_url.setText("Http://relatorios.espotpromo.com.br/teste/mobile/jsonTeste.php")

    }

    fun initActions(){
        //edt_url
        //btn_carregar

        //Verificar se a URL é valida (não é nula, não é vazia e possui mais de 10caracteres)
        //montar o objeto de consulta
        //receber o objeto de consulta
        //Chamar a proxima tela (activity) e passar o objeto como parametro via bundle
        //Na outra tela, o objeto será exibido no listview
        //Implementar o clique no elemento do listview
        //Montar a tela de edição e a chamada de reload

        btn_carregar.setOnClickListener {
            //Faz a leitura do EditText da tela
            enderecoBase = edt_url.text.toString()

            //Testa se o Endereço é Valido
            if(!enderecoBase.isNullOrBlank()){
                Toast.makeText(this, "Endereço URL válido.", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, ListaActivity::class.java))
            }
            else{
                Toast.makeText(this, "Endereço URL INVÁLIDO.", Toast.LENGTH_SHORT).show()

            }
        }

    }
}
