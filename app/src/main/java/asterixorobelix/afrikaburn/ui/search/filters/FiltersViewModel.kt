package asterixorobelix.afrikaburn.ui.search.filters

import asterixorobelix.afrikaburn.models.Project
import asterixorobelix.utilities.base.BaseBusyIndicatorViewModel

class FiltersViewModel : BaseBusyIndicatorViewModel() {
    private var projectTypeFilter: Project.ProjectType = Project.ProjectType.Unknown

    fun setProjectFilterType(projectType: Project.ProjectType) {
        projectTypeFilter = projectType
    }

    fun getProjectFilterType(): Project.ProjectType = projectTypeFilter
}
