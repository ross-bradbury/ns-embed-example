cp ./nativeScriptPart/node_modules/tns-core-modules/node_modules/tns-core-modules-widgets/platforms/android/widgets-release.aar ./existingAndroidApp/widgets-release/
cp ./nativeScriptPart/platforms/android/libs/runtime-libs/nativescript.aar ./existingAndroidApp/nativescript/
cp -R ./nativeScriptPart/platforms/android/src/main/assets/ ./existingAndroidApp/app/src/main/assets/
rm -R ./existingAndroidApp/app/src/main/assets/app/App_Resources/iOS/

cp -R ./nativeScriptPart/platforms/android/src/main/java/com/tns ./existingAndroidApp/app/src/main/java/
