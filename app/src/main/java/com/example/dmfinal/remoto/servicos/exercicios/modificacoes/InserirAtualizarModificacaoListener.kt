package br.edu.ifpr.paranagua.tads_recyclerview.remoto.servicos.exercicios

import br.edu.ifpr.paranagua.tads_recyclerview.entidades.Modificacao

interface InserirAtualizarModificacaoListener {
    fun onInserirAtualizarModificacaoReturn(modificacao: Modificacao)

    fun onInserirAtualizarModificacaoError(mensagem: String)
}