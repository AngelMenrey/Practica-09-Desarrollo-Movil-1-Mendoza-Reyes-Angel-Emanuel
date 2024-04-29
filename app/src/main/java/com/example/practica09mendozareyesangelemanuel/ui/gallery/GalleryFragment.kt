package com.example.practica09mendozareyesangelemanuel.ui.gallery
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.practica09mendozareyesangelemanuel.AccesorioActivity
import com.example.practica09mendozareyesangelemanuel.databinding.FragmentGalleryBinding

class GalleryFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val galleryViewModel =
            ViewModelProvider(this).get(GalleryViewModel::class.java)

        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textGallery
        galleryViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var producto: String = ""
        var costo: String = ""
        var intent: Intent
        binding.imgAntiguedad01.setOnClickListener{
            Toast.makeText(activity, "Collares del Siglo XX", Toast.LENGTH_SHORT).show()
            producto = "Collar del Siglo XX con perlas y oro"
            costo = "$5000.00"
            intent = Intent(activity, AccesorioActivity::class.java)
            intent.putExtra("producto",producto)
            intent.putExtra("costo",costo)
            intent.putExtra("numProducto",1)
            startActivity(intent)
        }

        binding.imgAntiguedad02.setOnClickListener{
            Toast.makeText(activity, "Monedas", Toast.LENGTH_SHORT).show()
            producto = "Monedas del perido del Imperio Mexicano"
            costo = "$4800.00"
            intent = Intent(activity, AccesorioActivity::class.java)
            intent.putExtra("producto",producto)
            intent.putExtra("costo",costo)
            intent.putExtra("numProducto",2)
            startActivity(intent)
        }

        binding.imgAntiguedad03.setOnClickListener{
            Toast.makeText(activity, "Casco", Toast.LENGTH_SHORT).show()
            producto = "Casco de epoca Medieval"
            costo = "$15000.00"
            intent = Intent(activity, AccesorioActivity::class.java)
            intent.putExtra("producto",producto)
            intent.putExtra("costo",costo)
            intent.putExtra("numProducto",3)
            startActivity(intent)
        }

        binding.imgAntiguedad04.setOnClickListener{
            Toast.makeText(activity, "Guitarra", Toast.LENGTH_SHORT).show()
            producto = "Guitarra de John Lennon"
            costo = "$100,000.00"
            intent = Intent(activity, AccesorioActivity::class.java)
            intent.putExtra("producto",producto)
            intent.putExtra("costo",costo)
            intent.putExtra("numProducto",4)
            startActivity(intent)
        }

        binding.imgAntiguedad05.setOnClickListener{
            Toast.makeText(activity, "Estatua", Toast.LENGTH_SHORT).show()
            producto = "Estatua Griega"
            costo = "$45,000.00"
            intent = Intent(activity, AccesorioActivity::class.java)
            intent.putExtra("producto",producto)
            intent.putExtra("costo",costo)
            intent.putExtra("numProducto",5)
            startActivity(intent)
        }

        binding.imgAntiguedad06.setOnClickListener{
            Toast.makeText(activity, "Sala del siglo XIV", Toast.LENGTH_SHORT).show()
            producto = "Sala con detalles de Francia del siglo XIV"
            costo = "$300,00.00"
            intent = Intent(activity, AccesorioActivity::class.java)
            intent.putExtra("producto",producto)
            intent.putExtra("costo",costo)
            intent.putExtra("numProducto",6)
            startActivity(intent)
        }

        binding.imgAntiguedad07.setOnClickListener{
            Toast.makeText(activity, "Relog", Toast.LENGTH_SHORT).show()
            producto = "Relog de 1960"
            costo = "$50,000.00"
            intent = Intent(activity, AccesorioActivity::class.java)
            intent.putExtra("producto",producto)
            intent.putExtra("costo",costo)
            intent.putExtra("numProducto",7)
            startActivity(intent)
        }

    }
}