package br.edu.ifpr.paranagua.tads_recyclerview.ui

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.edu.ifpr.paranagua.tads_recyclerview.entidades.Modificacao
import com.example.dmfinal.R
import kotlinx.android.synthetic.main.modificacao_item.view.*
import java.text.SimpleDateFormat

class ModificacoesAdapter(val modificacoes: List<Modificacao>, val listener: ModificacoesAdapterListener?) :
        RecyclerView.Adapter<ModificacoesAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val modificacao = modificacoes[position]
        holder?.let {
            it.preencherView(modificacao)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent?.context)
            .inflate(
                R.layout.modificacao_item,
                parent, false)
        context = parent?.context
        return ViewHolder(view)
    }

    private var context: Context? = null

    interface ModificacoesAdapterListener {
        fun onModificacaoSelected(modificacao: Modificacao)
        fun onDeleteModificacaoSelected(id: Int?)
    }

    override fun getItemCount() = modificacoes.size

    inner class ViewHolder(view: View) :
            RecyclerView.ViewHolder(view) {

        fun preencherView(modificacao: Modificacao) {

            val f = SimpleDateFormat("dd/mm/yyyy")

            itemView.txtData.text = f.format(modificacao.data)
            itemView.txtPeso.text = "${modificacao?.peso.toString() + "Kg"}"

            itemView.setOnClickListener {
                listener?.onModificacaoSelected(modificacao)
            }

            itemView.delBt.setOnClickListener {
                listener?.onDeleteModificacaoSelected(modificacao.id)
            }
        }
    }
}

