package mx.edu.itson.potros.examenu2

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView

class Regalos : AppCompatActivity() {

    var productos = ArrayList<Detalles>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regalos)

        var menuOption: String? = intent.getStringExtra("menuType")
        agregarProductos(menuOption)

        var gridView: GridView = findViewById(R.id.regalosGrid)

        var detallesAdapter: DetallesAdapter = DetallesAdapter(this, productos)

        gridView.adapter = detallesAdapter
    }

    fun agregarProductos(option: String?){

        var tv: TextView = findViewById(R.id.tv_detalles)

        when(option){
            "Detalles"->{
                tv.text = "Detalles"
                productos.add(Detalles(R.drawable.cumplebotanas, "$280"))
                productos.add(Detalles(R.drawable.cumplecheve, "$320"))
                productos.add(Detalles(R.drawable.cumpleescolar, "$330"))
                productos.add(Detalles(R.drawable.cumplepaletas, "$190"))
                productos.add(Detalles(R.drawable.cumplesnack, "$150"))
                productos.add(Detalles(R.drawable.cumplevinos, "$370"))

            }

            "Globos"->{
                tv.text = "Globos"
                productos.add(Detalles(R.drawable.globoamor, "$240"))
                productos.add(Detalles(R.drawable.globocumple, "$820"))
                productos.add(Detalles(R.drawable.globofestejo, "$760"))
                productos.add(Detalles(R.drawable.globos, "$450"))
                productos.add(Detalles(R.drawable.globonum, "$260"))
                productos.add(Detalles(R.drawable.globoregalo, "$240"))
            }

            "Peluches"->{
                tv.text = "Peluches"
                productos.add(Detalles(R.drawable.peluchemario, "$320"))
                productos.add(Detalles(R.drawable.pelucheminecraft, "$320"))
                productos.add(Detalles(R.drawable.peluchepeppa, "$330"))
                productos.add(Detalles(R.drawable.peluches, "$190"))
                productos.add(Detalles(R.drawable.peluchesony, "$280"))
                productos.add(Detalles(R.drawable.peluchestich, "$370"))
                productos.add(Detalles(R.drawable.peluchevarios, "$195"))
            }

            "Regalos"->{
                tv.text = "Regalos"
                productos.add(Detalles(R.drawable.regaloazul, "$80"))
                productos.add(Detalles(R.drawable.regalobebe, "$370"))
                productos.add(Detalles(R.drawable.regalos, "$370"))
                productos.add(Detalles(R.drawable.regalocajas, "$370"))
                productos.add(Detalles(R.drawable.regalocolores, "$370"))
                productos.add(Detalles(R.drawable.regalovarios, "$75"))
            }

            "Tazas"->{
                tv.text = "Tazas"
                productos.add(Detalles(R.drawable.tazaabuela, "$120"))
                productos.add(Detalles(R.drawable.tazalove, "$120"))
                productos.add(Detalles(R.drawable.tazaquiero, "$260"))
                productos.add(Detalles(R.drawable.tazas, "$280"))
            }

        }
    }

    class DetallesAdapter: BaseAdapter {
        var detalles = ArrayList<Detalles>()
        var context: Context? = null

        constructor(context: Context, peliculas: ArrayList<Detalles>) : super() {
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
            var inflator =
                context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var vista = inflator.inflate(R.layout.activity_detalle_regalos, null)
            var image: ImageView = vista.findViewById(R.id.iv_regalo_imagen)
            var title: TextView = vista.findViewById(R.id.tv_regalo_precio)

            image.setImageResource(detalle.image)
            title.setText(detalle.precio)

            image.setOnClickListener() {
                val intento = Intent(context, DetalleRegalos::class.java)
                intento.putExtra("precio", detalle.precio)
                intento.putExtra("imagen", detalle.image)
                context!!.startActivity(intento)
            }
            return vista
        }
    }
}