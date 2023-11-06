package com.example.tugas_pahlawan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tugas_pahlawan.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val nama = intent.getStringExtra(Login.NAMA_EXTRA)
        with(binding){
            txtusername.text = nama
        }
        val adapterDisaster = HeroAdapter(generateDummy()) { hero ->
            Toast.makeText(this@MainActivity, "You clicked on ${hero.heroName}", Toast.LENGTH_SHORT).show()
        }
        with(binding){
            rvHero.apply {
                adapter = adapterDisaster
                layoutManager = LinearLayoutManager(context)
            }
        }
    }
    fun generateDummy(): List<Hero> {
        return listOf(
            Hero("Sukarno (1901-1970)", "Soekarno adalah Proklamator Kemerdekaan Indonesia yang pertama. Ia menjadi presiden pertama Indonesia dan memainkan peran penting dalam perjuangan melawan penjajahan Belanda.", R.drawable.sukarno),
            Hero("Mohammad Hatta (1902-1980)", "Mohammad Hatta, atau Bung Hatta, adalah wakil presiden pertama Indonesia. Bersama Soekarno, ia memainkan peran kunci dalam menyusun naskah proklamasi kemerdekaan Indonesia. Hatta juga aktif dalam diplomasi internasional untuk mengakui kemerdekaan Indonesia.", R.drawable.hatta),
            Hero("Diponegoro (1785-1855)", "Diponegoro, atau Pangeran Diponegoro, adalah pahlawan nasional Indonesia yang memimpin perang besar melawan penjajahan Belanda pada awal abad ke-19, yang dikenal sebagai Perang Diponegoro.", R.drawable.diponegoro),
            Hero("Kartini (1879-1904)", "Raden Adjeng Kartini dikenal sebagai pahlawan emansipasi wanita Indonesia. Ia berjuang untuk hak pendidikan dan emansipasi perempuan pada awal abad ke-20.", R.drawable.kartini),
            Hero("Teuku Umar (1854-1899)", "Teuku Umar adalah pahlawan nasional Indonesia yang berasal dari Aceh. Ia memimpin perlawanan rakyat Aceh melawan penjajah Belanda. Keberanian dan ketegasannya membuatnya dihormati sebagai pahlawan perang.", R.drawable.umar),
            Hero("Cut Nyak Dien (1848-1908)", "Cut Nyak Dien adalah pahlawan perempuan Aceh yang terlibat dalam perang Aceh melawan penjajah Belanda. Ia dikenal sebagai salah satu pejuang yang gigih dan berperan penting dalam perlawanan rakyat Aceh.", R.drawable.cut)
        )
    }
}