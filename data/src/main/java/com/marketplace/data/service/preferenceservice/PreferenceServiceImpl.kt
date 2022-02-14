package com.marketplace.data.service.preferenceservice

import android.content.Context
import com.marketplace.data.util.TOKEN

/**
 * Created by Mushegh Sahakyan on 2/14/2022.
 */
internal class PreferenceServiceImpl(private val context: Context): PreferenceService {
    val sharedPreferences = context.getSharedPreferences("userData", Context.MODE_PRIVATE)

    override fun setToken(token: String) {
        sharedPreferences.edit().putString(TOKEN, token).apply()
    }

    override fun getToken() = sharedPreferences.getString(TOKEN, "")
}