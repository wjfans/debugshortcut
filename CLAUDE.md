# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Build Commands

```bash
# Build debug APK
./gradlew assembleDebug

# Build release APK
./gradlew assembleRelease

# Clean build
./gradlew clean

# Run unit tests
./gradlew test

# Run instrumented tests (requires connected device/emulator)
./gradlew connectedAndroidTest
```

Output APK is at `app/build/outputs/apk/debug/app-debug.apk`.

## Release Process

Releases are automated via GitHub Actions (`.github/workflows/release-debug.yml`). Pushing a tag matching `v*` triggers a build and creates a GitHub Release with the debug APK attached.

```bash
git tag v1.0.1
git push origin v1.0.1
```

## Architecture

This is a minimal single-Activity Android app (Kotlin, minSdk 24, targetSdk 34, applicationId `idv.shuhao.usbdebugshortcut`).

**Core behavior:** `MainActivity` has no layout. On `onCreate`, it immediately fires `Settings.ACTION_APPLICATION_DEVELOPMENT_SETTINGS` via an `Intent` to open the system Developer Options page, then calls `finish()`. If the intent fails (e.g., device has no Developer Options), a Toast is shown before finishing. The app never renders its own UI.

**Design constraint:** Without root, Android does not allow apps to toggle USB debugging programmatically — this app can only navigate the user to the correct settings page.
