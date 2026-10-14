# ComposeAnimations

Course-based Kotlin and Jetpack Compose exercises for exploring Android animations.

## Examples

- [AnimateContent](app/src/main/java/com/sumin/composeanimations/ui/screen/AnimateContent.kt) switches between two screens with sliding transitions.
- [Test](app/src/main/java/com/sumin/composeanimations/ui/screen/Test.kt) demonstrates animated size, shape, border width, color, alpha and continuous rotation.

The app launches `AnimateContent` from `MainActivity`. To explore the state-driven examples, select the `Test` composable in the activity's content.

## Build

The project uses Android SDK 32 and supports Android API 24 and later. Open the project in Android Studio with a compatible toolchain, or run:

```sh
./gradlew \
  :app:assembleDebug
```

A fresh APK build was not verified as part of this documentation update.

## Project history

This is a historical learning project. The original contributor credits, including [sumin93](https://github.com/sumin93), remain in the commit history.
