package za.ac.innosphere.disaster.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val email: String,
    val passwordHash: String,
    val role: String = "donor" // roles: donor, volunteer, admin
)

@Entity(tableName = "reports")
data class Report(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val title: String,
    val description: String,
    val location: String,
    val date: Long = Date().time
)

@Entity(tableName = "donations")
data class Donation(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val userId: Long,
    val resourceType: String,
    val quantity: String,
    val notes: String?,
    val date: Long = Date().time
)

@Entity(tableName = "volunteer_tasks")
data class VolunteerTask(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val title: String,
    val description: String,
    val assignedToUserId: Long? = null,
    val date: Long = Date().time,
    val completed: Boolean = false
)
