package asterixorobelix.afrikaburn

import android.content.Context
import asterixorobelix.afrikaburn.models.Project
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.InputStreamReader

class AfrikaburnRepository(private val gson: Gson, private val context: Context) {
    suspend fun getProjectsRaw(): Array<Project> {
        BufferedReader(InputStreamReader(context.resources.openRawResource(R.raw.data))).run {
            return gson.fromJson(this, Array<Project>::class.java)
        }

    }
}