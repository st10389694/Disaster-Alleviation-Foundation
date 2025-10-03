package za.ac.innosphere.disaster.ui.auth

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import za.ac.innosphere.disaster.App
import za.ac.innosphere.disaster.databinding.ActivityLoginBinding
import za.ac.innosphere.disaster.util.Security
import kotlinx.coroutines.*

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private val scope = CoroutineScope(Dispatchers.Main + Job())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString()
            scope.launch {
                val user = withContext(Dispatchers.IO) {
                    App.instance.database.appDao().getUserByEmail(email)
                }
                if (user != null && user.passwordHash == Security.hash(password)) {
                    val intent = Intent(this@LoginActivity, za.ac.innosphere.disaster.ui.MainActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    binding.tvMessage.text = "Invalid credentials"
                }
            }
        }

        binding.tvRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        scope.cancel()
    }
}
