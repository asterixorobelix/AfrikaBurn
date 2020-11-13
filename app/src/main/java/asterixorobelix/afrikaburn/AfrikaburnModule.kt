package asterixorobelix.afrikaburn

import androidx.room.Room
import asterixorobelix.afrikaburn.database.AfrikaburnDatabase
import com.google.gson.Gson
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val afrikaburnModule = module {
    single { Gson() }
    single { AfrikaburnRepository(get<Gson>(), androidContext()) }

    single {
        Room.databaseBuilder(androidContext(), AfrikaburnDatabase::class.java, "afrikaburn-db")
            .build()
    }
}