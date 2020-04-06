package id.radhika.feature.pretest.screen.information

import id.radhika.feature.pretest.data.PretestUseCase
import id.radhika.lib.mvvm.BaseVM

/**
 * Created by Radhika Yusuf Alifiansyah
 * on 05/Apr/2020
 **/
class InformationVM : BaseVM<InformationDao, PretestUseCase>() {

    override suspend fun onCreate() {

    }

    override fun getDao() = InformationDao()
    override fun createUseCase(): PretestUseCase = PretestUseCase()
}