package pl.jutupe.home.di

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import pl.jutupe.home.createDebt.CreateDebtViewModel
import pl.jutupe.home.createDebtor.CreateDebtorViewModel
import pl.jutupe.home.createGroup.CreateGroupViewModel
import pl.jutupe.home.createGroup.LongSelectionTracker
import pl.jutupe.home.debtors.DebtorsViewModel
import pl.jutupe.home.debts.DebtsViewModel
import pl.jutupe.home.groups.GroupsViewModel

val homeModule = module {
    viewModel { DebtorsViewModel(get()) }
    viewModel { DebtsViewModel(get()) }
    viewModel { GroupsViewModel(get()) }

    factory { LongSelectionTracker() }

    viewModel { CreateGroupViewModel(get(), get(), get()) }
    viewModel { CreateDebtorViewModel(get()) }
    viewModel { CreateDebtViewModel() }
}