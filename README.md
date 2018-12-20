# ViewNameTracker

[![](https://jitpack.io/v/chewenkai/ViewNameTracker.svg)](https://jitpack.io/#chewenkai/ViewNameTracker)

### Brief Introduction:
An Android Library to print the name of current top Activity or Fragment or the view you just clicked for helping read and understand source code rapidly.

### So, What exactly is this?
After you add this library to your project, you can read the name stack of following Android component from **Logcat** by searching the Tag **"NameTracker"** ：
- Activity 
- Fragment 
- The view you just clicked.（including the id of the view, and the source position that you can just click to jump）

For example:

``` bash
2018-11-06 16:00:07.605 20362-20362/com.chewenkai.example I/NameTracker: ➤ Where am I？ Activity:MainActivity
 2018-11-06 16:00:07.605 20362-20362/com.chewenkai.example I/NameTracker: ➤ Where am I？ Activity:MainActivity
 2018-11-06 16:00:07.605 20362-20362/com.chewenkai.example I/NameTracker: ➤ Where am I？ Activity:MainActivity
 2018-11-06 16:00:07.711 20362-20362/com.chewenkai.example I/NameTracker:         ➤ Where am I？ Fragment:HomeContainerFragment
 2018-11-06 16:00:08.215 20362-20362/com.chewenkai.example I/NameTracker:         ➤ Where am I？ Fragment:UserPageVideoFragment
 2018-11-06 16:00:08.257 20362-20362/com.chewenkai.example I/NameTracker:         ➤ Where am I？ Fragment:HomeHotFeedFragment
 2018-11-06 16:00:08.375 20362-20362/com.chewenkai.example I/NameTracker:         ➤ Where am I？ Fragment:MasterplateListFragment
 2018-11-06 16:01:53.516 20362-20362/com.chewenkai.example I/NameTracker:                 ☞What did I clicked？ You are in com.chewenkai.example.presentation.module.home.provider.CardItemProvider$ViewHolderCardItemProvider.java:486 and Clicked a View：View：android.support.v7.widget.AppCompatImageView{4a2d741 VFED..C.. ...P.... 0,0-135,135 #7f090140 app:id/item_card_avatar}
 2018-11-06 16:01:53.689 20362-20362/com.chewenkai.example I/NameTracker: ➤ Where am I？ Activity:FragmentZygoteActivity
 2018-11-06 16:01:53.689 20362-20362/com.chewenkai.example I/NameTracker: ➤ Where am I？ Activity:FragmentZygoteActivity
 2018-11-06 16:01:53.695 20362-20362/com.chewenkai.example I/NameTracker:         ➤ Where am I？ Fragment:UserProfileFragment
 2018-11-06 16:01:53.891 20362-20362/com.chewenkai.example I/NameTracker:         ➤ Where am I？ Fragment:UserPageGuestVideoFragment
```

### How to add this library to your project:
1. add this dependency to root project gradle file:
``` java
dependencies {
        classpath 'com.android.tools.build:gradle:3.2.1'
        classpath 'com.hujiang.aspectjx:gradle-android-plugin-aspectjx:2.0.4'  <-- add this to Project gradle file
    }
```
2. add this code to the top of your app gradle file:
``` java

apply plugin: 'com.android.application'
apply plugin: 'android-aspectjx'  <-- add this to App gradle file (notice, add this below "apply plugin: 'com.android.application'")

```
3. add this dependency to app gradle file:
``` java
repositories {
    jcenter()
    maven { url "https://jitpack.io" }
}
dependencies {
    implementation fileTree(include: ['*.jar'], dir: 'libs')
    implementation 'com.github.chewenkai:ViewNameTracker:1.0'  <-- add this to App gradle file
    implementation 'com.android.support:support-compat:28.0.0'
}
```
