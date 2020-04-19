package com.example.appcalculocuotas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.applistado.CuotaAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var adapter: CuotaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        butCalcular.setOnClickListener(this)
        llenarSpinnerNumeroCoutoas()
        llenarSpinnerNumeroTarjetas()


        setupRecyvlerView()

    }


    fun setupRecyvlerView() {
        rviPagos.layoutManager = LinearLayoutManager(this)
        adapter = CuotaAdapter(ArrayList())
        rviPagos.adapter = adapter


    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.butCalcular -> {
                var number1 = ""
                var monto = eteMonto.text
                val cuotas = spiNumeroCuotas.selectedItem.toString()

                if (monto.isNotEmpty()) {
                    number1 = monto.toString()
                    val int1: Double = number1.toDouble()
                    val int2: Int = cuotas.toInt()
                    val double1: Double = int2.toDouble()
                    val result = int1 / double1
                    addList(int2, "${result}")

                } else {
                    Toast.makeText(this, "Ingrese monto", Toast.LENGTH_LONG).show()
                }
            }
        }
    }


    private fun llenarSpinnerNumeroCoutoas() {
        val lstMeses: MutableList<String> = ArrayList()
        lstMeses.add("1")
        lstMeses.add("2")
        lstMeses.add("3")
        lstMeses.add("4")
        lstMeses.add("5")
        lstMeses.add("6")
        lstMeses.add("7")
        val dataAdapter =
            ArrayAdapter(applicationContext, android.R.layout.simple_spinner_item, lstMeses)
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spiNumeroCuotas.adapter = dataAdapter
    }

    private fun llenarSpinnerNumeroTarjetas() {
        val lstMeses: MutableList<String> = ArrayList()
        lstMeses.add("Visa")
        lstMeses.add("Mastercard")
        val dataAdapter =
            ArrayAdapter(applicationContext, android.R.layout.simple_spinner_item, lstMeses)
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spiTarjetas.adapter = dataAdapter
    }


    fun addList(index: Int, detalle: String) {


        val arrayProduct: MutableList<Pago> = ArrayList()

        for (num in 1..index) {
            arrayProduct.add(Pago(
                "Cuota numero ${num} - ${detalle}",
                R.drawable.ic_attach_money_black_24dp
            ))
        }

        adapter.actualizarUI(arrayProduct)



        /*rviPagos.layoutManager = LinearLayoutManager(this)
        val lstMeme: MutableList<Pago> = java.util.ArrayList()
        for (num in 1..index) {
            lstMeme.add(
                Pago(
                    "Cuota numero ${num} - ${detalle}",
                    R.drawable.ic_attach_money_black_24dp
                )
            )
        }
        val adapter = CuotaAdapter(lstMeme)
        rviPagos.adapter = adapter*/
    }
}





