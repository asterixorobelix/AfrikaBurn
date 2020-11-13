package asterixorobelix.afrikaburn.models

import java.io.Serializable

data class ProjectNavigationArguments(val projectId: Int, val projectType: Project.ProjectType) :
    Serializable