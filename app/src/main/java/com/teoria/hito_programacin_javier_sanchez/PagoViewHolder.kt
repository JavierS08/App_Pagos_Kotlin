package com.teoria.hito_programacin_javier_sanchez

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PagoViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
    var tvNombre: TextView =itemView.findViewById(R.id.tv_nombre)
    var tvPago: TextView =itemView.findViewById(R.id.tv_pago)
    var tvConcepto: TextView =itemView.findViewById(R.id.tv_concepto)
    var btnedit:ImageView=itemView.findViewById(R.id.edit)
    var btndel:ImageView=itemView.findViewById(R.id.del)

}