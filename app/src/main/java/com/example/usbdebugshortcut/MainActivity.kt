package com.example.usbdebugshortcut

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 不需要設定佈局，因為我們直接跳轉
        // setContentView(R.layout.activity_main)

        navigateToDeveloperOptions()
    }

    private fun navigateToDeveloperOptions() {
        try {
            val intent = Intent(Settings.ACTION_APPLICATION_DEVELOPMENT_SETTINGS)
            startActivity(intent)
            // 跳轉後關閉當前 Activity，避免用戶返回 App
            finish()
        } catch (e: Exception) {
            // 處理無法跳轉的情況，例如設備沒有開發人員選項或 Intent 無法解析
            Toast.makeText(this, "無法打開開發人員選項，請手動前往設定。", Toast.LENGTH_LONG).show()
            e.printStackTrace()
            finish() // 無法跳轉也關閉 App
        }
    }
}