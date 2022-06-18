package Mundo

data class Hospital (var codigo: String) : Comparable<Hospital> {

    private var pacientes: MutableList<String> = mutableListOf()
    private var accidentes: MutableList<String> = mutableListOf()

    fun getPacientes() = pacientes

    fun getAccidentes() = accidentes

    fun addPaciente(nombrePaciente: String) {
        pacientes.add(nombrePaciente)
    }

    fun addAccidente(nombreAccidente: String) {
        pacientes.add(nombreAccidente)
    }

    override fun compareTo(other: Hospital): Int {
        if (this.codigo == other.codigo) return 1
        else return 0
    }

    fun consultarPaciente(nombrePaciente: String): Boolean {
        return pacientes.find { it == nombrePaciente } != null
    }

    fun consultarAccidente(nombreAccidente: String): Boolean {
        return accidentes.find { it == nombreAccidente } != null
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