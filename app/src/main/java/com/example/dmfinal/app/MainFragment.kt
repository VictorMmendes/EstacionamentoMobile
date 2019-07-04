package br.edu.ifpr.paranagua.tads_recyclerview.app

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import br.edu.ifpr.paranagua.tads_recyclerview.entidades.Exercicio
import br.edu.ifpr.paranagua.tads_recyclerview.remoto.dao.ExercicioDaoRemoto
import br.edu.ifpr.paranagua.tads_recyclerview.remoto.servicos.exercicios.BuscaTodosExerciciosListener
import br.edu.ifpr.paranagua.tads_recyclerview.remoto.servicos.exercicios.DeleteExercicioListener
import br.edu.ifpr.paranagua.tads_recyclerview.ui.ExerciciosAdapter
import com.example.dmfinal.R
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_main.view.*

class MainFragment : Fragment(), BuscaTodosExerciciosListener, ExerciciosAdapter.ExerciciosAdapterListener, SearchView.OnQueryTextListener,
    DeleteExercicioListener {
    override fun onEditExercicioSelected(exercicio: Exercicio)
    {
        val intent = Intent(view?.context, FormActivity::class.java)
        intent.putExtra("id", exercicio.id)
        intent.putExtra("descricao", exercicio.descricao)
        intent.putExtra("repeticao", exercicio.repeticao)
        intent.putExtra("peso", exercicio.peso)
        startActivity(intent)
    }

    override fun onDeleteExercicioReturn(str: String)
    {
        carregarExercicios("")
    }

    override fun onDeleteExercicioError(mensagem: String)
    {
        Toast.makeText(context, "ERROR: $mensagem", Toast.LENGTH_SHORT).show()
    }

    override fun onExercicioDeleted(id: Int?)
    {
        var dao = ExercicioDaoRemoto()
        dao.deleteExercicioListener = this
        dao.delete(id)
    }

    override fun onQueryTextSubmit(p0: String?): Boolean
    {
        val searchString = "%${searchTf.query}%"
        return carregarExercicios(searchString)
    }

    override fun onQueryTextChange(p0: String?): Boolean
    {
        val searchString = "%${searchTf.query}%"
        return carregarExercicios(searchString)
    }

    override fun onExercicioSelected(exercicio: Exercicio) {
        listener?.onExercicioSelected(exercicio)
    }

    override fun onBuscaTodosExerciciosReturn(exercicios: List<Exercicio>) {
        listExercicios?.adapter = ExerciciosAdapter(exercicios, this)
    }

    override fun onBuscaTodosExerciciosError(mensagem: String) {
        Toast.makeText(context, "ERRO: $mensagem", Toast.LENGTH_SHORT).show()
    }

    private var listener: MainFragmentListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)

        val layout = LinearLayoutManager(context,
                LinearLayoutManager.VERTICAL, false)
        view.listExercicios.layoutManager = layout

        view.searchTf.setOnQueryTextListener(this)

        view.addBt.setOnClickListener({
            listener?.onAddBtClicked()
        })

        carregarExercicios("")

        return view
    }

    override fun onResume()
    {
        super.onResume()
        carregarExercicios("")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is MainFragmentListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement MainFragmentListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface MainFragmentListener {
        fun onExercicioSelected(exercicio: Exercicio)
        fun onAddBtClicked()
    }

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }

    private fun carregarExercicios(query: String): Boolean {
        var dao = ExercicioDaoRemoto()
        dao.buscaTodosExerciciosListener = this
        dao.buscarTodos(query)
        return true
    }
}