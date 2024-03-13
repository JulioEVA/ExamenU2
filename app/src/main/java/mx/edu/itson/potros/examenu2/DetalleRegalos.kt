package mx.edu.itson.potros.examenu2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetalleRegalos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_regalos)

        val bundle = intent.extras

        val imageView : ImageView = findViewById(R.id.iv_regalo_imagen)
        val textView : TextView = findViewById(R.id.tv_regalo_precio)

        if(bundle == null) return;

        textView.setText(bundle.getString("precio"))
        imageView.setImageResource(bundle.getInt("imagen"))
    }
}