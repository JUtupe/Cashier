package pl.jutupe.core.repository.local.converter

import androidx.room.TypeConverter
import java.util.*

internal class DateConverter {
    @TypeConverter
    fun toDate(dateLong: Long?): Date? =
        dateLong?.let { Date(it) }


    @TypeConverter
    fun fromDate(date: Date?): Long? =
        date?.time
}