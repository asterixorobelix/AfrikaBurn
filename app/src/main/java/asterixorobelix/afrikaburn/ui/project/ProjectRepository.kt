package asterixorobelix.afrikaburn.ui.project

import asterixorobelix.afrikaburn.AfrikaburnRepository
import asterixorobelix.afrikaburn.models.Project

class ProjectRepository(private val afrikaburnRepository: AfrikaburnRepository) {
    suspend fun getProject(projectId: Int, projectType: Project.ProjectType): Project? {
        return afrikaburnRepository.getProjectsRaw().find {
            it.nid == projectId
        }
    }
}