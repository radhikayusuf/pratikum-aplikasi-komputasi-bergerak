package id.radhika.feature.practicelocalstorage.screen.localstorage

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import id.radhika.feature.practicelocalstorage.R
import id.radhika.feature.practicelocalstorage.databinding.ScreenLocalStorageBinding
import id.radhika.feature.practicelocalstorage.screen.form.FormScreenDialog
import id.radhika.lib.mvvm.BaseScreen
import id.radhika.lib.mvvm.util.convertLongToTime
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat

/**
 * Created by Radhika Yusuf Alifiansyah
 * on 02/May/2020
 **/
class LocalStorageScreen : BaseScreen<ScreenLocalStorageBinding, LocalStorageVM, LocalStorageDao>(
    ScreenLocalStorageBinding::inflate
), View.OnClickListener, TextWatcher {

    private val localStrAdapter by lazy { LocalStorageAdapter() }

    override fun onViewReady() {
        binding.toolbar.setNavigationOnClickListener { requireActivity().onBackPressed() }
        binding.buttonAddNotes.setOnClickListener(this@LocalStorageScreen)
        binding.searchBar.addTextChangedListener(this@LocalStorageScreen)

        binding.recyclerNotes.adapter = localStrAdapter
        binding.recyclerNotes.layoutManager = LinearLayoutManager(requireContext())
        localStrAdapter.onClickItem = { item ->
            vm.deleteItem(item)
        }
    }

    override fun onResume() {
        super.onResume()
        launch { vm.refreshData() }
    }

    override fun render() = { dao: LocalStorageDao ->
        localStrAdapter.render(dao)

        if (dao.lastEdited != 0L) {
            binding.textLastEdited.text = getString(R.string.text_last_edited_s, dao.lastEdited.convertLongToTime())
            binding.textLastEdited.visibility = View.VISIBLE
        }
    }

    override fun getViewModel() = LocalStorageVM::class.java


    override fun onClick(v: View?) {
        FormScreenDialog.showFormDialog(this@LocalStorageScreen) { dialog, title, notes ->
            dialog.dismiss()
            vm.insertNotes(title, notes)
        }
    }

    override fun afterTextChanged(s: Editable?) = Unit

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) = Unit

    override fun onTextChanged(charSequence: CharSequence?, start: Int, before: Int, count: Int) {
        charSequence?.toString()?.let { text ->
            launch { vm.searchNotes(text) }
        }
    }
}
