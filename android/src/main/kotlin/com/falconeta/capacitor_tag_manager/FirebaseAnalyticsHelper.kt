package com.falconeta.capacitor_tag_manager

import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics.ConsentStatus
import com.google.firebase.analytics.FirebaseAnalytics.ConsentType
import org.json.JSONArray
import org.json.JSONObject


class FirebaseAnalyticsHelper {
    companion object {
        fun createBundleFromJson(json: JSONObject?): Bundle {
            val bundle = Bundle()
            if (json == null) {
                return bundle
            }
            try {
                val iterator = json.keys()
                while (iterator.hasNext()) {
                    val key = iterator.next()
                    val value = json[key]
                    when (value.javaClass.simpleName) {
                        "Boolean" -> bundle.putBoolean(key, value as Boolean)
                        "Integer" -> bundle.putInt(key, value as Int)
                        "Double" -> bundle.putDouble(key, value as Double)
                        "Long" -> bundle.putLong(key, value as Long)
                        "Float" -> bundle.putFloat(key, value as Float)
                        "JSONObject" -> bundle.putBundle(
                            key,
                            createBundleFromJson(value as JSONObject)
                        )

                        "JSONArray" -> {
                            val array = value as JSONArray
                            val firstItem = if (array.length() == 0) null else array[0]
                            if (firstItem == null) {
                                break
                            }
                            when (firstItem.javaClass.simpleName) {
                                "Boolean" -> {
                                    val items = BooleanArray(array.length())
                                    var index = 0
                                    while (index < array.length()) {
                                        items[index] = array[index] as Boolean
                                        index++
                                    }
                                    bundle.putBooleanArray(key, items)
                                }

                                "Integer" -> {
                                    val items = IntArray(array.length())
                                    var index = 0
                                    while (index < array.length()) {
                                        items[index] = array[index] as Int
                                        index++
                                    }
                                    bundle.putIntArray(key, items)
                                }

                                "Double" -> {
                                    val items = DoubleArray(array.length())
                                    var index = 0
                                    while (index < array.length()) {
                                        items[index] = array[index] as Double
                                        index++
                                    }
                                    bundle.putDoubleArray(key, items)
                                }

                                "Long" -> {
                                    val items = LongArray(array.length())
                                    var index = 0
                                    while (index < array.length()) {
                                        items[index] = array[index] as Long
                                        index++
                                    }
                                    bundle.putLongArray(key, items)
                                }

                                "Float" -> {
                                    val items = FloatArray(array.length())
                                    var index = 0
                                    while (index < array.length()) {
                                        items[index] = array[index] as Float
                                        index++
                                    }
                                    bundle.putFloatArray(key, items)
                                }

                                "JSONObject" -> {
                                    val items = arrayOfNulls<Bundle>(array.length())
                                    var index = 0
                                    while (index < array.length()) {
                                        items[index] =
                                            createBundleFromJson(array.getJSONObject(index))
                                        index++
                                    }
                                    bundle.putParcelableArray(key, items)
                                }

                                else -> {
                                    val items = arrayOfNulls<String>(array.length())
                                    var index = 0
                                    while (index < array.length()) {
                                        items[index] = array.getString(index)
                                        index++
                                    }
                                    bundle.putStringArray(key, items)
                                }
                            }
                        }

                        else -> bundle.putString(key, value as String)
                    }
                }
            } catch (exception: Exception) {
                exception.printStackTrace()
            }
            return bundle
        }

        fun mapStringToConsentType(consentType: String?): ConsentType? {
            return when (consentType) {
                "AD_STORAGE" -> ConsentType.AD_STORAGE
                "ANALYTICS_STORAGE" -> ConsentType.ANALYTICS_STORAGE
                else -> null
            }
        }

        fun mapStringToConsentStatus(consentStatus: String?): ConsentStatus? {
            return when (consentStatus) {
                "GRANTED" -> ConsentStatus.GRANTED
                "DENIED" -> ConsentStatus.DENIED
                else -> null
            }
        }

    }


}