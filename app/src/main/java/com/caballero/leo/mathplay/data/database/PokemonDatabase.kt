package com.caballero.leo.mathplay.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.caballero.leo.mathplay.data.database.dao.PokemonDao
import com.caballero.leo.mathplay.data.database.entities.MyPokemonEntity

@Database(entities = [MyPokemonEntity::class], exportSchema = false, version = 1)
abstract class PokemonDatabase: RoomDatabase() {
    abstract fun getPokemonDao(): PokemonDao
}
