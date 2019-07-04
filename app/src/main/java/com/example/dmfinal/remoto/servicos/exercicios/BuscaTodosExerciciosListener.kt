package br.edu.ifpr.paranagua.tads_recyclerview.remoto.servicos.exercicios

import br.edu.ifpr.paranagua.tads_recyclerview.entidades.Exercicio

interface BuscaTodosExerciciosListener {
    fun onBuscaTodosExerciciosReturn(exercicios: List<Exercicio>)

    fun onBuscaTodosExerciciosError(mensagem: String)
}