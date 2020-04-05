package id.radhika.feature.pretest.screen.information

import id.radhika.feature.pretest.data.PretestUseCase
import id.radhika.feature.pretest.screen.register.InformationDao
import id.radhika.lib.mvvm.BaseVM

/**
 * Created by Radhika Yusuf Alifiansyah
 * on 05/Apr/2020
 **/
class InformationVM : BaseVM<CodeVerifyDao, PretestUseCase>() {

    override suspend fun onCreate() {

    }

    override fun getDao() = CodeVerifyDao()
    override fun createUseCase(): PretestUseCase = PretestUseCase()
}