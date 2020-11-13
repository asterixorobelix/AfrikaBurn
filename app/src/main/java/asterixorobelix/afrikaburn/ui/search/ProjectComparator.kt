package asterixorobelix.afrikaburn.ui.search

import androidx.recyclerview.widget.DiffUtil
import asterixorobelix.afrikaburn.models.Project

class ProjectComparator : DiffUtil.ItemCallback<Project>() {
    override fun areItemsTheSame(oldItem: Project, newItem: Project): Boolean {
        return oldItem.nid == newItem.nid
    }

    override fun areContentsTheSame(oldItem: Project, newItem: Project): Boolean {
        return oldItem.nid == newItem.nid
    }
}