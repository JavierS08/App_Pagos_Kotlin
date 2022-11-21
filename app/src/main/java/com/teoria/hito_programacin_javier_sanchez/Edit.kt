package com.teoria.hito_programacin_javier_sanchez

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Edit : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
        var db=DbHelper(this);

        val btn_act=findViewById<Button>(R.id.btn_actualizar)
        val id=findViewById<EditText>(R.id.et_id)
        val nombre=findViewById<EditText>(R.id.et_name1)
        val contexto=findViewById<EditText>(R.id.et_context1)
        val precio=findViewById<EditText>(R.id.et_prec1)

        btn_act.setOnClickListener() {

            if (id.text.isEmpty() or nombre.text.isEmpty() or contexto.text.isEmpty() or precio.text.isEmpty()) {
                Toast.makeText(this, "Algunos campos quedaron incompletos, rellenelos", Toast.LENGTH_LONG).show()
            }
            else{
                val idc = id.text.toString().toInt()
                val nom = nombre.text.toString()
                val cont = contexto.text.toString()
                val precioc = precio.text.toString().toInt()
                db.edit(idc, nom, cont, precioc)
                Toast.makeText(this, "Producto Editado con exito", Toast.LENGTH_LONG).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }
}