# TabLayout Library

A customizable tab layout library for Android using Jetpack Compose.

## Features

- Easy-to-use animated tab layout
- Support for enum-based tabs or string-based tabs
- Customizable colors, styles, and animations
- Smooth transition animations between tabs
- Compatible with any Android project using Jetpack Compose

## Installation

### Gradle

Add the JitPack repository to your root build.gradle:

```groovy
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

Add the dependency:

```groovy
dependencies {
    implementation 'com.github.shivamsoni18:composetablayout:1.0.0'
}
```

## Usage

### Using Enum-Based Tabs

1. Create an enum class that implements the TabPage interface:

```kotlin
enum class MyTabs : TabPage {
    HOME,
    PROFILE,
    SETTINGS;

    override val tabIndex: Int
        get() = super.ordinal
}
```

2. Use the CustomTabRow in your Compose UI:

```kotlin
var selectedTab by remember { mutableStateOf(MyTabs.HOME) }

CustomTabRow(
    selectedTabPage = selectedTab,
    onTabSelected = { selectedTab = it },
    tabs = MyTabs.values().toList(),
    modifier = Modifier.fillMaxWidth()
)
```

### Using String-Based Tabs

```kotlin
val tabTitles = listOf("Home", "Profile", "Settings")
var selectedTabIndex by remember { mutableStateOf(0) }

CustomTabRowWithTitles(
    selectedTabIndex = selectedTabIndex,
    onTabSelected = { selectedTabIndex = it },
    tabTitles = tabTitles,
    modifier = Modifier.fillMaxWidth()
)
```

### Customization

You can customize the tab layout's appearance with various parameters:

```kotlin
CustomTabRowWithTitles(
    selectedTabIndex = selectedTabIndex,
    onTabSelected = { selectedTabIndex = it },
    tabTitles = tabTitles,
    backgroundColor = Color(0xFFECECEC),
    indicatorColor = Color(0xFF6200EE),
    textColor = Color(0xFF666666),
    selectedTextColor = Color.White,
    modifier = Modifier.fillMaxWidth()
)
```

## Sample App

The repository includes a sample app that demonstrates how to use the library.

![Screenshot_20250510_031958_resized](https://github.com/user-attachments/assets/70a3ba1f-a0d7-4af5-a178-41bd64554319)



## License

```
Copyright 2023 SSS

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
``` 
