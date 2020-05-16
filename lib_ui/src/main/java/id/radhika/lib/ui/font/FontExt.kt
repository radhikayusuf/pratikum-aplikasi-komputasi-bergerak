package id.radhika.lib.ui.font

import android.graphics.Typeface
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * Created by Radhika Yusuf Alifiansyah
 * on 16/May/2020
 **/

fun TextView.fontFace(fontNameExt: String) {
    try {
        typeface = Typeface.createFromAsset(
            context.applicationContext.assets,
            "fonts/$fontNameExt"
        )
    } catch (e: Exception) { }


    fun ViewGroup.getViewsByTag(
        root: ViewGroup,
        tag: String
    ): ArrayList<View>? {
        val views = ArrayList<View>()
        val childCount = root.childCount
        for (i in 0 until childCount) {
            val child = root.getChildAt(i)
            if (child is ViewGroup) {
                views.addAll(getViewsByTag(child, tag)!!)
            }
            val tagObj = child.tag
            if (tagObj != null && tagObj == tag) {
                views.add(child)
            }
        }
        return views
    }
}

