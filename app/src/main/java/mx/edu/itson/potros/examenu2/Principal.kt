package mx.edu.itson.potros.examenu2

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView

class Principal : AppCompatActivity() {

    var detallesAdapter: DetallesAdapter? = null

    var productos = ArrayList<Detalles>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)

        var menuOption: String? = intent.getStringExtra("menuType")
        agregarProductos(menuOption)

        var listView: ListView = findViewById(R.id.listView) as ListView

        var adaptador : AdaptadorProductos = AdaptadorProductos(this, menu)
        listView.adapter = adaptador
    }

    fun agregarProductos(option: String?){

        var tv: TextView = findViewById(R.id.tv_detalles)

        when(option){
            "Detalles"->{
                tv.text = "Detalles"
            }

            "Globos"->{
                tv.text = "Globos"
            }

            "Peluches"->{
                tv.text = "Peluches"
            }

            "Regalos"->{
                tv.text = "Regalos"
            }

            "Tazas"->{
                tv.text = "Tazas"
            }

        }
}

class DetallesAdapter: BaseAdapter {
    var detalles = ArrayList<Detalles>()
    var context: Context? = null

    constructor(context: Context, peliculas: ArrayList<Detalles>) : super(){
        this.detalles = peliculas
        this.context = context
    }

    override fun getCount(): Int {
        return detalles.size
    }

    override fun getItem(position: Int): Any {
        return detalles[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(pe: Int, p1: View?, p2: ViewGroup?): View {
        var detalle = detalles[pe]
        var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var vista = inflator.inflate(R.layout.activity_detalle_regalos, null)
        var image: ImageView = vista.findViewById(R.id.iv_regalo_imagen)
        var title: TextView = vista.findViewById(R.id.tv_regalo_precio)

        image.setImageResource(detalle.image)
        title.setText(detalle.precio)

        image.setOnClickListener(){
            val intento = Intent(context, DetalleRegalos::class.java)
            intento.putExtra("precio", detalle.precio)
            intento.putExtra("imagen", detalle.image)
            context!!.startActivity(intento)
        }
        return vista
    }
}