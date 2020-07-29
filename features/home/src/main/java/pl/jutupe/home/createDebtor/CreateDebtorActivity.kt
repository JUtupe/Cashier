package pl.jutupe.home.createDebtor

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_create_debtor.*
import org.koin.android.viewmodel.ext.android.viewModel
import pl.jutupe.base.view.BaseActivity
import pl.jutupe.home.BR
import pl.jutupe.home.R
import pl.jutupe.home.databinding.ActivityCreateDebtorBinding

class CreateDebtorActivity : BaseActivity<ActivityCreateDebtorBinding, CreateDebtorViewModel>(),
    CreateDebtorNavigator {

    override val viewModel by viewModel<CreateDebtorViewModel>()
    override fun getLayoutId(): Int = R.layout.activity_create_debtor
    override fun getBindingVariable(): Int = BR.viewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.navigator = this
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

    override fun showFirstNameError() {
        input_first_name.error = getString(R.string.error_invalid_first_name)
    }

    override fun showLastNameError() {
        input_last_name.error = getString(R.string.error_invalid_last_name)
    }

    override fun showDebtorCreatedText() {
        Toast.makeText(this, R.string.information_debtor_created, Toast.LENGTH_SHORT).show()
    }

    override fun navigateBack() {
        onNavigateUp()
    }
}