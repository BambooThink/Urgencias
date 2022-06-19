package SistemaUrgencias

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