package asterixorobelix.afrikaburn.ui.project

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import asterixorobelix.afrikaburn.databinding.LayoutWebsiteItemBinding

class ProjectWebsitesAdapter(private val websites: List<String>) :
    RecyclerView.Adapter<ProjectWebsiteViewholder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectWebsiteViewholder {
        return ProjectWebsiteViewholder(LayoutWebsiteItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ProjectWebsiteViewholder, position: Int) {
        holder.onBind(websites[position])
    }

    override fun getItemCount(): Int = websites.count()
}