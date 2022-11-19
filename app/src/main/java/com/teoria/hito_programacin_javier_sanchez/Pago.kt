package com.teoria.hito_programacin_javier_sanchez

class Pago {
    var id:Int
    var nombre:String
    var contexto:String
    var precio:Int
    internal constructor(id:Int,nombre:String,contexto:String,precio:Int){
        this.id=id
        this.nombre=nombre
        this.contexto=contexto
        this.precio=precio
    }
}