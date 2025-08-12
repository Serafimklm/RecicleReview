package com.example.reciclereview

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecicleReniew : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    private lateinit var rvLista: RecyclerView  // Declaração do RecyclerView

    @SuppressLint("MissingInflatedId", "SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()  // Habilita edge-to-edge display (barras de sistema sobre o conteúdo)
        setContentView(R.layout.activity_recicle_reniew)  // Define o layout da activity

        // Criação da lista de mensagens estática para exemplo
        val lista = listOf(
            Mensagem("joao", "oi", "12:00"),
            Mensagem("carlos", "hi boddy", "13:00"),
            Mensagem("roberto", "oi", "12:00"),
            Mensagem("rafael", "rafael", "12:00")
        )

        // Inicialização do RecyclerView a partir do layout
        rvLista = findViewById(R.id.Rview)  // Obtém referência do RecyclerView no layout

        // Configuração do Adapter com a lista de mensagens
        rvLista.adapter = MensagemAdapter(lista)  // Define o adapter personalizado

        // Configuração do LayoutManager (define como os itens serão organizados)
        // Layout linear (vertical por padrão), reverse serve para começar de baixo para cima, recile para ficar reciclavel
        rvLista.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        //colocar em grade dentro do recyclerView
     //rvLista.layoutManager = GridLayoutManager(this, 2)  // Layout em grade)
        // Observação: O código original tinha um comentário "rvLista.layoutManager" solto
        // que foi mantido como parte da documentação do processo de desenvolvimento


    }
}