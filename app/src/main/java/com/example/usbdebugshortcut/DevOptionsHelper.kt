package com.example.usbdebugshortcut

import android.content.Context
import android.content.Intent
import android.provider.Settings

@Suppress("DEPRECATION")
fun buildDeveloperOptionsIntent(context: Context): Intent {
    val pm = context.packageManager
    val candidates = listOf(
        Intent(Settings.ACTION_APPLICATION_DEVELOPMENT_SETTINGS),
        Intent("android.settings.DEVELOPMENT_SETTINGS")
    )
    return candidates.firstOrNull { it.resolveActivity(pm) != null }
        ?: Intent(Settings.ACTION_SETTINGS)
}
