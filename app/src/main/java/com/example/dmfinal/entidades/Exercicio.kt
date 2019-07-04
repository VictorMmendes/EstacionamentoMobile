package br.edu.ifpr.paranagua.tads_recyclerview.entidades

import br.edu.ifpr.paranagua.tads_recyclerview.remoto.entidades.ExercicioRemoto
import java.io.Serializable

data class Exercicio(var id: Int?,
                     var descricao: String,
                     var repeticao: String,
                     var peso: Int) : Serializable {

    fun toExercicioRemoto(): ExercicioRemoto {
        return ExercicioRemoto(id, descricao,repeticao, peso)
    }

}