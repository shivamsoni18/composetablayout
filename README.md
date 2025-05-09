# ComposeTabLayout

[![Release](https://jitpack.io/v/shivamsoni18/composetablayout.svg)](https://jitpack.io/#shivamsoni18/composetablayout)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

A modern, customizable tab layout library for Android built with Jetpack Compose. This library provides an easy way to implement beautiful animated tabs in your Compose UI with minimal code.

<p align="center">
  <img src="https://github.com/user-attachments/assets/70a3ba1f-a0d7-4af5-a178-41bd64554319" width="300" alt="ComposeTabLayout Demo">
</p>

## Features

- ✨ Easy-to-use animated tab layout
- 🔄 Support for both enum-based tabs and string-based tabs
- 🎨 Highly customizable colors, styles, and animations
- 🚀 Smooth transition animations between tabs
- 📱 Compatible with any Android project using Jetpack Compose
- 🧩 Lightweight and modular design

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

Or in settings.gradle for newer projects:

```groovy
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url 'https://jitpack.io' }
    }
}
```

Add the dependency to your module's build.gradle:

```groovy
dependencies {
    implementation 'com.github.shivamsoni18:composetablayout:1.0.1'
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

For simple cases where you just need string tabs:

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
    backgroundColor = Color(0xFFECECEC),          // Background color of tab row
    indicatorColor = Color(0xFF6200EE),           // Color of the selected tab indicator
    textColor = Color(0xFF666666),                // Color of unselected tab text
    selectedTextColor = Color.White,              // Color of selected tab text
    tabCornerShape = RoundedCornerShape(20.dp),   // Corner shape for the tab row
    indicatorCornerShape = RoundedCornerShape(4.dp), // Corner shape for the indicator
    segmentedStyle = false,                       // Whether to use segmented control style
    modifier = Modifier.fillMaxWidth()
)
```

## Sample App

The repository includes a sample app that demonstrates how to use the library with both enum-based tabs and string-based tabs. Run the sample app to see the tabs in action.

## Requirements

- Minimum SDK version: 21 (Android 5.0)
- Jetpack Compose compatible project

## Contributing

Contributions are welcome! If you'd like to contribute, please feel free to submit a pull request.

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
