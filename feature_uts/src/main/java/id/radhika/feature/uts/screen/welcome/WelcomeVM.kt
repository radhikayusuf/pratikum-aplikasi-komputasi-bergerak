package id.radhika.feature.uts.screen.welcome

import id.radhika.feature.uts.data.UTSUseCase
import id.radhika.lib.mvvm.BaseVM

/**
 * Created by Radhika Yusuf Alifiansyah
 * on 16/May/2020
 **/
class WelcomeVM : BaseVM<WelcomeDao, UTSUseCase>() {

    override suspend fun onCreate() {

    }

    override fun getDao() = WelcomeDao()

    override fun createUseCase() = UTSUseCase()
}