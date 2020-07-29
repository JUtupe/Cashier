package pl.jutupe.home.createGroup

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import org.koin.android.viewmodel.ext.android.viewModel
import pl.jutupe.base.view.BaseActivity
import pl.jutupe.home.BR
import pl.jutupe.home.R
import pl.jutupe.home.databinding.ActivityCreateGroupBinding

class CreateGroupActivity : BaseActivity<ActivityCreateGroupBinding, CreateGroupViewModel>(),
    CreateGroupNavigator {

    override val viewModel by viewModel<CreateGroupViewModel>()
    override fun getLayoutId(): Int = R.layout.activity_create_group
    override fun getBindingVariable(): Int = BR.viewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.navigator = this
        viewModel.loadDebtors()
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

    override fun navigateBack() {
        onNavigateUp()
    }
}