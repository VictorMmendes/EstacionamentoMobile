package br.edu.ifpr.paranagua.tads_recyclerview.remoto.dao

import br.edu.ifpr.paranagua.tads_recyclerview.entidades.ModificacaoRemota
import br.edu.ifpr.paranagua.tads_recyclerview.remoto.servicos.exercicios.*
import br.edu.ifpr.paranagua.tads_recyclerview.remoto.servicos.exercicios.modificacoes.DeletarModificacaoListener
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ModificacaoDaoRemoto {
    var buscaTodasModificacoesListener: BuscaTodasModificacoesListener? = null
    var inserirAtualizarModificacaoListener: InserirAtualizarModificacaoListener? = null
    var deletarModificacaoListener: DeletarModificacaoListener? = null

    private var retrofit = Retrofit.Builder()
            .baseUrl("http://10.0.2.2/slimAndroid/rest.php/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun buscarTodos(id: Int?) {
        var service =
                retrofit.create(ModificacaoService::class.java)

        var call = service.buscaTodos(id)

        call.enqueue(object: Callback<List<ModificacaoRemota>> {
            override fun onFailure(call: Call<List<ModificacaoRemota>>?,
                                   t: Throwable?) {
                buscaTodasModificacoesListener?.onBuscaTodasModificacoesError("Não foi possível conectar com o WebService")
            }

            override fun onResponse(call: Call<List<ModificacaoRemota>>?,
                                    response: Response<List<ModificacaoRemota>>?) {
                var modificacoesRemotas:List<ModificacaoRemota> = response?.body()!!

                var modificacoes = modificacoesRemotas.map { modificacaoRemoto ->
                    modificacaoRemoto.toModificacao()
                }

                buscaTodasModificacoesListener?.onBuscaTodasModificacoesReturn(modificacoes)
            }

        })
    }

    fun deletar(id: Int?) {
        var service =
                retrofit.create(ModificacaoService::class.java)

        var call = service.deletar(
                id
        )

        call.enqueue(object: Callback<String> {
            override fun onFailure(call: Call<String>?,
                                   t: Throwable?) {
                deletarModificacaoListener?.onDeletarModificacaoError("Wasn't possible to connect to WebService")
            }

            override fun onResponse(call: Call<String>?,
                                    response: Response<String>?) {
                deletarModificacaoListener?.onDeletarModificacaoReturn("Deleted Successfully")
            }

        })
    }
}