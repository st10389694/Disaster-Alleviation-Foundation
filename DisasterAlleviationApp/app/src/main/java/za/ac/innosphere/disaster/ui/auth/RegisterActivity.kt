package za.ac.innosphere.disaster.ui.auth

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import za.ac.innosphere.disaster.databinding.ActivityRegisterBinding
import za.ac.innosphere.disaster.App
import za.ac.innosphere.disaster.data.User
import za.ac.innosphere.disaster.util.Security
import kotlinx.coroutines.*

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private val scope = CoroutineScope(Dispatchers.Main + Job())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegister.setOnClickListener {
            val name = binding.etName.text.toString().trim()
            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString()

            scope.launch {
                val existing = withContext(Dispatchers.IO) { App.instance.database.appDao().getUserByEmail(email) }
                if (existing != null) {
                    binding.tvMessage.text = "Email already registered"
                } else {
                    val user = User(name = name, email = email, passwordHash = Security.hash(password))
                    withContext(Dispatchers.IO) { App.instance.database.appDao().insertUser(user) }
                    binding.tvMessage.text = "Registered successfully. Please login."
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        scope.cancel()
    }
}
