package asterixorobelix.afrikaburn.ui.search

import asterixorobelix.afrikaburn.AfrikaburnRepository
import asterixorobelix.afrikaburn.models.Project

class SearchRepository(private val afrikaburnRepository: AfrikaburnRepository) {
    suspend fun getProjects(): List<Project> {
        return afrikaburnRepository.getProjectsRaw().toList()
    }

    suspend fun getProjectsByType(projectType: Project.ProjectType): List<Project> {
        return afrikaburnRepository.getProjectsRaw().toList().filter {
            it.getType() == projectType
        }
    }

    suspend fun getProjectsByType(projectType: Project.ProjectType, startIndex: Int, endIndex:Int): List<Project> {
        return afrikaburnRepository.getProjectsRaw().toList().filter {
            it.getType() == projectType
        }.subList(startIndex, endIndex)
    }

    suspend fun getProjects(startIndex: Int, endIndex:Int): List<Project> {
        return getProjects().subList(startIndex,endIndex)
    }
}