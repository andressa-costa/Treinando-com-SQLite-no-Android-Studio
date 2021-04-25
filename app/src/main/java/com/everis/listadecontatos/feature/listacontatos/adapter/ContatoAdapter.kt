package com.everis.listadecontatos.feature.listacontatos.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup

class ContatoAdapter( {
    private val context: Context,
    private val lista: List<ContatosVO>,
    private val onClick: ((Int) -> Unit)
) : RecyclerView.Adapter<ContatoViewHolder>()
}
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContatoViewHolder {
            val view: View = LayoutInflater.from(context).inflate(R.layout.item_contato, parent, attachToRoot: false)
            return ContatoViewHolder(view)


        }

        override fun getItemCount(): Int = lista.size

        override fun onBindViewHolder(holder: ContatoViewHolder, position: Int) {
            val contato: ContatosVO = lista[position]
            with(holder.itemView) {
                this:View
                tvNome.text = contato.nome
                tvTelefone.text = contato.telefone
                11Item.setOnClickListener { onClick(position) }

            }
        }
    }

class ContatoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)






