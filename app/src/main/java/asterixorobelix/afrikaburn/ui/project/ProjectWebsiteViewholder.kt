package asterixorobelix.afrikaburn.ui.project

import androidx.recyclerview.widget.RecyclerView
import asterixorobelix.afrikaburn.R
import asterixorobelix.afrikaburn.databinding.LayoutWebsiteItemBinding
import asterixorobelix.utilities.ui.launchBrowserIntent
import asterixorobelix.utilities.ui.loadImageFromIDSetVisibility

class ProjectWebsiteViewholder(private val layoutWebsiteItemBinding: LayoutWebsiteItemBinding) :
    RecyclerView.ViewHolder(layoutWebsiteItemBinding.root) {

    fun onBind(websiteAddress:String){
        layoutWebsiteItemBinding?.apply {
            websiteIcon.loadImageFromIDSetVisibility(R.drawable.ic_web)
            root.setOnClickListener {
                it.context.launchBrowserIntent(websiteAddress)
            }
        }
    }
}