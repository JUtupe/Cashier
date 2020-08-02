package pl.jutupe.home.createGroup

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.observe
import kotlinx.coroutines.flow.collectLatest
import org.koin.android.viewmodel.ext.android.viewModel
import pl.jutupe.base.view.BaseActivity
import pl.jutupe.home.R
import pl.jutupe.home.createGroup.adapter.SelectableDebtorAdapter
import pl.jutupe.home.databinding.ActivityCreateGroupBinding

class CreateGroupActivity : BaseActivity<ActivityCreateGroupBinding, CreateGroupViewModel>(
    layoutId = R.layout.activity_create_group
) {

    override val viewModel by viewModel<CreateGroupViewModel>()

    private val debtorAdapter = SelectableDebtorAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        debtorAdapter.selectionTracker = viewModel.selectionTracker
        viewModel.events.observe(this, this::onViewEvent)
        lifecycleScope.launchWhenCreated {
            viewModel.debtors.collectLatest {
                debtorAdapter.submitData(it)
            }
        }
    }

    override fun onInitDataBinding() {
        binding.viewModel = viewModel
        binding.recyclerView.adapter = debtorAdapter
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

    private fun onViewEvent(event: CreateGroupViewEvent) {
        when(event) {
            is CreateGroupViewEvent.NavigateBack ->
                finish()
            is CreateGroupViewEvent.ShowGroupCreatedInformation ->
                Toast.makeText(this, R.string.information_group_created, Toast.LENGTH_SHORT).show()
            is CreateGroupViewEvent.ShowEmptySelectionError ->
                Toast.makeText(this, R.string.error_empty_debtors_selection, Toast.LENGTH_SHORT).show()
            is CreateGroupViewEvent.ShowInvalidGroupNameError ->
                binding.inputName.error = getString(R.string.error_invalid_group_name)
            is CreateGroupViewEvent.ShowCreateGroupError ->
                Toast.makeText(this, R.string.error_something_went_wrong, Toast.LENGTH_SHORT).show()
        }
    }
}