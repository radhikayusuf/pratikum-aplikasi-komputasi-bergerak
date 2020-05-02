package id.radhika.feature.practicelocalstorage.screen.form

import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import id.radhika.feature.practicelocalstorage.databinding.ScreenDialogFormBinding
import id.radhika.lib.mvvm.BaseScreen


/**
 * Created by Radhika Yusuf Alifiansyah
 * on 02/May/2020
 **/
object FormScreenDialog {

    fun showFormDialog(screen: BaseScreen<*, *, *>, callback: (AlertDialog, String, String) -> Unit) {
        val binding = ScreenDialogFormBinding.inflate(LayoutInflater.from(screen.requireContext()))
        val dialog = AlertDialog.Builder(screen.requireContext()).also { builder ->
            builder.setView(binding.root)
            builder.setCancelable(true)
        }.create()
        binding.apply {
            buttonSubmit.setOnClickListener {
                if (textNotes.text.trim().isNotEmpty() && textTitle.text.trim().isNotEmpty()) {
                    callback.invoke(dialog, textTitle.text.trim().toString(), textNotes.text.trim().toString())
                } else {
                    screen.vm.showToast("Harap isi value dengan benar")
                }
            }
        }
        dialog.show()
    }
}
