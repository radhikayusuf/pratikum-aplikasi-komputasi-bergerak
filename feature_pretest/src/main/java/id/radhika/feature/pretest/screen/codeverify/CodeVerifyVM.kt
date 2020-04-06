package id.radhika.feature.pretest.screen.codeverify

import id.radhika.feature.pretest.data.PretestUseCase
import id.radhika.lib.mvvm.BaseVM

/**
 * Created by Radhika Yusuf Alifiansyah
 * on 05/Apr/2020
 **/
class CodeVerifyVM : BaseVM<CodeVerifyDao, PretestUseCase>() {

    override suspend fun onCreate() {

    }

    fun validateValue(code: String?) {
        contentData.errorCode = null

        var validResult = true
        if (code?.trim()?.length ?: 0 < 4) {
            validResult = false
            contentData.errorCode = "Harap isi code minimal 4 digit"
        }

        contentData.isValid = validResult
    }

    override fun getDao() = CodeVerifyDao()
    override fun createUseCase(): PretestUseCase = PretestUseCase()
}