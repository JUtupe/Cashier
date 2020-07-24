package pl.jutupe.core.repository.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "groups")
internal data class GroupLocal(
    @PrimaryKey(autoGenerate = true) var groupId: Int,
    var name: String
)