package com.teoria.hito_programacin_javier_sanchez

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btn_log=findViewById<Button>(R.id.btn_reg)
        var user=findViewById<EditText>(R.id.et_user)
        var pass=findViewById<EditText>(R.id.et_pass)
        btn_log.setOnClickListener(){
            if (user.text.toString().isEmpty() and pass.text.toString().isEmpty() or user.text.toString().isEmpty() or pass.text.toString().isEmpty()){
                Toast.makeText(this,"No se han rellenado todas las cajas de texto, por favor rellenelas",
                    Toast.LENGTH_LONG).show()
            }
            else{
                val intent= Intent(this,MainActivity::class.java)
                startActivity(intent);
            }
        }

    }
}