package com.example.applistado


import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.appcalculocuotas.Pago
import com.example.appcalculocuotas.R
import com.pe.listadoLis.util.inflate
import kotlinx.android.synthetic.main.item_cuota.view.*


class CuotaAdapter(private var arrayMeme: MutableList<Pago>) :
    RecyclerView.Adapter<CuotaAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //Este metodo hace la relacion con el layout del item

        val inflatedView = parent.inflate(R.layout.item_cuota, false)

        return ViewHolder(inflatedView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //Este metodo itera de acuerdo a lo que indicas en el metodo getItemCount
        val meme = arrayMeme[position]
        holder.binMeme(meme)


    }

    override fun getItemCount(): Int {
        //Aqui indicas cuantas filas tendra tu RecyclerView
        return arrayMeme.size
    }


    class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) ,View.OnClickListener{
        private lateinit var pago: Pago

        init {
            view.tviCuotaDetalle.setOnClickListener(this)
        }

        fun binMeme(meme:Pago){
            this.pago=meme
            view.tviCuotaDetalle.text=meme.detalle
            view.iviLogo.setImageDrawable(view.resources.getDrawable(pago.imagen))

        }

        override fun onClick(v: View?) {
            Toast.makeText(view.context,"CLik ITEM ${pago.detalle}",Toast.LENGTH_LONG).show()
        }


    }

}

