package com.example.usbdebugshortcut

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    companion object {
        const val ACTION_GO_DIRECT = "com.example.usbdebugshortcut.ACTION_GO_DIRECT"
        private const val PREFS_NAME = "prefs"
        private const val KEY_SKIP_INTRO = "skip_intro"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // App Shortcut 長按直接跳轉，略過介紹畫面
        if (intent.action == ACTION_GO_DIRECT) {
            navigateToDeveloperOptions()
            return
        }

        val prefs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        if (prefs.getBoolean(KEY_SKIP_INTRO, false)) {
            navigateToDeveloperOptions()
            return
        }

        setContentView(R.layout.activity_main)

        val checkSkip = findViewById<CheckBox>(R.id.checkSkipIntro)
        checkSkip.setOnCheckedChangeListener { _, isChecked ->
            prefs.edit().putBoolean(KEY_SKIP_INTRO, isChecked).apply()
        }

        findViewById<Button>(R.id.btnGo).setOnClickListener {
            navigateToDeveloperOptions()
        }
    }

    private fun navigateToDeveloperOptions() {
        try {
            startActivity(buildDeveloperOptionsIntent(this))
            finish()
        } catch (e: Exception) {
            Toast.makeText(this, getString(R.string.error_no_dev_options), Toast.LENGTH_LONG).show()
            e.printStackTrace()
        }
    }
}
