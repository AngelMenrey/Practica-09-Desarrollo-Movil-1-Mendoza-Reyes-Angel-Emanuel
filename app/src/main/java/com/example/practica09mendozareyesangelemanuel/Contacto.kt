package com.example.practica09mendozareyesangelemanuel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.floatingactionbutton.FloatingActionButton

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class Contacto : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    private lateinit var name: EditText
    private lateinit var phone: EditText
    private lateinit var email: EditText
    private lateinit var antiques: Spinner
    private var antiguedadesSel: String = "Joyas"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_contacto, container, false)

        name = view.findViewById(R.id.editNombre)
        phone = view.findViewById(R.id.editTelefono)
        email = view.findViewById(R.id.editCorreo)
        antiques = view.findViewById(R.id.spnArticulos)

        val lstAntiguedades = resources.getStringArray(R.array.antiguedades)
        val adaptadorSpn = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, lstAntiguedades)
        antiques.adapter = adaptadorSpn
        antiques.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                antiguedadesSel = lstAntiguedades[p2]
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }

        val btnLimpiar = view.findViewById<FloatingActionButton>(R.id.btnLimpiar)
        btnLimpiar.setOnClickListener { v ->
            limpiar()
        }

        val btnRegistrar = view.findViewById<FloatingActionButton>(R.id.btnRegistrar)
        btnRegistrar.setOnClickListener { v ->
            registrar()
        }

        return view
    }

    private fun registrar() {
        if (name.text.isNotEmpty() && name.text.isNotBlank() &&
            phone.text.isNotEmpty() && phone.text.isNotBlank() &&
            email.text.isNotEmpty() && email.text.isNotBlank()
        ) {
            val objetoAntiguedad = Antigüedad()
            objetoAntiguedad.nombre = name.text.toString()
            objetoAntiguedad.telefono = phone.text.toString().toIntOrNull() ?: 0
            objetoAntiguedad.correo = email.text.toString()
            objetoAntiguedad.antiguedad = antiguedadesSel
            Toast.makeText(requireContext(), "Nombre: ${objetoAntiguedad.nombre}", Toast.LENGTH_SHORT).show()
            Toast.makeText(requireContext(), "Teléfono: ${objetoAntiguedad.telefono}", Toast.LENGTH_SHORT).show()
            Toast.makeText(requireContext(), "Correo: ${objetoAntiguedad.correo}", Toast.LENGTH_SHORT).show()
            Toast.makeText(requireContext(), "Antigüedad: ${objetoAntiguedad.antiguedad}", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(requireContext(), "Por favor, completa todos los campos.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun limpiar() {
        name.text.clear()
        phone.text.clear()
        email.text.clear()
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Contacto().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
