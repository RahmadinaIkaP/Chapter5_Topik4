package binar.academy.chapter5_topik4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import binar.academy.chapter5_topik4.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnMovePage.setOnClickListener {
                val intent = Intent(applicationContext, DuaActivity::class.java)
                startActivity(intent)
            }

            btnChangeIndonesia.setOnClickListener {
                setLocale("id")
            }

            btnChangeEnglish.setOnClickListener {
                setLocale("en")
            }
        }
    }

    private fun setLocale(s: String) {
        val myLocale = Locale(s)
        val res = resources
        val conf = res.configuration
        conf.locale = myLocale
        res.updateConfiguration(conf, res.displayMetrics)
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}