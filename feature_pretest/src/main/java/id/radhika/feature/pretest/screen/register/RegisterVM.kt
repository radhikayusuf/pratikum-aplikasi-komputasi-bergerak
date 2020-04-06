package id.radhika.feature.pretest.screen.register

import id.radhika.feature.pretest.data.PretestUseCase
import id.radhika.lib.mvvm.BaseVM

/**
 * Created by Radhika Yusuf Alifiansyah
 * on 05/Apr/2020
 **/
class RegisterVM : BaseVM<RegisterDao, PretestUseCase>() {

    override suspend fun onCreate() {

    }

    fun validateValue(name: String?, umur: String?) {
        contentData.errorName = null
        contentData.errorUmur = null

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
            contentData.errorUmur = "Harap isi umur dengan benar, umur minimal 20 tahun"
        }

        contentData.isValid = validResult
    }

    override fun getDao() = RegisterDao()
    override fun createUseCase(): PretestUseCase = PretestUseCase()
}