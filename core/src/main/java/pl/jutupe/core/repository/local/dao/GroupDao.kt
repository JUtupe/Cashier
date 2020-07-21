package pl.jutupe.core.repository.local.dao

import androidx.room.*
import io.reactivex.Completable
import io.reactivex.Observable
import pl.jutupe.core.repository.local.dao.model.GroupWithDebtors
import pl.jutupe.core.repository.local.entity.GroupLocal

@Dao
internal interface GroupDao {
    @Transaction
    @Query("SELECT * FROM groups")

    fun getGroupWithDebtors(): Observable<List<GroupWithDebtors>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(groups: List<GroupLocal>): Completable

    @Delete
    fun deleteAll(groups: List<GroupLocal>): Completable
}