package com.example.reciclereview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter

// Adapter responsável por gerenciar a lista de mensagens no RecyclerView
class MensagemAdapter(
    private val lista: List<Mensagem>  // Lista de objetos Mensagem que será exibida
) : Adapter<MensagemAdapter.MensagemViewHolder>() {

    // Classe ViewHolder que mantém referências às views de cada item da lista
    inner class MensagemViewHolder(
        val intemView: View  // View do item individual (inflada do item_lista.xml)
    ) : RecyclerView.ViewHolder(intemView) {
        // Referências para os componentes do layout:
        val textNome: TextView = intemView.findViewById(R.id.textNome)      // TextView para o nome
        val textLastMsg: TextView = intemView.findViewById(R.id.textMsg)    // TextView para a última mensagem
        val textHour: TextView = intemView.findViewById(R.id.texthour)      // TextView para a hora
    }

    // Metodo chamado quando precisa criar um novo ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MensagemViewHolder {
        // Infla o layout do item (item_lista.xml) dentro do parent (RecyclerView)
        val LayoutInflater = LayoutInflater.from(parent.context)
        val intemView = LayoutInflater.inflate(
            R.layout.item_lista, parent, false
        )
        return MensagemViewHolder(intemView)  // Retorna o ViewHolder com a view inflada
    }

    // Retorna o total de itens na lista
    override fun getItemCount(): Int {
        return lista.size
    }

    // Metodo que vincula os dados de um item específico às views do ViewHolder
    override fun onBindViewHolder(mesagemViewHolder: MensagemViewHolder, position: Int) {
        val Mensagem = lista[position]  // Obtém o objeto Mensagem na posição atual

        // Preenche as views com os dados do objeto Mensagem:
        mesagemViewHolder.textNome.text = Mensagem.nome         // Define o nome
        mesagemViewHolder.textLastMsg.text = Mensagem.ultimaMsg // Define a última mensagem
        mesagemViewHolder.textHour.text = Mensagem.hora         // Define a hora
    }
}