package id.radhika.lib.mvvm.util

import android.os.Bundle
import android.widget.Toast
import androidx.annotation.AnimRes
import androidx.annotation.AnimatorRes
import androidx.annotation.IdRes
import androidx.annotation.StringRes
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import id.radhika.lib.mvvm.BaseScreen

/**
 * Created by Radhika Yusuf Alifiansyah
 * on 05/Apr/2020
 **/

fun BaseScreen<*, *, *>.showToast(value: String, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(requireContext(), value, length).show()
}

fun BaseScreen<*, *, *>.showToast(@StringRes value: Int, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(requireContext(), value, length).show()
}

fun BaseScreen<*, *, *>.screenTag() = this::class.java.simpleName

fun FragmentTransaction.addScreen(screen: BaseScreen<*, *, *>) {
    add(screen, screen.screenTag())
}

fun FragmentManager.showScreen(screen: BaseScreen<*, *, *>) {
    beginTransaction().also { transact ->
        transact.show(screen)
    }.commit()
}

fun FragmentManager.replaceScreen(
    screen: BaseScreen<*, *, *>, @IdRes id: Int,
    @AnimatorRes @AnimRes animIn: Int = -1,
    @AnimatorRes @AnimRes animOut: Int = -1,
    argument: (Bundle.() -> Unit)? = null
) {
    beginTransaction().also { transact ->
        if (animIn != -1 && animOut != -1)
            transact.setCustomAnimations(animIn, animOut)

        transact.replace(id, screen.also {
            val arg = Bundle()
            argument?.invoke(arg)
            it.setArguments(arg)
        })
    }.commit()
}

fun FragmentManager.hideAll() {
    val contents = fragments
    beginTransaction().also { transact ->
        contents.forEach { transact.hide(it) }
    }.commit()
}