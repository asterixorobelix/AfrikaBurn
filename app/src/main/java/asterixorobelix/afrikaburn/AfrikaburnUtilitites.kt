package asterixorobelix.afrikaburn

import androidx.fragment.app.Fragment
import asterixorobelix.afrikaburn.models.Project

fun Project.ProjectType.getIcon(): Int {
    return when (this) {
        Project.ProjectType.Artwork -> R.drawable.ic_art
        Project.ProjectType.Event -> R.drawable.ic_event
        Project.ProjectType.Camp -> R.drawable.ic_camp
        Project.ProjectType.Vehicle -> R.drawable.ic_vehicle
        Project.ProjectType.Unknown -> R.drawable.ic_question
    }
}

fun Project.ProjectType.getColor(): Int {
    return when (this) {
        Project.ProjectType.Artwork -> R.color.art_color
        Project.ProjectType.Event -> R.color.event_color
        Project.ProjectType.Camp -> R.color.camp_color
        Project.ProjectType.Vehicle -> R.color.vehicle_color
        Project.ProjectType.Unknown -> R.color.colorPrimary
    }
}

fun getSoundImage(hasSound: Boolean): Int {
    return when (hasSound) {
        true -> R.drawable.ic_music
        else -> R.drawable.ic_no_music
    }
}

fun determineFavouriteImage(isFavourite: Boolean): Int {
    return when (isFavourite) {
        true -> R.drawable.ic_favourite
        else -> R.drawable.ic_not_favourite
    }
}

fun Fragment.hideToolbar(){
    (activity as MainActivity).toggleToolbarVisibility(false)
}

fun Fragment.showToolbar(){
    (activity as MainActivity).toggleToolbarVisibility(true)
}