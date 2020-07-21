package pl.jutupe.core.repository.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import pl.jutupe.core.repository.local.converter.DateConverter
import pl.jutupe.core.repository.local.dao.DebtDao
import pl.jutupe.core.repository.local.dao.DebtorDao
import pl.jutupe.core.repository.local.dao.GroupDao
import pl.jutupe.core.repository.local.dao.PaymentDao
import pl.jutupe.core.repository.local.entity.*

@Database(
    entities = [
        DebtLocal::class,
        DebtorGroupCrossRef::class,
        DebtorLocal::class,
        GroupLocal::class,
        PaymentLocal::class
    ],
    version = 1
)
@TypeConverters(DateConverter::class)
internal abstract class CashierDatabase : RoomDatabase() {
    abstract fun debtDao(): DebtDao
    abstract fun debtorDao(): DebtorDao
    abstract fun groupDao(): GroupDao
    abstract fun paymentDao(): PaymentDao
}