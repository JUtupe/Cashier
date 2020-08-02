package pl.jutupe.core.di

import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import pl.jutupe.core.repository.*
import pl.jutupe.core.repository.dao.DebtDao
import pl.jutupe.core.repository.dao.DebtorDao
import pl.jutupe.core.repository.dao.GroupDao
import pl.jutupe.core.repository.entity.Debt
import pl.jutupe.core.repository.entity.Debtor
import pl.jutupe.core.repository.entity.Group
import java.util.*

val coreModule = module {
    single {
        Room.databaseBuilder(androidContext(), CashierDatabase::class.java, "cashier-database")
            .fallbackToDestructiveMigration()
            .addCallback(object : RoomDatabase.Callback() {
                override fun onCreate(db: SupportSQLiteDatabase) {
                    GlobalScope.launch {

                        get<DebtorDao>().insertAll(
                            (1..200).map { it.toString() }.map { Debtor(0, it, it) }
                        )

                        get<GroupDao>().insertAll(
                            (1..200).map { it.toString() }.map { Group(0, it) }
                        )

                        get<DebtDao>().insertAll(
                            (1..200).map { it.toString() }.map { Debt(0, it, 30, Date()) }
                        )
                    }
                }
            })
            .build()
    }

    single { get<CashierDatabase>().debtDao() }
    single { get<CashierDatabase>().debtorDao() }
    single { get<CashierDatabase>().groupDao() }
    single { get<CashierDatabase>().paymentDao() }

    single { DebtorRepository(get()) }
    single { DebtRepository(get()) }
    single { GroupRepository(get()) }
    single { PaymentRepository(get()) }
}