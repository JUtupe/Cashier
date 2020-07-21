package pl.jutupe.home.di

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import pl.jutupe.home.debtors.DebtorsViewModel
import pl.jutupe.home.debts.DebtsViewModel
import pl.jutupe.home.statistics.StatisticsViewModel

val homeModule = module {
    viewModel { DebtorsViewModel() }
    viewModel { DebtsViewModel() }
    viewModel { StatisticsViewModel() }
}