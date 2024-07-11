package database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert
import data.MDay
import kotlinx.coroutines.flow.Flow

@Dao
interface MDayDao {

    @Upsert()
    suspend fun upsert(mDay: MDay)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(mDay: MDay)

    @Delete
    suspend fun delete(mDay: MDay)

    @Query("SELECT * FROM MDay")
    fun getAllMDay() : Flow<List<MDay>>
}