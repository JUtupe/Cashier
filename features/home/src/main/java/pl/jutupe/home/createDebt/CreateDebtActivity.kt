package pl.jutupe.home.createDebt

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.lifecycle.observe
import org.koin.android.viewmodel.ext.android.viewModel
import pl.jutupe.base.view.BaseActivity
import pl.jutupe.home.R
import pl.jutupe.home.databinding.ActivityCreateDebtBinding

class CreateDebtActivity : BaseActivity<ActivityCreateDebtBinding, CreateDebtViewModel>(
    layoutId = R.layout.activity_create_debt
) {

    override val viewModel by viewModel<CreateDebtViewModel>()

    override fun onInitDataBinding() {
        binding.viewModel = viewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.events.observe(this, this::onViewEvent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_create, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean =
        when (item.itemId) {
            R.id.item_create -> { viewModel.onCreateButtonClicked(); true }
            else -> super.onOptionsItemSelected(item)
        }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    private fun onViewEvent(event: CreateDebtViewEvent) {
        when(event) {
            is CreateDebtViewEvent.NavigateUp ->
                finish()
            is CreateDebtViewEvent.ShowDebtCreatedInformation ->
                Toast.makeText(this, R.string.information_debt_created, Toast.LENGTH_SHORT).show()
        }
    }
}