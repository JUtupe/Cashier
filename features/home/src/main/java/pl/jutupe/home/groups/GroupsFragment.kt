package pl.jutupe.home.groups

import android.os.Bundle
import android.view.View
import org.koin.android.viewmodel.ext.android.viewModel
import pl.jutupe.base.NavActions
import pl.jutupe.base.view.BaseFragment
import pl.jutupe.home.BR
import pl.jutupe.home.R
import pl.jutupe.home.databinding.FragmentGroupsBinding

class GroupsFragment : BaseFragment<FragmentGroupsBinding, GroupsViewModel>(),
    GroupsNavigator {

    override val viewModel by viewModel<GroupsViewModel>()
    override fun getLayoutId(): Int = R.layout.fragment_groups
    override fun getBindingVariable(): Int = BR.viewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.navigator = this
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.loadGroups()
    }

    override fun openCreateGroupView() {
        context?.let {
            startActivity(NavActions.actionCreateGroup(it))
        }
    }
}