package za.ac.innosphere.disaster.data

import androidx.room.*

@Dao
interface AppDao {
    // Users
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertUser(user: User): Long

    @Query("SELECT * FROM users WHERE email = :email LIMIT 1")
    suspend fun getUserByEmail(email: String): User?

    // Reports
    @Insert
    suspend fun insertReport(report: Report): Long

    @Query("SELECT * FROM reports ORDER BY date DESC")
    suspend fun getAllReports(): List<Report>

    // Donations
    @Insert
    suspend fun insertDonation(donation: Donation): Long

    @Query("SELECT * FROM donations ORDER BY date DESC")
    suspend fun getAllDonations(): List<Donation>

    // Volunteer Tasks
    @Insert
    suspend fun insertTask(task: VolunteerTask): Long

    @Query("SELECT * FROM volunteer_tasks ORDER BY date DESC")
    suspend fun getAllTasks(): List<VolunteerTask>

    @Update
    suspend fun updateTask(task: VolunteerTask)
}
