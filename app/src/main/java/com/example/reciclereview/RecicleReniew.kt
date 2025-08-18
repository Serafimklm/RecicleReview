package com.example.reciclereview

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecicleReniew : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    private lateinit var rvLista: RecyclerView  // Declaração do RecyclerView (interliga com o layout XML)

    private lateinit var mesagemAdapter: MensagemAdapter  // Adapter personalizado (interliga com a classe MensagemAdapter abaixo)
    private lateinit var buttonnovo: Button  // Botão para adicionar itens (interliga com o onClickListener)

    override fun onStart() {
        super.onStart()
        dataDir  // [OBS: Esta linha parece não ter utilidade no código atual]
    }

    @SuppressLint("MissingInflatedId", "SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recicle_reniew)

        // LISTA DE DADOS - Fonte dos itens que serão exibidos no RecyclerView
        val lista = mutableListOf(
            Mensagem("joao", "oi", "12:00"),
            Mensagem("carlos", "hi boddy", "13:00"),
            Mensagem("roberto", "oi", "12:00"),
            Mensagem("rafael", "rafael", "12:00")
        )

        // INICIALIZAÇÃO DO RECYCLERVIEW - Obtém a referência do XML e configura propriedades
        rvLista = findViewById(R.id.Rview)  // Interliga com o ID no layout
        buttonnovo = findViewById(R.id.addNovo)  // Botão para adicionar novos itens

        // CONFIGURAÇÃO DO ADAPTER - Cria o adapter e define o comportamento de clique
        mesagemAdapter = MensagemAdapter {
            // Comportamento quando um item é clicado (interliga com a função clique no adapter)
            Toast.makeText(this, "Abrindo a activity", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, LinearLayoutActivity2::class.java))
        }

        // CARREGA OS DADOS INICIAIS - Passa a lista para o adapter (interliga com AtualizarListaDados)
        mesagemAdapter.AtualizarListaDados(lista)

        // OTIMIZAÇÕES DO RECYCLERVIEW
        rvLista.setHasFixedSize(true)
        rvLista.setItemViewCacheSize(20)
        rvLista.adapter = mesagemAdapter  // Vincula o adapter ao RecyclerView

        // DEFINE O LAYOUT MANAGER - Controla como os itens são organizados
        rvLista.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        // BOTÃO PARA ADICIONAR NOVOS ITENS - Interação principal do usuário
        buttonnovo.setOnClickListener {

            mesagemAdapter.executarOperacao()

            // Adiciona novo item à lista (interliga com a lista mutável)
//            lista.add(Mensagem("PEDROCA ATUALIZADO", "'E RUIM DE ATURAR", "13:00"))
            Toast.makeText(this, "ATUALIZANDO", Toast.LENGTH_SHORT).show()
            // Atualiza o adapter com a nova lista (interliga com AtualizarListaDados)
            mesagemAdapter.AtualizarListaDados(lista)
        }
    }
}
