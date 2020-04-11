package id.radhika.feature.latihan1.screen.firstpractice

import id.radhika.feature.latihan1.data.Latihan1UseCase
import id.radhika.feature.latihan1.screen.secondpractice.SecondDao
import id.radhika.lib.mvvm.BaseVM

/**
 * Created by Radhika Yusuf Alifiansyah
 * on 05/Apr/2020
 **/
class FirstVM : BaseVM<FirstDao, Latihan1UseCase>() {

    override suspend fun onCreate() {

    }

    override fun getDao() =
        FirstDao()
    override fun createUseCase(): Latihan1UseCase = Latihan1UseCase()
}