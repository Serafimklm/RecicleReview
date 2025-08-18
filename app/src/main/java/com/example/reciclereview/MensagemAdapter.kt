package com.example.reciclereview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
// CLASSE DO ADAPTER - Responsável por gerenciar a exibição dos itens
class MensagemAdapter(
    private val clique: () -> Unit  // Função de clique (interliga com o comportamento na Activity)
) : Adapter<MensagemAdapter.MensagemViewHolder>() {

    // LISTA INTERNA - Armazena os dados que serão exibidos (interliga com AtualizarListaDados)
    private var listaMensagem = mutableListOf<Mensagem>()

    fun executarOperacao (){
//        0 = joao
//        1 = carlos
//        2 = roberto
//        3 = rafael
//
        // ==================removendo o item 1 da lista=====================
        listaMensagem.removeAt(1)
        // notificando o adapter que o item foi removido
        notifyItemRemoved(1)


//       =================MUDANDO POSICAO DO INDICIE=======================
//        mundando os indicies na posicao 0 e posicao 1,
 /*       listaMensagem[0] = Mensagem("joao neves", "deu todo certo", "12.22")
        listaMensagem[1] = Mensagem("marcio Fraco", "ola como vao", "22:21")
//        notifica o adaper da atualização
        notifyItemRangeChanged(0, 2) // começa na posicao 0 e atualiza 2 itens
*/

    // =============atualizando um item especifico da lista de item e define a posicao como zero==========
        /*   listaMensagem[0] = Mensagem("joao neves", "deu todo certo", "12.22")

        //notificando o adapter que a lista deve ser atualizada
        notifyItemChanged(0);*/


   /*     listaMensagem.add(
            // index = 0,  //serve para definir a  posicao do topo para o fim do novo item, pra isso tambem
//             notifyItemInserted(0) deve estar definido assim tambem para que seja possivel
            Mensagem("joao novo ctt", "ola como vai vc", "22:23")
        )*/
//        notifyItemInserted(listaMensagem.size)// usando o tamanho da lista para definir a posição do novo item


      // para adcionar varios simultaniamente, trocasse notifyInserted por Range=  notifyItemRangeInserted(0, 4);
    }


    // MeTODO PARA ATUALIZAR OS DADOS - Chamado pela Activity quando a lista muda
    fun AtualizarListaDados(lista: MutableList<Mensagem>) {
        listaMensagem = lista  // Atualiza a referência da lista (cuidado: veja observação abaixo)
        notifyDataSetChanged()  // Notifica o RecyclerView que os dados mudaram
    }

    // VIEWHOLDER - Define a estrutura de cada item (interliga com o layout item_cardview.xml)
    inner class MensagemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textNome: TextView = itemView.findViewById(R.id.TextNomeCard)  // Nome
        val textLastMsg: TextView = itemView.findViewById(R.id.TextmsgCard)  // Mensagem
        val ImagePerfil: ImageView = itemView.findViewById(R.id.imagePerfil)  // Imagem
    }

    // CRIA NOVAS VIEWS - Chamado quando precisa de novos itens visíveis
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MensagemViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_cardview, parent, false)  // Infla o layout do item
        return MensagemViewHolder(itemView)
    }

    // RETORNA A QUANTIDADE DE ITENS - Usado pelo RecyclerView
    override fun getItemCount(): Int = listaMensagem.size

    // VINCULA DADOS ÀS VIEWS - Chamado para cada item visível
    override fun onBindViewHolder(holder: MensagemViewHolder, position: Int) {
        val mensagem = listaMensagem[position]
        holder.textNome.text = mensagem.nome
        holder.textLastMsg.text = mensagem.ultimaMsg

        // CONFIGURA O CLIQUE - Interliga com a função passada no construtor
        holder.ImagePerfil.setOnClickListener { clique() }
    }
}

/*
OBSERVAÇÃO IMPORTANTE SOBRE AtualizarListaDados:
O metodo atual está apenas trocando a referência (listaMensagem = lista), o que pode causar problemas.
O ideal seria usar listaMensagem.clear() seguido de listaMensagem.addAll(lista) para garantir
que a mesma lista é mantida e apenas seu conteúdo é atualizado.
*/