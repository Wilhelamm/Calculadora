package com.example.felipekleiton

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class Activity_2 : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        val textViewHistoricoCompleto: TextView = findViewById(R.id.textViewHistoricoCompleto)

        textViewHistoricoCompleto.text = intent.getStringExtra( "Historico" );
    }

    fun voltarCalculadora(view: View) {
        val textViewHistoricoCompleto: TextView = findViewById(R.id.textViewHistoricoCompleto)
        val intent = Intent(this@Activity_2, MainActivity::class.java);

        intent.putExtra("HistoricoCompleto", textViewHistoricoCompleto.text);
        startActivity(intent);
    }

}
/*

Avaliação oficial 1:

Em dupla

Usar como base o projeto P_02_Activitys

a) 6 pontos por requisitos solicitados abaixo;
b) 4 pontos por perguntas sobre o código fonte feitas no momento da apresentação;

Requisitos:
1 = Tela inicial será a calculadora e na segunda tela será apresentado o histórico.
2 = Clicar em "=" o resultado do display principal deverá ser adicionado no texto "meuTexto"
3 = Botão "C" apenas limpa o display principal, deverá ser criado mais dois botões:
      um para limpar histórico e
      outro para enviar o Histórico para tela 2.


* */