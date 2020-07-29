package pl.jutupe.core.repository

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import pl.jutupe.core.repository.converter.DateConverter
import pl.jutupe.core.repository.dao.DebtDao
import pl.jutupe.core.repository.dao.DebtorDao
import pl.jutupe.core.repository.dao.DebtorGroupCrossRefDao
import pl.jutupe.core.repository.dao.GroupDao
import pl.jutupe.core.repository.dao.PaymentDao
import pl.jutupe.core.repository.entity.*

@Database(
    entities = [
        Debt::class,
        DebtorGroupCrossRef::class,
        Debtor::class,
        Group::class,
        Payment::class
    ],
    version = 1
)
@TypeConverters(DateConverter::class)
internal abstract class CashierDatabase : RoomDatabase() {
    abstract fun debtDao(): DebtDao
    abstract fun debtorDao(): DebtorDao
    abstract fun groupDao(): GroupDao
    abstract fun paymentDao(): PaymentDao
    abstract fun debtorGroupCrossRefDao(): DebtorGroupCrossRefDao
}