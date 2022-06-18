package Mundo

import ean.collections.TArrayList
import ean.collections.min

class SistemaUrgencias {

    companion object {

        var lista_ambulancias: TArrayList<Ambulancia>()
        var lista_hospitales: TArrayList<Hospital>()

        fun agregar_ambulancia(var codigo: Int, var calle: Int, var carrera: Int) {
            if (lista_ambulancias.filter { it.codigo.equals(codigo) }.isEmpty)
                lista_ambulancias.add(Ambulancia(null, codigo, "LIBRE", UbicacionGeografica(calle, carrera)))
        }

        fun agregar_hospital(var codigo: Int, var nombre: String, var calle: Int, var carrera: String, var accidente1: String, var accidente2: String) {
            if (lista_hospitales.filter { it.codigo.equals(codigo) }.isEmpty)
                TODO()
        }

        fun ocurrio_accidente(var accidentado: Accidentado, var calle: Int, var carrera: Int) {
            lista_ambulancias.filter { it.estado.equals("LIBRE") }
                .map { calcularEsquemaManhattan(it.ubicacion.calle, calle, it.ubicacion.carrera, carrera) }
                .min()
        }

    }

}