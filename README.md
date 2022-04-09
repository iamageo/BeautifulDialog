<h1 align="center">Beautiful Dialog</h1></br>
<p align="center"> 
🗨️ Beautiful Dialog is a Simple and Beautiful custom dialog.
</p>
</br>

<p align="center">
  <a href="https://opensource.org/licenses/Apache-2.0"><img alt="License" src="https://img.shields.io/badge/License-Apache%202.0-blue.svg"/></a>
  <a href="https://android-arsenal.com/api?level=21"><img alt="API" src="https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=flat"/></a>
</p>

## APK demo


## Screenshots
<p align="center">
<img src="f" width="32%"/>
<img src="f" width="32%"/>
<img src="f" width="32%"/>
</p>

## Including in your project
[![](https://jitpack.io/v/iamageo/beautiful-dialog.svg)](https://jitpack.io/#iamageo/beautiful-dialog)
### Gradle 
Add below codes to your **root** `build.gradle` file (not your module build.gradle file).
```gradle
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}
```
And add a dependency code to your **module**'s `build.gradle` file.
```gradle
dependencies {
        implementation 'com.github.iamageo:beautiful-dialog:Tag'
}
```

## Basic Usage
Add in you Activity file.

```kotlin
BeautifulDialog.build(this)
    .title("Title success", titleColor = R.color.black)
    .body("Description success",  color = R.color.black)
    .type(type= BeautifulDialog.TYPE.SUCCESS)
    .position(BeautifulDialog.POSITIONS.CENTER)
    .onPositive("Confirm") {
        Toast.makeText(this, "confirm", Toast.LENGTH_SHORT).show()
    }
    .onNegative("Cancel") {
        Toast.makeText(this, "cancel", Toast.LENGTH_SHORT).show()
    }

```


## Beautiful Dialog Attributes
Attributes | Type | Default | Description
--- | --- | --- | ---
title | String | none | Title of you dialog. 
description | String | none | Description of you dialog.
position | POSITIONS.BOTTOM, POSITIONS.CENTER, POSITIONS.TOP | POSITIONS.BOTTOM | Indicates the position of the dialog.
type | TYOE.SUCCESS, TYPE.INFO or TYPE.ERROR | none | Indicates the dialog type, each type contains an icon.

