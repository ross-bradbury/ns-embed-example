# Embedding NativeScript in Existing Android App

This is an example of NativeScript embedded in a Java-based Android app.

### Building

```sh
# Build Nativescript project
cd nativeScriptPart
tns build android

# copy NativeScript project output into Java project
cd ..
./embed.sh

# Build and install java project
cd existingAndroidApp
./gradlew assembleDebug installDebug 
```
