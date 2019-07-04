package br.edu.ifpr.paranagua.tads_recyclerview.entidades

import java.io.Serializable
import java.text.SimpleDateFormat
import java.util.*


data class Modificacao(var id: Int?,
                        var data: Date,
                     var id_exercicio: Int,
                     var peso: Int) : Serializable {

    fun toModificacaoRemoto(): ModificacaoRemota {

        val f = SimpleDateFormat("yyyy-mm-dd")

        return ModificacaoRemota(id, f.format(data),id_exercicio, peso)
    }

}