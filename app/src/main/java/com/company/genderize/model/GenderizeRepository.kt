package com.company.genderize.model

import com.company.genderize.retrofit.RetrofitObject

class GenderizeRepository {
    fun getTestName(count : String): Genderize {
        return when (count) {
            "1" -> Genderize("peter", "male", 0.99, 165452)
            "2" -> Genderize ("sarah", "female", 0.98, 174584)
            "3" -> Genderize("luke", "male", 0.99, 16791)
            "4" -> Genderize("beatrice", "female", 0.98, 24617)
            else -> Genderize("alex", "male", 0.90, 411319)
        }
    }

    suspend fun getName(name: String): Genderize {
        return RetrofitObject.api.getNameData(name)
    }
}