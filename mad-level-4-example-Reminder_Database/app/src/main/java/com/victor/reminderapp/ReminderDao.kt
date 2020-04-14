import androidx.room.*
import com.victor.reminderapp.Reminder
import androidx.room.*

@Dao
interface ReminderDao {
///
    //By adding the suspend keyword to the method we have specified that this  method cannot be called without using Coroutines. @Query("SELECT * FROM reminderTable")
    suspend fun getAllReminders(): List<Reminder>

    @Insert
    suspend fun insertReminder(reminder: Reminder)

    @Delete
    suspend fun deleteReminder(reminder: Reminder)

    @Update
    suspend fun updateReminder(reminder: Reminder)


}


