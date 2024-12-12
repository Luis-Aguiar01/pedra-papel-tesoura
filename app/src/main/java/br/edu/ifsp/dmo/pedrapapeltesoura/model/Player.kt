package br.edu.ifsp.dmo.pedrapapeltesoura.model

class Player(val name: String) {
    var points: Int = 0
        private set

    fun recordPoint() {
        points++
    }
}