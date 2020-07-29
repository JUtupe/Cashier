package pl.jutupe.core.di

import androidx.room.Room
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import pl.jutupe.core.repository.*

val coreModule = module {
    single {
        Room.databaseBuilder(androidContext(), CashierDatabase::class.java, "cashier-database")
            .fallbackToDestructiveMigration()
            .build()
    }

    single { get<CashierDatabase>().debtDao() }
    single { get<CashierDatabase>().debtorDao() }
    single { get<CashierDatabase>().groupDao() }
    single { get<CashierDatabase>().paymentDao() }
    single { get<CashierDatabase>().debtorGroupCrossRefDao() }

    single { DebtorRepository(get()) }
    single { DebtRepository(get()) }
    single { GroupRepository(get(), get()) }
    single { PaymentRepository(get()) }
}