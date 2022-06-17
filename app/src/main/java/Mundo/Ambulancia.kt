package Mundo

data class Ambulancia(var accidentado: Accidentado?, var estado: String, var ubicacion: UbicacionGeografica) {

    fun ingresar_accidentado(accidentado: Accidentado) {
        if (this.estado.equals("VACIA")) {
            this.estado = "OCUPADA"
            this.accidentado = accidentado
        }
    }

    fun desocupar() {
        if (this.estado.equals("OCUPADA")){
            this.accidentado = null
            this.estado = "VACIA"
        }
    }

    fun cambiar_ubicacion(nueva_ubicacion: UbicacionGeografica) {
        this.ubicacion = nueva_ubicacion
    }

}