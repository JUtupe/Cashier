package pl.jutupe.core.repository

import androidx.paging.PagingSource
import pl.jutupe.core.repository.dao.GroupDao
import pl.jutupe.core.repository.entity.Group

class GroupRepository internal constructor(
    private val groupDao: GroupDao
) {
    fun getAllPaging(): PagingSource<Int, Group> =
        groupDao.getAllPaging()
}