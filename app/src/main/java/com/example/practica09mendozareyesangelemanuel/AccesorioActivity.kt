package com.example.practica09mendozareyesangelemanuel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class AccesorioActivity : AppCompatActivity() {

    private lateinit var descripcion: TextView
    private lateinit var imagen: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_accesorio)

        descripcion = findViewById(R.id.txtDescripcion)
        imagen = findViewById(R.id.imgProductoDetalle)
        val infoRecibida = intent.extras
        val producto: String?
        val costo: String?
        val num: Int?

        if(infoRecibida != null){
            producto = infoRecibida.getString("producto")
            costo = infoRecibida.getString("costo")
            num = infoRecibida.getInt("numProducto")
            descripcion.text = "Producto: \n${producto}\nCosto: ${costo}\n"

            when(num){
                1 -> imagen.setImageResource(R.drawable.img1)
                2 -> imagen.setImageResource(R.drawable.img2)
                3 -> imagen.setImageResource(R.drawable.img3)
                4 -> imagen.setImageResource(R.drawable.img4)
                5 -> imagen.setImageResource(R.drawable.img5)
                6 -> imagen.setImageResource(R.drawable.img6)
                7 -> imagen.setImageResource(R.drawable.img7)
            }
        }else{
            producto = "Null"
            costo = "$0.00"
            num=1
            descripcion.text = "Producto: \n${producto}\nCosto: ${costo}"
        }
    }
}