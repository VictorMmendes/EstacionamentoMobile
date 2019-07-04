package br.edu.ifpr.paranagua.tads_recyclerview.remoto.entidades

import br.edu.ifpr.paranagua.tads_recyclerview.entidades.Exercicio
import java.text.SimpleDateFormat

data class ExercicioRemoto(var id: Int?,
                           var description: String,
                           var repeats: String,
                           var weight: Int) {

    fun toExercicio(): Exercicio {

        return Exercicio(id, description, repeats, weight)
    }

}