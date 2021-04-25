package com.everis.listadecontatos.feature.listacontatos

import android.content.Intent
import androidx.recyclerview.widget.LinearLayoutManager
import com.everis.listadecontatos.application.ContatoApplication
import com.everis.listadecontatos.bases.BaseActivity
import com.everis.listadecontatos.feature.listacontatos.Singleton.ContatoSingleton
import com.everis.listadecontatos.feature.listacontatos.adapter.ContatoAdapter
import com.everis.listadecontatos.feature.listacontatos.model.ContatosVO

class MainActivity : BaseActivity () {

    private var adapter:ContatoAdapter? = null

    Override fun onCreate(savedinstanceState: Bundle? ) {
        super.onCreate(savedinstanceState)
        setContentView(R.layout.activity_main)
        geralListaDeContatos()
        setupToolBar(toolBar, "Lista de contatos", false)
        setupListView ()
        setupOnClicks ()
    }

    private fun setupOnClicks() {
        setupOnClicks()
        fab.setOnClickListener { onClickAdd() }
        ivBuscar.setOnClickListener { onClickBucar() }

    }

    private fun setupListView() {
        recyclerView.layoutManager = LinearLayoutManager (this)
        adapter = ContatoAdapter( this, ContatoSingleton.lista) {onClickItemRecyclerView(it)}
        recyclerView.adapter = adapter

    }

    private fun geralListaDeContatos() {

        ContatoSingleton.lista.add(ContatosVO( id: 1, nome: "Fulano", telefone: "(00)9900-0001"))
        ContatoSingleton.lista.add(ContatosVO( id: 2, nome: "Ciclano", telefone: "(00)9900-0002"))
        ContatoSingleton.lista.add(ContatosVO( id: 3, nome: "Vinicius", telefone: "(00)9900-0003"))
    }

    Override fun onResume() {
        super.onResume
        adapter?.notifyDataSetChanged()
    }


    private fun onClickAdd() {
        val intent = Intent( this,ContatoActivity::class.java)
        startActivity(intent)

    }
    private fun onClickItemRecyclerView(index: Int) {
        val intent = Intent( this,ContatoActivity::class.java)
        val putExtra = intent.putExtra( name: index, index)


    }
    private fun onClickBuscar(){
        val busca:String = etBuscar.text.toString()
        var listaFiltrada: List<ContatosVO> = mutableListOf()
       try {
           listaFiltrada = ContatoApplication.instance.helperDB?.buscarContatos(busca) ?: mutableListOf()
       }catch (ex: Exception){
           ex.printStackTrace()
        }
        adapter = ContatoAdapter( context: this,listaFiltrada) {onClickItemRecyclerView(it)}
        recyclerView.adapter = adapter
        Toast.makeText( context: this, text: "Buscando por $busca", Toast.LENGTH_SHORT).show()

    }
class ContatoActivity {

}


}

object id {

}

object nome {

}
