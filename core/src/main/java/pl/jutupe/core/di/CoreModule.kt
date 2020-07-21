package pl.jutupe.core.di

import androidx.room.Room
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import pl.jutupe.core.repository.local.*
import pl.jutupe.core.repository.local.CashierDatabase

val coreModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            CashierDatabase::class.java, "cashier-database"
        ).build()
    }

    single { get<CashierDatabase>().debtDao() }
    single { get<CashierDatabase>().debtorDao() }
    single { get<CashierDatabase>().groupDao() }
    single { get<CashierDatabase>().paymentDao() }

    single { DebtorRepository(get()) }
    single { DebtRepository(get()) }
    single { GroupRepository(get(), get()) }
    single { PaymentRepository(get()) }
}