package pl.jutupe.home.createDebtor

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.lifecycle.observe
import kotlinx.android.synthetic.main.activity_create_debtor.*
import org.koin.android.viewmodel.ext.android.viewModel
import pl.jutupe.base.view.BaseActivity
import pl.jutupe.home.R
import pl.jutupe.home.databinding.ActivityCreateDebtorBinding

class CreateDebtorActivity : BaseActivity<ActivityCreateDebtorBinding, CreateDebtorViewModel>(
    layoutId = R.layout.activity_create_debtor
) {

    override val viewModel by viewModel<CreateDebtorViewModel>()

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

    private fun onViewEvent(event: CreateDebtorViewEvent) {
        when(event) {
            is CreateDebtorViewEvent.NavigateBack ->
                finish()
            is CreateDebtorViewEvent.ShowFirstNameError ->
                binding.inputFirstName.error = getString(R.string.error_invalid_first_name)
            is CreateDebtorViewEvent.ShowLastNameError ->
                binding.inputLastName.error = getString(R.string.error_invalid_last_name)
            is CreateDebtorViewEvent.ShowDebtorCreatedInformation ->
                Toast.makeText(this, R.string.information_debtor_created, Toast.LENGTH_SHORT).show()
            is CreateDebtorViewEvent.ShowCreateDebtorError ->
                Toast.makeText(this, R.string.error_something_went_wrong, Toast.LENGTH_SHORT).show()
        }
    }
}