package br.edu.ifpr.paranagua.tads_recyclerview.remoto.servicos.exercicios

import br.edu.ifpr.paranagua.tads_recyclerview.entidades.ModificacaoRemota
import retrofit2.Call
import retrofit2.http.*

interface ModificacaoService {
    @GET("modificacoes.json/{id}")
    fun buscaTodos(@Path("id") id: Int?): Call<List<ModificacaoRemota>>

    @GET("deleteMod.json/{id}")
    fun deletar(
            @Path("id") id: Int?): Call<String>
}