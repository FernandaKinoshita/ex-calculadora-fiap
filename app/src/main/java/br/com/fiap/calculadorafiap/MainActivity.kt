package br.com.fiap.calculadorafiap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    lateinit var edtNumero01 : EditText  //criando variável do tipo EditTtext(com valor nulo), incluído após a construcao no xml
    lateinit var edtNumero02 : EditText
    lateinit var txtResultado : TextView    // criando variável do tipo TextView (com valor nulo), incluído após a
                                            // construcao no xml, para facilitar o código, não precisa ficar olhando o xml
    //a inicialização das variáveis acima será no OnCreate, após o (R.layout.activity_main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //inicializando a variáveis, ligando o Kotler com o xml (essa variável representa essa View no xml)
        edtNumero01 = findViewById(R.id.edtNumero01)
        edtNumero02 = findViewById(R.id.edtNumero02)
        txtResultado = findViewById(R.id.textResultado)

    }

    //funcão validar número(recebe str numero do tipo String, retorna Verdadeiro ou Falso
    fun validarNumero(strNumero : String) : Boolean{
        if (strNumero.trim().isEmpty()){
            Toast.makeText(
                    this, "Informe corretamente os números no formulário!",
                    Toast.LENGTH_SHORT
            ).show()

            return false
        }

        return true
    }

    //funçao que valida por completo
    // 1 -> não
    fun validar(strNumero01 : String, strNumero02 : String) : Boolean {
        return validarNumero(strNumero01) && validarNumero(strNumero02)
        }


   // essa funcao veio do xml (on click)
   //criando a variável para validar a funcao somar, tipo str
    fun somar(view: View) {
       val strNumero01 = edtNumero01.text.toString()
       val strNumero02 = edtNumero02.text.toString()

       if ( ! validar(strNumero01, strNumero02)){
           return
       }

       try {
           val numero01 = strNumero01.toInt()
           val numero02 = strNumero02.toInt()

           //fazendo a soma
           val soma = numero01 + numero02
            //Exibir o resultado no TextView
           txtResultado.text = "A soma é: ${soma}"

       }catch (e:Exception){ //Qualquer erro que acontecer apresente a msg abaixo
           Toast.makeText(
                   this,
                   "Não foi possível realizar a soma com os dados informados",
                   Toast.LENGTH_SHORT
           ).show()

       }

    }


}