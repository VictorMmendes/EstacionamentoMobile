package br.edu.ifpr.paranagua.tads_recyclerview.remoto.servicos.exercicios

interface InserirAtualizarExercicioListener {
    fun onInserirAtualizarExercicioReturn(str: String)

    fun onInserirAtualizarExercicioError(mensagem: String)
}