package Mundo

import ean.collections.TArrayList
import ean.collections.min

class SistemaUrgencias {

    companion object {

        var lista_ambulancias: TArrayList<Ambulancia> = TArrayList()
        var lista_hospitales: TArrayList<Hospital> = TArrayList()

        fun agregar_ambulancia(codigo: Int, calle: Int, carrera: Int) {
            if (lista_ambulancias.filter { it.codigo.equals(codigo) }.isEmpty)
                lista_ambulancias.add(Ambulancia(codigo, null, "LIBRE", UbicacionGeografica(calle, carrera)))
        }

        fun agregar_hospital(codigo: Int, nombre: String, calle: Int, carrera: String, accidente1: String, accidente2: String) {
            if (lista_hospitales.filter { it.codigo.equals(codigo) }.isEmpty)
                lista_hospitales.add(Hospital(codigo, ))
        }

        fun ocurrio_accidente(accidentado: Accidentado, calle: Int, carrera: Int) {
            lista_ambulancias.filter { it.estado.equals("LIBRE") }
                .map { calcularEsquemaManhattan(it.ubicacion.calle, calle, it.ubicacion.carrera, carrera) }
                .min()
        }

        fun llegada_ambulancia_hospital(ambulancia: Ambulancia) {
            if (ambulancia.estado.equals("OCUPADA")) {
                var hospital = lista_hospitales.find { it.consultarAccidente(ambulancia.accidentado!!.accidente) }
                ambulancia.desocupar()
                ambulancia.cambiar_ubicacion(hospital!!.ubicacion)
                hospital.addPaciente(ambulancia.accidentado!!.nombre)
            }
        }

        fun dar_alta_accidentado(codigoHospital: Int, nombrePaciente: String) {
            var hospital = lista_hospitales.find { it.codigo == codigoHospital }
            hospital!!.darAltaPaciente(nombrePaciente)
        }

    }

}