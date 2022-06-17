package Mundo

data class Ambulancia(
    private var codigo: Int,
    private var accidentado: Accidentado?,
    private var estado: String,
    private var ubicacion: UbicacionGeografica) {

        fun ingresar_accidentado(accidentado: Accidentado) {
            if (this.estado.equals("LIBRE")) {
                this.estado = "OCUPADA"
                this.accidentado = accidentado
            }
        }

        fun desocupar() {
            if (this.estado.equals("OCUPADA")){
                this.accidentado = null
                this.estado = "LIBRE"
            }
        }

        fun cambiar_ubicacion(nueva_ubicacion: UbicacionGeografica) {
            this.ubicacion = nueva_ubicacion
        }

}