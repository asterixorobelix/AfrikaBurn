package asterixorobelix.afrikaburn.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import asterixorobelix.afrikaburn.R
import asterixorobelix.afrikaburn.models.Project

class SearchItemAdapter(private val diffCallback: DiffUtil.ItemCallback<Project>) :
    PagingDataAdapter<Project, SearchItemViewHolder>(diffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchItemViewHolder {
        return SearchItemViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.layout_search_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: SearchItemViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }
}