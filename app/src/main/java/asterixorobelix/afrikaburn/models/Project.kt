package asterixorobelix.afrikaburn.models

import com.google.gson.annotations.SerializedName

class Project {
    @SerializedName("nid")
    var nid: Int = -1

    @SerializedName("type")
    private var type: String? = null

    enum class ProjectType {
        Artwork, Event, Camp, Vehicle, Unknown
    }

    fun getType(): ProjectType {
        return when (type) {
            "Artwork" -> ProjectType.Artwork
            "Binnekring Event" -> ProjectType.Event
            "Mutant Vehicle" -> ProjectType.Vehicle
            "Theme Camp" -> ProjectType.Camp
            else -> ProjectType.Unknown
        }
    }

    @SerializedName("title")
    var title: String? = null

    @SerializedName("field_collective")
    private var collective: String? = null

    fun getCollective(): String? {
        collective?.let {
            return when (it) {
                "N/A" -> null
                else -> return it
            }
        }
        return null
    }

    @SerializedName("field_prj_wtf_short_copy")
    var fieldPrjWtfShortCopy: String? = ""

    @SerializedName("field_prj_wtf_long")
    var longDescription: String? = ""

    @SerializedName("field_prj_wtf_planned")
    var fieldPrjWtfPlanned: String? = ""

    @SerializedName("field_prj_wtf_categories")
    var fieldPrjWtfCategories: String? = ""

    @SerializedName("field_prj_wtf_scheduled")
    var fieldPrjWtfScheduled: String? = ""

    @SerializedName("field_prj_wtf_image")
    private var fieldPrjWtfImage: String? = ""

    fun getImageUrl(): String? {
        fieldPrjWtfImage?.let {
            return AFRIKABURN_IMAGE_PREFIX + it.replace("""\""", "")
        }
        return null
    }

    @SerializedName("field_prj_gen_history")
    var fieldPrjGenHistory: String? = ""

    @SerializedName("field_prj_wtf_website")
    private var website: String? = ""

    fun getWebsites(): List<String> {
        website?.let {
            return it.replace("""\""", "").split(",")
        }
        return emptyList()
    }

    @SerializedName("field_prj_oth_relationship")
    var fieldPrjOthRelationship: String? = ""

    @SerializedName("field_prj_oth_associated")
    var fieldPrjOthAssociated: String? = ""

    @SerializedName("field_prj_brn_burning")
    private var prjBrnBurning: String? = null

    fun willBurn(): Boolean {
        return convertStringToBoolean(prjBrnBurning)
    }

    @SerializedName("field_prj_brn_time_adm")
    var fieldPrjBrnTimeAdm: String? = ""

    @SerializedName("field_prj_snd_sound")
    private var fieldPrjSndSound: String? = null

    fun hasSound(): Boolean {
        return convertStringToBoolean(fieldPrjSndSound)
    }

    @SerializedName("field_prj_snd_level")
    private var prjSndLevel: String? = null

    enum class SoundLevel {
        None,
        Level1NormalCarStereoWithoutSubWoofers,
        Level2LoudAmplifiedSound,
        Level3LargeClubOrStadiumSizeSound
    }

    fun getSoundLevel(): SoundLevel {
        return when (prjSndLevel) {
            "Level 1 - Normal car stereo without sub woofers" -> SoundLevel.Level1NormalCarStereoWithoutSubWoofers
            "Level 2 - Loud amplified sound" -> SoundLevel.Level2LoudAmplifiedSound
            "Level 3 - Large club or stadium size sound" -> SoundLevel.Level3LargeClubOrStadiumSizeSound
            else -> SoundLevel.None
        }
    }

    @SerializedName("field_prj_adm_latitude")
    var latitude: String? = ""

    @SerializedName("field_prj_adm_longitude")
    var longitude: String? = ""

    @SerializedName("field_api_content_type")
    var fieldAPIContentType: String? = ""

    private fun convertStringToBoolean(string: String?): Boolean {
        return when (string) {
            NO -> false
            else -> true
        }
    }

    var isFavourite: Boolean = false

    companion object {
        const val NO = "No"
        const val AFRIKABURN_IMAGE_PREFIX = "https://tribe.afrikaburn.com"
    }

}