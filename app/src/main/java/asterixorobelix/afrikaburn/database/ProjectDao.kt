package asterixorobelix.afrikaburn.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import asterixorobelix.afrikaburn.models.DatabaseProject
import asterixorobelix.afrikaburn.models.Project

@Dao
interface ProjectDao {
    @Query("SELECT * FROM databaseproject")
    suspend fun getAll(): List<DatabaseProject>

    @Query("SELECT * FROM databaseproject WHERE id IN (:projectId)")
    suspend fun loadAllById(projectId: Int): DatabaseProject

    @Query("SELECT * FROM databaseproject WHERE project_type IN (:projectType)")
    suspend fun findByProjectsType(projectType: String): List<DatabaseProject>

    @Insert
    suspend fun insertAll(vararg projects: DatabaseProject)

    @Delete
    suspend fun delete(user: DatabaseProject)
}
