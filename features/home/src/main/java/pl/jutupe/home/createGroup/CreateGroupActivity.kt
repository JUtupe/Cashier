package pl.jutupe.home.createGroup

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.lifecycle.observe
import org.koin.android.viewmodel.ext.android.viewModel
import pl.jutupe.base.view.BaseActivity
import pl.jutupe.home.R
import pl.jutupe.home.databinding.ActivityCreateGroupBinding

class CreateGroupActivity : BaseActivity<ActivityCreateGroupBinding, CreateGroupViewModel>(
    layoutId = R.layout.activity_create_group
) {

    override val viewModel by viewModel<CreateGroupViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.events.observe(this, this::onViewEvent)
    }

    override fun onInitDataBinding() {
        binding.viewModel = viewModel
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

    private fun onViewEvent(event: CreateGroupViewEvent) {
        when(event) {
            is CreateGroupViewEvent.NavigateBack ->
                onNavigateUp()
            is CreateGroupViewEvent.ShowGroupCreatedInformation ->
                Toast.makeText(this, R.string.information_group_created, Toast.LENGTH_SHORT).show()
        }
    }
}