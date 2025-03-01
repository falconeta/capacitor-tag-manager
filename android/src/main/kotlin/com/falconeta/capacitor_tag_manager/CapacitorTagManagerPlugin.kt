package com.falconeta.capacitor_tag_manager

import android.Manifest
import android.os.Build
import com.getcapacitor.*
import com.getcapacitor.annotation.CapacitorPlugin
import com.getcapacitor.annotation.Permission
import com.getcapacitor.annotation.PermissionCallback


@CapacitorPlugin(
  name = "CapacitorTagManager",
)
class CapacitorTagManagerPlugin : Plugin() {
  private lateinit var implementation: CapacitorTagManager;

  override fun load() {
    super.load();
    implementation = CapacitorTagManager(context);
  }

  

  @PluginMethod
  fun logEvent(call: PluginCall) {
    implementation.logEvent(call)
  }

}
