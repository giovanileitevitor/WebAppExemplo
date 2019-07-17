package br.applabbs.webappexemplo.Model

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.LinearLayout
import android.widget.TextView
import br.applabbs.webappexemplo.R

class Adapter(context: Context,arrayListDetails:ArrayList<Modelo>) : BaseAdapter(){

    private val layoutInflater: LayoutInflater
    private val arrayListDetails:ArrayList<Modelo>

    init {
        this.layoutInflater = LayoutInflater.from(context)
        this.arrayListDetails=arrayListDetails
    }

    override fun getCount(): Int {
        return arrayListDetails.size
    }

    override fun getItem(position: Int): Any {
        return arrayListDetails.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        val view: View?
        val listRowHolder: ListRowHolder
        if (convertView == null) {
            view = this.layoutInflater.inflate(R.layout.celula, parent, false)
            listRowHolder = ListRowHolder(view)
            view.tag = listRowHolder
        } else {
            view = convertView
            listRowHolder = view.tag as ListRowHolder
        }

        listRowHolder.celula_tv_cidade.text = arrayListDetails.get(position).cidade
        listRowHolder.celula_tv_estado.text = arrayListDetails.get(position).estado
        listRowHolder.celula_tv_codigo.text = arrayListDetails.get(position).codigo
        return view
    }
}

private class ListRowHolder(row: View?) {
    public val celula_tv_cidade: TextView
    public val celula_tv_estado: TextView
    public val celula_tv_codigo: TextView
    public val linearLayout: LinearLayout

    init {
        this.celula_tv_cidade = row?.findViewById<TextView>(R.id.celula_tv_cidade) as TextView
        this.celula_tv_estado = row?.findViewById<TextView>(R.id.celula_tv_estado) as TextView
        this.celula_tv_codigo = row?.findViewById<TextView>(R.id.celula_tv_codigo) as TextView
        this.linearLayout = row?.findViewById<LinearLayout>(R.id.linearLayout) as LinearLayout
    }
}