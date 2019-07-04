package br.edu.ifpr.paranagua.tads_recyclerview.remoto.servicos.exercicios.modificacoes

interface DeletarModificacaoListener {
    fun onDeletarModificacaoReturn(str: String)

    fun onDeletarModificacaoError(mensagem: String)
}