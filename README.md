# USB 偵錯捷徑 / USB Debug Shortcut

[繁體中文](#繁體中文) | [English](#english)

---

## 繁體中文

### 簡介

這是一個極簡的 Android 工具 App，提供桌面捷徑，讓你一鍵直達系統「**開發人員選項**」頁面，省去每次手動翻找設定的步驟。

### 功能說明

- 點擊桌面圖示，顯示 App 介紹說明
- 點擊按鈕，立即跳轉至「開發人員選項」
- 跳轉後 App 自動關閉，不佔用背景

### 限制說明

基於 Android 的安全設計，無 root 權限的 App **無法直接開啟或關閉 USB 偵錯**。本 App 只負責導航到正確的設定頁面，最後一步需使用者自行手動操作。

### 安裝方式

至 [Releases](../../releases) 頁面下載最新的 `app-debug.apk`，傳至裝置後直接安裝。

> 安裝前請確認已在「設定 → 安全性」中允許安裝來自未知來源的應用程式。

### 建置方式

```bash
# 建置 Debug APK
./gradlew assembleDebug

# 輸出路徑
app/build/outputs/apk/debug/app-debug.apk
```

### 發布流程

推送符合 `v*` 格式的 Git tag，GitHub Actions 會自動建置並發布 Release：

```bash
git tag v1.0.1
git push origin v1.0.1
```

### 系統需求

- Android 7.0（API 24）以上

---

## English

### Overview

A minimal Android utility app that provides a home screen shortcut to jump directly to the system **Developer Options** page — no more digging through nested settings menus.

### Features

- Tap the app icon to view a brief introduction screen
- Tap the button to navigate immediately to Developer Options
- App closes itself after redirecting, leaving no background process

### Limitation

Due to Android's security model, apps without root access **cannot programmatically enable or disable USB debugging**. This app only navigates you to the correct settings page; you need to toggle the switch manually.

### Installation

Download the latest `app-debug.apk` from the [Releases](../../releases) page and install it on your device.

> Make sure to enable "Install from unknown sources" in your device settings before installing.

### Build

```bash
# Build debug APK
./gradlew assembleDebug

# Output path
app/build/outputs/apk/debug/app-debug.apk
```

### Release

Push a Git tag matching `v*` to trigger the GitHub Actions workflow, which builds and publishes a new Release automatically:

```bash
git tag v1.0.1
git push origin v1.0.1
```

### Requirements

- Android 7.0 (API 24) or higher
