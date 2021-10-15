package ru.spbstu_software_design_project.rickandmorty.data.converters

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.Gson
import ru.spbstu_software_design_project.rickandmorty.data.remote.model.CharacterLocationResponse


@ProvidedTypeConverter
object Converters {
    @TypeConverter
    fun listToJson(value: List<String>): String = Gson().toJson(value)

    @TypeConverter
    fun jsonToList(value: String): List<String> {
        return Gson().fromJson(value, Array<String>::class.java).toList()
    }

    @TypeConverter
    fun locationToJson(value: CharacterLocationResponse): String {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun jsonToLocation(value: String): CharacterLocationResponse {
        return Gson().fromJson(value, CharacterLocationResponse::class.java)
    }
}
