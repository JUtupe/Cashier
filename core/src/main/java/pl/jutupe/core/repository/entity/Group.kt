package pl.jutupe.core.repository.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "groups")
data class Group(
    @PrimaryKey(autoGenerate = true) var groupId: Long,
    var name: String
)