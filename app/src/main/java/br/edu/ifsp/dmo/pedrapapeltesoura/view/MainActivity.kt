package br.edu.ifsp.dmo.pedrapapeltesoura.view

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifsp.dmo.pedrapapeltesoura.R
import br.edu.ifsp.dmo.pedrapapeltesoura.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        configToolBar()
        configSpinner()
        configListener()
    }

    private fun configListener() {
        binding.buttonStart.setOnClickListener { startGame() }
    }

    private fun configSpinner() {
        val adapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            resources.getStringArray(R.array.tipos_jogos)
        )

        binding.spinnerBattles.adapter = adapter
    }

    private fun configToolBar() {
        supportActionBar?.hide()
    }

    private fun startGame() {
        val battles: Int = when (binding.spinnerBattles.selectedItemPosition) {
            0 -> 1
            1 -> 3
            else -> 5
        }

        val mIntent = Intent(this, WarActivity::class.java)
        mIntent.putExtra(Constants.KEY_PLAYER_1, binding.edittextPlayer1.text.toString())
        mIntent.putExtra(Constants.KEY_PLAYER_2, binding.edittextPlayer2.text.toString())
        mIntent.putExtra(Constants.KEY_ROUNDS, battles)
        startActivity(mIntent)
    }

}