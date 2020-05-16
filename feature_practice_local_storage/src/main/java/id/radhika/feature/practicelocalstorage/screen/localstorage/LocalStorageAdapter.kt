package id.radhika.feature.practicelocalstorage.screen.localstorage

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.radhika.feature.practicelocalstorage.data.database.entity.UserNoteEntity
import id.radhika.feature.practicelocalstorage.databinding.ItemLocalStorageBinding

/**
 * Created by Radhika Yusuf Alifiansyah
 * on 02/May/2020
 **/

class LocalStorageAdapter: RecyclerView.Adapter<LocalStorageAdapter.VH>() {

    private val data: MutableList<UserNoteEntity> = mutableListOf()
    var onClickItem: ((UserNoteEntity) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        VH(ItemLocalStorageBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(data[position], onClickItem)
    }

    fun render(dao: LocalStorageDao) {
        data.clear()
        data.addAll(dao.notes)
        notifyDataSetChanged()
    }

    class VH(private val itemBinding: ItemLocalStorageBinding) : RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(
            userNoteEntity: UserNoteEntity,
            onClickItem: ((UserNoteEntity) -> Unit)?
        ) {
            itemBinding.titleContent.text = userNoteEntity.title
            itemBinding.notesContent.text = userNoteEntity.notes
            itemBinding.deleteItem.setOnClickListener {
                onClickItem?.invoke(userNoteEntity)
            }
        }
    }
}