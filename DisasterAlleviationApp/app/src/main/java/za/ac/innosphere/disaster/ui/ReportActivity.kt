package za.ac.innosphere.disaster.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import za.ac.innosphere.disaster.databinding.ActivityReportBinding
import za.ac.innosphere.disaster.App
import za.ac.innosphere.disaster.data.Report
import kotlinx.coroutines.*

class ReportActivity : AppCompatActivity() {
    private lateinit var binding: ActivityReportBinding
    private val scope = CoroutineScope(Dispatchers.Main + Job())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReportBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSubmit.setOnClickListener {
            val title = binding.etTitle.text.toString().trim()
            val desc = binding.etDescription.text.toString().trim()
            val location = binding.etLocation.text.toString().trim()
            val report = Report(title = title, description = desc, location = location)
            scope.launch {
                withContext(Dispatchers.IO) {
                    App.instance.database.appDao().insertReport(report)
                }
                binding.tvStatus.text = "Report submitted"
                binding.etTitle.text?.clear()
                binding.etDescription.text?.clear()
                binding.etLocation.text?.clear()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        scope.cancel()
    }
}
