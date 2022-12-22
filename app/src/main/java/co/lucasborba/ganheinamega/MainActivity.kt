package co.lucasborba.ganheinamega

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar!!.hide()

        // Aqui onde você decide o que o app vai fazer
        setContentView(R.layout.activity_main)

        // Buscar os objetos e ter a referencia deles
        val editText: EditText = findViewById(R.id.edit_number)
        val txtResult: TextView = findViewById(R.id.txt_result)
        val btnGenerate: Button = findViewById(R.id.btn_generate)

        //Opção 1: XML
        //Opção 2: variavel que seja do tipo View.OnClickListener(interface)
        //Opção 3: mais simples possivel - bloco de código que será disparado pelo onClickListener

        btnGenerate.setOnClickListener {

            val text = editText.text.toString()
            numberGenerator(text, txtResult)
        }
    }

    private fun numberGenerator(text: String, txtResult: TextView) {
        if (text.isEmpty()) {
            //Vai dar falha 1
            Toast.makeText(this, "Informe um número entre 6 e 15", Toast.LENGTH_LONG).show()
            return
        }
        val qtd = text.toInt()

        //Vai dar falha 2
        if (qtd < 6 || qtd > 15) {
            Toast.makeText(this, "Informe um número entre 6 e 15", Toast.LENGTH_LONG).show()
            return
        }
        //Sucesso
        val numbers = mutableListOf<Int>()
        val random = java.util.Random()

        while (true) {
            val number = random.nextInt(60)
            numbers.add(number + 1)

            if (numbers.size == qtd) {
                break
            }
        }

        txtResult.text = numbers.joinToString(" - ")

    }
}


//Opção 2: variavel que seja do tipo View.OnClickListener(interface) com método Lambda
//    val buttonClickListener = View.OnClickListener {
//        Log.i("Teste", "Botão clicando!!!")
//    }

//Opção 2: variavel que seja do tipo View.OnClickListener(interface)
//    val buttonClickListener = object : View.OnClickListener {
//        // quem chama o onclick é o próprio SDK do android que dispara apos o evento de touch
//        override fun onClick(p0: View?) {
//            Log.i("Teste", "Botão clicando!!!")
//        }
//Opção 1: XML
//    fun buttonClicked(view: View) {
//        Log.i("Teste", "Botão clicando!!!")
//    }
