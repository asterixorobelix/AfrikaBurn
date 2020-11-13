package asterixorobelix.afrikaburn.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DatabaseProject(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "project_type") val projectType: String,
    @ColumnInfo(name = "is_favourite") val isFavourite: Boolean
)