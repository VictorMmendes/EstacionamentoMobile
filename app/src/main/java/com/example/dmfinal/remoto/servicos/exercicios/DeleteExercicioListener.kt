package br.edu.ifpr.paranagua.tads_recyclerview.remoto.servicos.exercicios

interface DeleteExercicioListener {
    fun onDeleteExercicioReturn(str: String)

    fun onDeleteExercicioError(mensagem: String)
}