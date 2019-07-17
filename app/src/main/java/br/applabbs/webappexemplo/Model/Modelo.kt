package br.applabbs.webappexemplo.Model

//Modelo de dados que será recebido no request

class Modelo{
    lateinit var cidade : String
    lateinit var estado : String
    lateinit var codigo : String


    constructor(cidade : String, estado : String, codigo : String ) {
        this.cidade = cidade
        this.estado = estado
        this.codigo = codigo
    }

    constructor()
}