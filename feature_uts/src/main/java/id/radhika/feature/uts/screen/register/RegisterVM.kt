package id.radhika.feature.uts.screen.register

import id.radhika.feature.uts.data.UTSUseCase
import id.radhika.lib.mvvm.BaseVM

/**
 * Created by Radhika Yusuf Alifiansyah
 * on 16/May/2020
 **/
class RegisterVM : BaseVM<RegisterDao, UTSUseCase>() {

    override suspend fun onCreate() {

    }

    fun validateValue(
        name: String?,
        umur: String?,
        isMale: Boolean,
        isFemale: Boolean
    ) {
        contentData.errorName = null
        contentData.errorUmur = null
        contentData.errorGender = null

        var validResult = true
        if (name?.trim().isNullOrEmpty()) {
            validResult = false
            contentData.errorName = "Harap isi nama"
        }

        if (umur?.trim().isNullOrEmpty()) {
            validResult = false
            contentData.errorUmur = "Harap isi umur"
        } else if (umur!!.toInt() < 1) {
            validResult = false
            contentData.errorUmur = "Harap isi umur dengan benar"
        }

        if ((isFemale || isMale).not()) {
            validResult = false
            contentData.errorGender = "Harap pilih jenis kelamin"
        }

        contentData.isValid = validResult
    }

    override fun getDao() = RegisterDao()

    override fun createUseCase() = UTSUseCase()
}