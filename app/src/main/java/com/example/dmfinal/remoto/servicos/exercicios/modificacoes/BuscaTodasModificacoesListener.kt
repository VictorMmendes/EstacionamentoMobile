package br.edu.ifpr.paranagua.tads_recyclerview.remoto.servicos.exercicios

import br.edu.ifpr.paranagua.tads_recyclerview.entidades.Modificacao

interface BuscaTodasModificacoesListener {
    fun onBuscaTodasModificacoesReturn(modificacoes: List<Modificacao>)

    fun onBuscaTodasModificacoesError(mensagem: String)
}