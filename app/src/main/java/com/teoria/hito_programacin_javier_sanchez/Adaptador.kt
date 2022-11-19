package com.teoria.hito_programacin_javier_sanchez

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class Adaptador(private val listPagos: ArrayList<Pago>,val db:DbHelper,val mContext: Context) :
    RecyclerView.Adapter<PagoViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_pago, parent, false)
        return PagoViewHolder(view)

    }

    override fun onBindViewHolder(holder: PagoViewHolder, position: Int) {
        val pago = listPagos[position]
        holder.tvNombre.text = pago.nombre
        holder.tvPago.text = pago.precio.toString()
        holder.tvConcepto.text = pago.contexto
        holder.btnedit.setOnClickListener{
            val intent = Intent(mContext, Edit::class.java)
            mContext.startActivity(intent)
        }
        holder.btndel.setOnClickListener{
            db.delete(pago)
            listPagos.remove(pago)
            Toast.makeText(holder.btndel.context,"Pago eliminado con exito reinicie la aplicación para guardar los cambios",Toast.LENGTH_LONG).show()
        }
    }

    override fun getItemCount(): Int {
        return listPagos.size
    }
}

