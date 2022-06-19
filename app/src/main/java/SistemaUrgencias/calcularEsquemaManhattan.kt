package SistemaUrgencias

import kotlin.math.absoluteValue

fun calcularEsquemaManhattan(x1: Int, y1: Int, x2: Int, y2: Int): Int {
    return (x1 - x2).absoluteValue + (y1 - y2).absoluteValue
}