package com.teoria.hito_programacin_javier_sanchez

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var db=DbHelper(this);

//        var pago= ArrayList<Pago>()
        var pago=db.ver()
        val btn_add=findViewById<Button>(R.id.btn_comprar)
        val btn_mostrar=findViewById<Button>(R.id.btn_mostrar)
        val nombre=findViewById<EditText>(R.id.et_name)
        val contexto=findViewById<EditText>(R.id.et_context)
        val precio=findViewById<EditText>(R.id.et_prec)
        val rv=findViewById<RecyclerView>(R.id.rv)
        rv.apply {
            layoutManager=LinearLayoutManager(this@MainActivity)
            adapter=Adaptador(pago,db,context)
        }
        btn_add.setOnClickListener(){
            if(nombre.text.isEmpty() or contexto.text.isEmpty() or precio.text.isEmpty()){
                Toast.makeText(this,"No se introdujeron valores escriba el pago",Toast.LENGTH_LONG).show()
            }else{
                db.insertData(nombre.text.toString(),contexto.text.toString(),precio.text.toString().toInt());
                Toast.makeText(this,"Pago realizado con éito, reinicie la aplicación para ver todos los pagos",Toast.LENGTH_LONG).show()
            }

        }
        btn_mostrar.setOnClickListener(){
            Log.i("lista",pago.toString())
            //rv.layoutManager=LinearLayoutManager(this)
            //rv.adapter=Adaptador(this,pago))
            rv.apply {
                layoutManager=LinearLayoutManager(this@MainActivity)
                adapter=Adaptador(pago,db,context)
            }
        }
    }
}