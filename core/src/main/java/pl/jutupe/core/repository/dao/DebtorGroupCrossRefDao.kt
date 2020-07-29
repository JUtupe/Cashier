package pl.jutupe.core.repository.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import pl.jutupe.core.repository.entity.DebtorGroupCrossRef

@Dao
internal interface DebtorGroupCrossRefDao {
    @Insert
    suspend fun insertAll(refs: List<DebtorGroupCrossRef>)

    @Delete
    suspend fun deleteAll(refs: List<DebtorGroupCrossRef>)
}