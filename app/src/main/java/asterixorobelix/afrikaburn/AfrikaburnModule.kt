package asterixorobelix.afrikaburn

import androidx.room.Room
import asterixorobelix.afrikaburn.database.AfrikaburnDatabase
import asterixorobelix.afrikaburn.database.ProjectDao
import com.google.gson.Gson
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.bind
import org.koin.dsl.module

val afrikaburnModule = module {
    single { Gson() }
    single { AfrikaburnRepository(get<Gson>(), androidContext()) }

    single {
        Room.databaseBuilder(androidContext(), AfrikaburnDatabase::class.java, "afrikaburn-db")
            .build()
    }

    single { get<AfrikaburnDatabase>().projectDao() } bind ProjectDao::class
}