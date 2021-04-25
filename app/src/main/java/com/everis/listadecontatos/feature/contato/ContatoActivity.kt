package com.everis.listadecontatos.feature.contato

import android.os.Bundle
import android.view.View
import com.everis.listadecontatos.application.ContatoApplication
import com.everis.listadecontatos.bases.BaseActivity
import com.everis.listadecontatos.feature.listacontatos.Singleton.ContatoSingleton

class ContatoActivity : BaseActivity() {

    private var index: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contato)
        setupToolBar(toolBar, title "Contato", navgationBack: true)
        setupContato()
        btnSalvarContato.setOnClickListener { onClickSalvarContato() }
    }
    private fun setupContato(){
        index = intent.getIntArrayExtra("index", -1)
        if (index == -1){
            btnSalvarContato.visibility = View.GONE
            return
        }
        etNome.setText(ContatoSingleton.lista[index].nome)
        etTelefone.setText(ContatoSingleton.lista[index].telefone)
    }
    private fun onClickSalvarContato(){
        val nome: String = etNome.text.toString()
        val telefone: String = etTelefone.text.toString()
        val contato = ContatosVO(
                id: 0,
                nome,
                telefone
        )
        if(index == -1) {
            ContatoApplication.instance.helperDB.salvarContato(contato)
        }else{
            ContatoSingleton.lista.set(index,contato)
        }
        finish()
    }
    fun onClickExcluirContato(view: View) {
        if(index > -1){
            ContatoSingleton.lista.removeAt(index)
            finish()
        }
    }
}