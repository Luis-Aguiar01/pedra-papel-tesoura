package br.edu.ifsp.dmo.pedrapapeltesoura.model

object Scissors : Weapon {
    private fun readResolve(): Any = Scissors
}