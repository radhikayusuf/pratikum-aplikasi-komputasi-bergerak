package id.radhika.feature.pretest.screen.welcome

import id.radhika.feature.pretest.data.PretestUseCase
import id.radhika.lib.mvvm.BaseVM

/**
 * Created by Radhika Yusuf Alifiansyah
 * on 05/Apr/2020
 **/
class WelcomeVM : BaseVM<WelcomeDao, PretestUseCase>() {

    override suspend fun onCreate() {

    }

    override fun getDao() = WelcomeDao()
    override fun createUseCase(): PretestUseCase = PretestUseCase()
}