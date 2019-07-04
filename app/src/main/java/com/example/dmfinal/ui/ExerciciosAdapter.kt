package br.edu.ifpr.paranagua.tads_recyclerview.ui

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.edu.ifpr.paranagua.tads_recyclerview.entidades.Exercicio
import com.example.dmfinal.R
import kotlinx.android.synthetic.main.exercicio_item.view.*

class ExerciciosAdapter(val exercicios: List<Exercicio>, val listener: ExerciciosAdapterListener?) :
        RecyclerView.Adapter<ExerciciosAdapter.ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val exercicio = exercicios[position]
        holder?.let {
            it.preencherView(exercicio)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent?.context)
            .inflate(
                R.layout.exercicio_item,
                parent, false)
        context = parent?.context
        return ViewHolder(view)
    }

    private var context: Context? = null

    interface ExerciciosAdapterListener {
        fun onExercicioSelected(exercicio: Exercicio)
        fun onExercicioDeleted(id: Int?)
        fun onEditExercicioSelected(exercicio: Exercicio)
    }

    override fun getItemCount() = exercicios.size

    inner class ViewHolder(view: View) :
            RecyclerView.ViewHolder(view) {

        fun preencherView(exercicio: Exercicio) {

            itemView.txtDescricao.text = exercicio.descricao
            itemView.txtRepeticao.text = exercicio.repeticao
            itemView.txtPeso.text = "${exercicio?.peso.toString() + "Kg"}"

            itemView.setOnClickListener {
                listener?.onExercicioSelected(exercicio)
            }

            itemView.deleteBt.setOnClickListener {
                listener?.onExercicioDeleted(exercicio.id)
            }

            itemView.editBt.setOnClickListener {
                listener?.onEditExercicioSelected(exercicio)
            }
        }
    }
}

