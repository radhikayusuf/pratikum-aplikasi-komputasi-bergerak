package id.radhika.feature.uts.screen.register

import id.radhika.lib.mvvm.BaseDao
import id.radhika.lib.mvvm.util.LiveDao
import id.radhika.lib.mvvm.util.NullableLiveDao
import id.radhika.lib.mvvm.util.getValue
import id.radhika.lib.mvvm.util.setValue

/**
 * Created by Radhika Yusuf Alifiansyah
 * on 16/May/2020
 **/
class RegisterDao : BaseDao() {

    private val isValidData = LiveDao(false)
    var isValid by isValidData::content

    private val errorNameData = NullableLiveDao<String>(null)
    var errorName by errorNameData::content

    private val errorUmurData = NullableLiveDao<String>(null)
    var errorUmur by errorUmurData::content

    private val errorGenderData = NullableLiveDao<String>(null)
    var errorGender by errorGenderData::content
}