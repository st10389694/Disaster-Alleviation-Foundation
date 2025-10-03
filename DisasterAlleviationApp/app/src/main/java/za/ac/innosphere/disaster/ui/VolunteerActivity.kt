package za.ac.innosphere.disaster.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import za.ac.innosphere.disaster.databinding.ActivityVolunteerBinding
import za.ac.innosphere.disaster.App
import za.ac.innosphere.disaster.data.VolunteerTask
import kotlinx.coroutines.*

class VolunteerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityVolunteerBinding
    private val scope = CoroutineScope(Dispatchers.Main + Job())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVolunteerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCreateTask.setOnClickListener {
            val title = binding.etTitle.text.toString().trim()
            val desc = binding.etDescription.text.toString().trim()
            val task = VolunteerTask(title = title, description = desc)
            scope.launch {
                withContext(Dispatchers.IO) {
                    App.instance.database.appDao().insertTask(task)
                }
                binding.tvStatus.text = "Task created"
                binding.etTitle.text?.clear()
                binding.etDescription.text?.clear()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        scope.cancel()
    }
}
