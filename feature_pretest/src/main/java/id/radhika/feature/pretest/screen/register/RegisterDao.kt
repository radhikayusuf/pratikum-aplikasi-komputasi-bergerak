package id.radhika.feature.pretest.screen.register

import id.radhika.lib.mvvm.BaseDao
import id.radhika.lib.mvvm.util.LiveDao
import id.radhika.lib.mvvm.util.NullableLiveDao
import id.radhika.lib.mvvm.util.getValue
import id.radhika.lib.mvvm.util.setValue

/**
 * Created by Radhika Yusuf Alifiansyah
 * on 05/Apr/2020
 **/
class RegisterDao : BaseDao() {
    private val isValidData = LiveDao(false)
    var isValid by isValidData::content

    private val errorNameData = NullableLiveDao<String>(null)
    var errorName by errorNameData::content

    private val errorUmurData = NullableLiveDao<String>(null)
    var errorUmur by errorUmurData::content
}