package com.marketplace.data.service.preferenceservice

/**
 * Created by Mushegh Sahakyan on 2/14/2022.
 */
interface PreferenceService {
    fun setToken(token: String)
    fun getToken(): String?
}