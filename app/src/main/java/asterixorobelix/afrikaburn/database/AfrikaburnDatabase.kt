package asterixorobelix.afrikaburn.database

import androidx.room.Database
import androidx.room.RoomDatabase
import asterixorobelix.afrikaburn.models.DatabaseProject

@Database(entities = arrayOf(DatabaseProject::class), version = 1)
abstract class AfrikaburnDatabase : RoomDatabase() {
    abstract fun projectDao(): ProjectDao
}