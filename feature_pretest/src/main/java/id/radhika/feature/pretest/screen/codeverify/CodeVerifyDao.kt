package id.radhika.feature.pretest.screen.codeverify

import id.radhika.lib.mvvm.BaseDao
import id.radhika.lib.mvvm.util.LiveDao
import id.radhika.lib.mvvm.util.NullableLiveDao
import id.radhika.lib.mvvm.util.getValue
import id.radhika.lib.mvvm.util.setValue

/**
 * Created by Radhika Yusuf Alifiansyah
 * on 05/Apr/2020
 **/
class CodeVerifyDao : BaseDao() {

    private val isValidData = LiveDao(false)
    var isValid by isValidData::content

    private val errorCodeName = NullableLiveDao<String>(null)
    var errorCode by errorCodeName::content
}