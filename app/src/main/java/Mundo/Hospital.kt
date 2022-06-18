package Mundo

data class Hospital (var codigo: Int, var nombre: String, var ubicacion: UbicacionGeografica, var accidente1: String, var accidente2: String) : Comparable<Hospital> {

    var pacientes: MutableList<String> = mutableListOf()

    override fun compareTo(other: Hospital): Int {
        if (this.codigo > other.codigo) return 1
        else return -1
    }

    fun addPaciente(nombrePaciente: String) {
        pacientes.add(nombrePaciente)
    }

    fun consultarPaciente(nombrePaciente: String): Boolean {
        return pacientes.find { it == nombrePaciente } != null
    }

    fun consultarAccidente(nombreAccidente: String): Boolean = when(nombreAccidente) {
        accidente1 -> true
        accidente2 -> true
        else -> false
    }

    fun ingresarAccidentado(nombreAccidentado: String, nombreAccidente: String) {
        if (!consultarPaciente(nombreAccidentado) && consultarAccidente(nombreAccidente)) {
            addPaciente(nombreAccidentado)
        }
    }

    fun darAltaPaciente(nombrePaciente: String) {
        pacientes.remove(pacientes.find { it == nombrePaciente})
    }

}