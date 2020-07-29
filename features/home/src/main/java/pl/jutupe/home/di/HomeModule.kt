package pl.jutupe.home.di

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import pl.jutupe.home.createDebt.CreateDebtViewModel
import pl.jutupe.home.createDebtor.CreateDebtorViewModel
import pl.jutupe.home.createGroup.CreateGroupViewModel
import pl.jutupe.home.debtors.DebtorsViewModel
import pl.jutupe.home.debtors.paging.DebtorPagingSourceFactory
import pl.jutupe.home.debts.DebtsViewModel
import pl.jutupe.home.groups.GroupsViewModel
import pl.jutupe.home.statistics.StatisticsViewModel

val homeModule = module {
    viewModel { DebtorsViewModel(get()) }
    viewModel { DebtsViewModel() }
    viewModel { StatisticsViewModel() }
    viewModel { GroupsViewModel() }

    viewModel { CreateGroupViewModel() }
    viewModel { CreateDebtorViewModel(get()) }
    viewModel { CreateDebtViewModel() }

    single { DebtorPagingSourceFactory(get()) }
}