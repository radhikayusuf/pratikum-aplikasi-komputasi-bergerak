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

    override fun getDao() = CodeVerifyDao()
    override fun createUseCase(): PretestUseCase = PretestUseCase()
}