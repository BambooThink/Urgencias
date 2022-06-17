package Mundo

abstract class Hospital(private var codigo: String) : Comparable<Hospital> {

    override fun compareTo(other: Hospital): Int {
        if (this.codigo == other.codigo)
            return 1
        else
            return 0
    }
}