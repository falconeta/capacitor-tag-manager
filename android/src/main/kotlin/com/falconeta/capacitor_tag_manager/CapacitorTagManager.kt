package com.falconeta.capacitor_tag_manager

import android.content.Context
import android.os.Bundle
import android.util.Log
import com.getcapacitor.Bridge
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.FirebaseAnalytics.ConsentStatus
import com.google.firebase.analytics.FirebaseAnalytics.ConsentType
import org.json.JSONObject


class CapacitorTagManager(context: Context, bridge: Bridge) {

    private var _context: Context = context
    private var _bridge: Bridge = bridge

    fun getAppInstanceId(resultCallback: GetAppInstanceIdCallback) {
        getFirebaseAnalyticsInstance()
            .appInstanceId
            .addOnCompleteListener { task ->
                if (!task.isSuccessful) {
                    val exception = task.exception
                    Log.w(CapacitorTagManagerPlugin.TAG, "Get AppInstanceId failed.", exception)
                    resultCallback.error(exception?.message)
                    return@addOnCompleteListener
                }
                val appInstanceId: String = task.result
                resultCallback.success(appInstanceId)
            }
    }

    fun setConsent(
        consentType: ConsentType,
        consentStatus: ConsentStatus
    ) {
        val map: MutableMap<ConsentType, ConsentStatus> = HashMap()
        map[consentType] = consentStatus
        getFirebaseAnalyticsInstance().setConsent(map)
    }

    fun setUserId(userId: String?) {
        getFirebaseAnalyticsInstance().setUserId(userId)
    }

    fun setUserProperty(key: String, value: String?) {
        getFirebaseAnalyticsInstance().setUserProperty(key, value)
    }

    fun setCurrentScreen(screenName: String?, screenClass: String?) {
        val bundle = Bundle()
        bundle.putString(FirebaseAnalytics.Param.SCREEN_NAME, screenName)
        bundle.putString(FirebaseAnalytics.Param.SCREEN_CLASS, screenClass)

        _bridge
            .activity
            .runOnUiThread(
                Runnable {
                    getFirebaseAnalyticsInstance().logEvent(
                        FirebaseAnalytics.Event.SCREEN_VIEW,
                        bundle
                    )
                }
            )
    }

    fun logEvent(key: String, json: JSONObject?) {
        val bundle: Bundle = FirebaseAnalyticsHelper.createBundleFromJson(json)
        getFirebaseAnalyticsInstance().logEvent(key, bundle)
    }

    fun setSessionTimeoutDuration(duration: Long) {
        getFirebaseAnalyticsInstance().setSessionTimeoutDuration(duration)
    }

    fun setEnabled(enabled: Boolean) {
        getFirebaseAnalyticsInstance().setAnalyticsCollectionEnabled(enabled)
    }

    fun resetAnalyticsData() {
        getFirebaseAnalyticsInstance().resetAnalyticsData()
    }

    private fun getFirebaseAnalyticsInstance(): FirebaseAnalytics {
        return FirebaseAnalytics.getInstance(_context)
    }

}
