# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile


#-dontshrink


#-keep class com.example.lin.learnproguard.utils.Keep
#
#-keepattributes InnerClasses
#-keep @com.example.lin.learnproguard.utils.Keep class * {*;}
#-keep @com.example.lin.learnproguard.utils.Keep class *$* {*;}

#-keep class * extends @com.example.lin.learnproguard.utils.Keep class {*;}
#-keep class annotation.keeps.keeps.Keep

#仅不混淆某个类名
#-keepnames class com.example.lin.learnproguard.test.Test
#不混淆某个内部类名
#-keepnames class com.example.lin.learnproguard.test.Test$Test3
#
#
#-keep class android.support.annotation.keeps.Keep
#-keep class * {
#    @android.support.annotation.keeps.Keep <fields>;
#}
#
#-keepclassmembernames class com.example.lin.learnproguard.test.Test{
#    <fields>;
#}

###################接口############################
#name
-dontwarn io.lim.**