package za.ac.innosphere.disaster.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import za.ac.innosphere.disaster.databinding.ActivityDonateBinding
import za.ac.innosphere.disaster.App
import za.ac.innosphere.disaster.data.Donation
import kotlinx.coroutines.*

class DonateActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDonateBinding
    private val scope = CoroutineScope(Dispatchers.Main + Job())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDonateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnDonate.setOnClickListener {
            val type = binding.etType.text.toString().trim()
            val qty = binding.etQuantity.text.toString().trim()
            val notes = binding.etNotes.text.toString().trim()
            scope.launch {
                withContext(Dispatchers.IO) {
                    App.instance.database.appDao().insertDonation(Donation(userId = 0, resourceType = type, quantity = qty, notes = notes))
                }
                binding.tvStatus.text = "Donation recorded. Thank you!"
                binding.etType.text?.clear()
                binding.etQuantity.text?.clear()
                binding.etNotes.text?.clear()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        scope.cancel()
    }
}
