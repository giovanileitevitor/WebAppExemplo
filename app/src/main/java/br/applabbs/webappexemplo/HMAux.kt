package br.applabbs.webappexemplo

class HMAux : HashMap<String, String>() {

    override fun toString(): String {
        return this[CIDADE] ?: "ERROR"
    }

    companion object {
        const val CIDADE = "cidade"
        const val ESTADO = "estado"
        const val CODIGO = "codigo"
    }
}