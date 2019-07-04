package br.edu.ifpr.paranagua.tads_recyclerview.remoto.servicos.exercicios

import br.edu.ifpr.paranagua.tads_recyclerview.remoto.entidades.ExercicioRemoto
import retrofit2.Call
import retrofit2.http.*

interface ExercicioService {
    @GET("exercicios.json/{query}")
    fun buscaTodos(@Path("query") query: String): Call<List<ExercicioRemoto>>

    @GET("insert.json/{description}&{repeats}&{weight}")
    fun inserir(
            @Path("description") description: String,
            @Path("repeats") repeats: String,
            @Path("weight") weight: Int): Call<String>

    @GET("delete.json/{id}")
    fun deletar(
            @Path("id") id: Int?): Call<String>

    @GET("update.json/{id}&{description}&{repeats}&{weight}")
    fun atualizar(
            @Path("id") id: Int,
            @Path("description") description: String,
            @Path("repeats") repeats: String,
            @Path("weight") weight: Int): Call<String>
}