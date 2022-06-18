package Mundo

import ean.collections.TArrayList
import ean.collections.min

class SistemaUrgencias {

    companion object {

        var lista_ambulancias: TArrayList<Ambulancia> = TArrayList()
        var lista_hospitales: TArrayList<Hospital> = TArrayList()

        fun agregar_ambulancia(codigo: Int, calle: Int, carrera: Int) {
            if (lista_ambulancias.filter { it.codigo.equals(codigo) }.isEmpty)
                lista_ambulancias.add(Ambulancia(codigo, null, "LIBRE",
                    UbicacionGeografica(calle, carrera)))
        }

        fun agregar_hospital(codigo: Int, nombre: String, calle: Int, carrera: Int, accidente1: String,
                             accidente2: String) {
            if (lista_hospitales.filter { it.codigo.equals(codigo) }.isEmpty)
                lista_hospitales.add(Hospital(codigo, nombre, UbicacionGeografica(calle, carrera), accidente1,
                    accidente2))
        }

        fun ocurrio_accidente(accidentado: Accidentado, calle: Int, carrera: Int): Ambulancia? {
            var lista_ambulancias_libres = lista_ambulancias.filter { it.estado.equals("LIBRE") }
            if (lista_ambulancias_libres.isEmpty)
                return null
            return lista_ambulancias_libres.minWith(compareBy { calcularEsquemaManhattan(it.ubicacion.calle,
                                                                    calle, it.ubicacion.carrera, carrera) } )
        }

        fun actualizar_ubicacion_ambulancia(codigo: Int, nuevaUbicacion: UbicacionGeografica) {
            var ambulancia: Ambulancia
            ambulancia = lista_ambulancias.filter { it.estado.equals("LIBRE") && it.codigo.equals(codigo) }!![0]
            ambulancia.ubicacion = nuevaUbicacion
        }

        fun asignar_accidentado_a_ambulancia(accidentado: Accidentado, ambulancia: Ambulancia) {
            if (ambulancia.estado.equals("LIBRE")){
                ambulancia.accidentado = accidentado
                ambulancia.estado = "OCUPADA"
            }
        }

        fun buscar_hospital_para_ambulancia(ambulancia: Ambulancia): Hospital? {

            if (ambulancia.estado.equals("LIBRE"))
                return null

            var hospitales_especialidad_accidente =  lista_hospitales
                                                    .filter { it.accidente1.equals(ambulancia.accidentado!!.accidente)
                                                            || it.accidente2.equals(ambulancia.accidentado!!.accidente) }

            if (hospitales_especialidad_accidente.isEmpty)
                return null

            return hospitales_especialidad_accidente
                .minWith(compareBy { calcularEsquemaManhattan(it.ubicacion.calle,
                                                                ambulancia.ubicacion.calle,
                                                                it.ubicacion.carrera,
                                                                ambulancia.ubicacion.carrera) })

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