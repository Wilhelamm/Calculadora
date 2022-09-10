package com.example.felipekleiton

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Botões
        var button0: Button = findViewById(R.id.button0);
        var button1: Button = findViewById(R.id.button1);
        var button2: Button = findViewById(R.id.button2);
        var button3: Button = findViewById(R.id.button3);
        var button4: Button = findViewById(R.id.button4);
        var button5: Button = findViewById(R.id.button5);
        var button6: Button = findViewById(R.id.button6);
        var button7: Button = findViewById(R.id.button7);
        var button8: Button = findViewById(R.id.button8);
        var button9: Button = findViewById(R.id.button9);
        var buttonLimpar: Button = findViewById(R.id.buttonLimpar);
        var buttonExcluir: Button = findViewById(R.id.buttonExcluir);
        var buttonDividir: Button = findViewById(R.id.buttonDividir);
        var buttonMultiplicar: Button = findViewById(R.id.buttonMultiplicar);
        var buttonSubtrair: Button = findViewById(R.id.buttonSubtrair);
        var buttonSomar: Button = findViewById(R.id.buttonSomar);
        var buttonIgual: Button = findViewById(R.id.buttonIgual);
        var buttonVirgula: Button = findViewById(R.id.buttonVirgula);
        var textViewVisor: TextView = findViewById(R.id.textViewVisor);
        var textViewHistorico: TextView = findViewById(R.id.textViewHistorico);
        var buttonHistoricoEnviar: TextView = findViewById(R.id.buttonHistoricoEnviar);
        var buttonHistoricoLimpar: TextView = findViewById(R.id.buttonHistoricoLimpar);

        //Números
        button0.setOnClickListener { adicionarValor("0"); }
        button1.setOnClickListener { adicionarValor("1"); }
        button2.setOnClickListener { adicionarValor("2"); }
        button3.setOnClickListener { adicionarValor("3"); }
        button4.setOnClickListener { adicionarValor("4"); }
        button5.setOnClickListener { adicionarValor("5"); }
        button6.setOnClickListener { adicionarValor("6"); }
        button7.setOnClickListener { adicionarValor("7"); }
        button8.setOnClickListener { adicionarValor("8"); }
        button9.setOnClickListener { adicionarValor("9"); }

        //Operadores
        buttonLimpar.setOnClickListener { textViewVisor.text = "" }
        buttonExcluir.setOnClickListener { excluirValor(textViewVisor.text.toString()) }
        buttonDividir.setOnClickListener { adicionarValor(" / "); }
        buttonMultiplicar.setOnClickListener { adicionarValor(" * "); }
        buttonSomar.setOnClickListener { adicionarValor(" + "); }
        buttonSubtrair.setOnClickListener { adicionarValor(" - "); }
        buttonIgual.setOnClickListener { resultado(textViewVisor.text.toString()); }
        buttonVirgula.setOnClickListener { adicionarValor(","); }

        //Histórico
        buttonHistoricoEnviar.setOnClickListener {
            val intent = Intent(this@MainActivity, Activity_2::class.java);
            intent.putExtra("Historico", textViewHistorico.text);
            startActivity(intent);
        }

        buttonHistoricoLimpar.setOnClickListener { textViewHistorico.text = "" }

        textViewHistorico.text = intent.getStringExtra( "HistoricoCompleto" );
    }

    fun excluirValor(string: String) {
        if (string.isNotBlank()) {
            var expressao: TextView = findViewById(R.id.textViewVisor);
            expressao.text = string.substring(0, string.length - 1);
        }
    }

    fun adicionarValor(valor: String) {
        var expressao: TextView = findViewById(R.id.textViewVisor);
        expressao.append(valor);
    }

    fun resultado(string: String) {
        var textViewVisor: TextView = findViewById(R.id.textViewVisor);
        var resultado: TextView = findViewById(R.id.textViewHistorico);

        var x = ExpressionBuilder(string.replace(",", ".")).build().evaluate();

        resultado.text = resultado.text.toString() + "\r\n" + "$string = $x";

        textViewVisor.text = x.toString();
    }

}