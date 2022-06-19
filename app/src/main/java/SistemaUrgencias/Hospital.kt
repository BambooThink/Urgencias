package SistemaUrgencias

import ean.collections.TArrayList

data class Hospital (
    var codigo: Int,
    var nombre: String,
    var ubicacion: UbicacionGeografica,
    var accidente1: String,
    var accidente2: String) : Comparable<Hospital> {

    var pacientes: TArrayList<Accidentado> = TArrayList()

    override fun compareTo(other: Hospital): Int {
        if (this.codigo > other.codigo)
            return 1
        else if (other.codigo > this.codigo)
            return -1
        else return 0
    }

    fun addPaciente(nombrePaciente: String, accidente: String) {
        pacientes.add(Accidentado(nombrePaciente, accidente))
    }

    fun consultarPaciente(nombrePaciente: String): Boolean {
        return pacientes.find { it.nombre == nombrePaciente } != null
    }

    fun consultarAccidente(nombreAccidente: String): Boolean = when(nombreAccidente) {
        accidente1 -> true
        accidente2 -> true
        else -> false
    }

    fun ingresarAccidentado(nombreAccidentado: String, nombreAccidente: String) {
        if (!consultarPaciente(nombreAccidentado) && consultarAccidente(nombreAccidente)) {
            addPaciente(nombreAccidentado, nombreAccidente)
        }
    }

    fun darAltaPaciente(nombrePaciente: String) {
        pacientes.removeElement( pacientes.find { it.nombre == nombrePaciente}!! )
    }

}