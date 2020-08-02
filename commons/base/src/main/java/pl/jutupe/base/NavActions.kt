package pl.jutupe.base

import android.content.Context
import android.content.Intent

object NavActions {

    private const val ACTION_PREFIX = "pl.jutupe.cashier.action"

    fun actionCreateDebtor(context: Context): Intent =
        createInternalIntent(context, "$ACTION_PREFIX.create.debtor")
            .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)

    fun actionCreateDebt(context: Context): Intent =
        createInternalIntent(context, "$ACTION_PREFIX.create.debt")
            .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)

    fun actionCreateGroup(context: Context): Intent =
        createInternalIntent(context, "$ACTION_PREFIX.create.group")
            .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)

    private fun createInternalIntent(context: Context, action: String): Intent =
        Intent(action).setPackage(context.packageName)
}