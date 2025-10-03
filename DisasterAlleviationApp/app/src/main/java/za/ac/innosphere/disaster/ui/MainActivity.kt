package za.ac.innosphere.disaster.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import za.ac.innosphere.disaster.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnReport.setOnClickListener {
            startActivity(Intent(this, za.ac.innosphere.disaster.ui.ReportActivity::class.java))
        }
        binding.btnDonate.setOnClickListener {
            startActivity(Intent(this, za.ac.innosphere.disaster.ui.DonateActivity::class.java))
        }
        binding.btnVolunteer.setOnClickListener {
            startActivity(Intent(this, za.ac.innosphere.disaster.ui.VolunteerActivity::class.java))
        }
        binding.btnAccessibility.setOnClickListener {
            // toggles a simple accessibility mode (large text) for demonstration
            val isLarge = binding.root.resources.configuration.fontScale > 1.0f
            binding.root.scaleX = if (isLarge) 1.0f else 1.1f
            binding.root.scaleY = if (isLarge) 1.0f else 1.1f
        }
    }
}
