package Mundo

data class UbicacionGeografica (var calle: Int, var carrera: Int) : Comparable<UbicacionGeografica> {

    override fun compareTo(other: UbicacionGeografica): Int {
        if (this.calle > other.calle)
            return 1
        else if (other.calle > this.calle)
            return -1
        else if (this.carrera > other.carrera)
            return 1
        else if (other.carrera > other.calle)
            return -1
        else
            return 0
    }

}

data class Accidentado (var nombre: String) : Comparable<Accidentado> {

    override fun compareTo(other: Accidentado): Int {
        if (this.nombre > other.nombre)
            return 1
        else if (other.nombre > this.nombre)
            return -1
        else return 0
    }

}

data class Ambulancia (var) {

    fun ingresar_accidentado(accidentado: Accidentado) {

    }

}