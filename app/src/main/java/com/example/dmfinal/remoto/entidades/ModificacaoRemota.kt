package br.edu.ifpr.paranagua.tads_recyclerview.entidades

import java.io.Serializable
import java.text.SimpleDateFormat


data class ModificacaoRemota(var id: Int?,
                       var progressdate: String,
                       var id_exercise: Int,
                       var weight: Int) : Serializable {

    fun toModificacao(): Modificacao {

        val f = SimpleDateFormat("yyyy-mm-dd")

        return Modificacao(id, f.parse(progressdate), id_exercise, weight)
    }

}