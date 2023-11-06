package com.example.tugas_pahlawan

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.example.tugas_pahlawan.databinding.ActivityLoginBinding

class Login : AppCompatActivity() {
    private lateinit var bind: ActivityLoginBinding
    companion object{
        const val NAMA_EXTRA = "nama"
        const val PASSWORD_EXTRA = "password"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)  // untuk memaksa light mode
        bind = ActivityLoginBinding.inflate(layoutInflater)

        setContentView(bind.root)
        with(bind) {
            btn.setOnClickListener {
                val intentToHomepage =
                    Intent(this@Login, MainActivity::class.java)
                intentToHomepage.putExtra(NAMA_EXTRA, username.text.toString())
                intentToHomepage.putExtra(PASSWORD_EXTRA, pass.text.toString())

                if (username.text.toString() == "Rifa Indra Setiawan" && pass.text.toString() == "123"){
                    startActivity(intentToHomepage)
                }
                else{
                    Toast.makeText(this@Login, "Username atau Password Salah", Toast.LENGTH_SHORT).show()
                }
            }
        }
        Log.d(TAG, "onCreate: dipanggil")
    }
}