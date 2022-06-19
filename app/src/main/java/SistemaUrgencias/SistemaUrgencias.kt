package SistemaUrgencias

import ean.collections.TArrayList

class SistemaUrgencias {

    companion object {

        var lista_ambulancias: TArrayList<Ambulancia> = TArrayList()
        var lista_hospitales: TArrayList<Hospital> = TArrayList()

        fun agregar_ambulancia(codigo: Int, calle: Int, carrera: Int) {
            if (lista_ambulancias.filter { it.codigo.equals(codigo) }.isEmpty)
                lista_ambulancias.add(Ambulancia(codigo, null, "LIBRE",
                    UbicacionGeografica(calle, carrera)))
            else
                throw Exception("Ambulancia ya existe")
        }

        fun agregar_hospital(codigo: Int, nombre: String, calle: Int, carrera: Int, accidente1: String,
                             accidente2: String) {
            if (lista_hospitales.filter { it.codigo.equals(codigo) }.isEmpty)
                lista_hospitales.add(Hospital(codigo, nombre, UbicacionGeografica(calle, carrera), accidente1,
                    accidente2))
            else
                throw Exception("Hospital ya existe")
        }

        fun ocurrio_accidente(accidentado: Accidentado, calle: Int, carrera: Int): Ambulancia? {
            val lista_ambulancias_libres = lista_ambulancias.filter { it.estado.equals("LIBRE") }
            if (lista_ambulancias_libres.isEmpty)
                return null
            return lista_ambulancias_libres.minWith(compareBy { calcularEsquemaManhattan(it.ubicacion!!.calle,
                                                                    it.ubicacion!!.carrera, calle, carrera) } )
        }

        fun actualizar_ubicacion_ambulancia(codigo: Int, nuevaUbicacion: UbicacionGeografica) {
            val ambulancia: Ambulancia?
            ambulancia = lista_ambulancias.find { it.estado.equals("LIBRE") && it.codigo.equals(codigo) }
            if (ambulancia != null)
                ambulancia.ubicacion = nuevaUbicacion
            else
                throw Exception("Ambulancia ocupada o no existe")
        }

        fun asignar_accidentado_a_ambulancia(accidentado: Accidentado, ambulancia: Ambulancia) {
            if (ambulancia.estado.equals("LIBRE")){
                ambulancia.ingresar_accidentado(accidentado)
            }
        }

        fun buscar_hospital_para_ambulancia(ambulancia: Ambulancia): Hospital? {

            if (ambulancia.estado.equals("LIBRE"))
                return null

            val hospitales_especialidad_accidente =  lista_hospitales
                                                    .filter { it.accidente1.equals(ambulancia.accidentado!!.accidente)
                                                            || it.accidente2.equals(ambulancia.accidentado!!.accidente) }

            if (hospitales_especialidad_accidente.isEmpty)
                return null

            return hospitales_especialidad_accidente
                .minWith(compareBy { calcularEsquemaManhattan(it.ubicacion.calle,
                                                                it.ubicacion.carrera,
                                                                ambulancia.ubicacion!!.calle,
                                                                ambulancia.ubicacion!!.carrera) })

        }

        fun llegada_ambulancia_hospital(ambulancia: Ambulancia) {
            if (ambulancia.estado.equals("OCUPADA")) {
                val hospital = lista_hospitales.find { it.consultarAccidente(ambulancia.accidentado!!.accidente) }
                if (hospital != null) {
                    hospital.ingresarAccidentado(ambulancia.accidentado!!.nombre, ambulancia.accidentado!!.accidente)
                    ambulancia.desocupar()
                    ambulancia.cambiar_ubicacion(hospital!!.ubicacion)
                }
                else {
                    throw Exception("No hay hospital para ${ambulancia.accidentado!!.accidente}")
                }
            }
            else {
                throw Exception("Ambulancia Libre")
            }
        }

        fun dar_alta_accidentado(codigoHospital: Int, nombrePaciente: String) {
            val hospital = lista_hospitales.find { it.codigo == codigoHospital }
            hospital!!.darAltaPaciente(nombrePaciente)
        }

    }

}