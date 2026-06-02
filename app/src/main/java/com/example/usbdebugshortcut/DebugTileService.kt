package com.example.usbdebugshortcut

import android.app.PendingIntent
import android.os.Build
import android.service.quicksettings.TileService

class DebugTileService : TileService() {
    override fun onClick() {
        super.onClick()
        val intent = buildDeveloperOptionsIntent(this)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.UPSIDE_DOWN_CAKE) {
            val pi = PendingIntent.getActivity(
                this, 0, intent,
                PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
            )
            startActivityAndCollapse(pi)
        } else {
            @Suppress("DEPRECATION")
            startActivityAndCollapse(intent)
        }
    }
}
