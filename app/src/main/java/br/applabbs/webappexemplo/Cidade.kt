package br.applabbs.webappexemplo

class Cidade(
    var cidade: String = "",
    var estado: String = "",
    var codigo: Int = 0
) {

    override fun toString(): String {
        return cidade
    }

    fun toHMAux(): HMAux {
        var hmAux = HMAux()

        hmAux[HMAux.CIDADE] = cidade
        hmAux[HMAux.ESTADO] = estado
        hmAux[HMAux.CODIGO] = codigo.toString()

        return hmAux
    }
}