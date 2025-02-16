<h1 align="center">Beautiful Dialog</h1><br/>
<p align="center"> 
🗨️ Beautiful Dialog is a Simple and Beautiful custom dialog.
</p>
<br/>

<p align="center">
  <a href="https://opensource.org/licenses/Apache-2.0"><img alt="License" src="https://img.shields.io/badge/License-Apache%202.0-blue.svg"/></a>
  <a href="https://android-arsenal.com/api?level=21"><img alt="API" src="https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=flat"/></a>
  <img alt="repo size" src="https://img.shields.io/github/repo-size/iamageo/beautiful-dialog"/>
  <br/>
    <img alt="forks" src="https://img.shields.io/github/forks/iamageo/beautiful-dialog?style=social"/>
    <img alt="stars" src="https://img.shields.io/github/stars/iamageo/beautiful-dialog?style=social"/>
</p>

[![Android CI](https://github.com/iamageo/BeautifulDialog/actions/workflows/android.yml/badge.svg)](https://github.com/iamageo/BeautifulDialog/actions/workflows/android.yml)
[![Android Unit Test](https://github.com/iamageo/BeautifulDialog/actions/workflows/android_unit_test.yml/badge.svg)](https://github.com/iamageo/BeautifulDialog/actions/workflows/android_unit_test.yml)

## Demonstration
<p align="center">
    <img src="https://github.com/iamageo/BeautifulDialog/assets/26925002/0a45b075-b1f1-48ea-9618-95157146305e" width="20%"/>
    <img src="https://github.com/iamageo/BeautifulDialog/assets/26925002/48eab16c-1e7d-4a72-81f8-7f2db87fd65f" width="20%"/>
    <img src="https://github.com/iamageo/BeautifulDialog/assets/26925002/422e8da6-9601-4f9e-bd49-e6e0d9d8a5b0" width="20%"/>
    <img src="https://github.com/iamageo/BeautifulDialog/assets/26925002/fdf2d920-0d91-422e-92fc-398036f5c3ab" width="20%"/>
</p>

## Star history 🌟
[![Star History Chart](https://api.star-history.com/svg?repos=iamageo/BeautifulDialog&type=Timeline)](https://star-history.com/#iamageo/BeautifulDialog&Timeline)

## Including in your project
[![](https://jitpack.io/v/iamageo/BeautifulDialog.svg)](https://jitpack.io/#iamageo/BeautifulDialog)

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
For Ktx
```gradle
allprojects {
  repositories {
    ...
     maven { url = uri("https://www.jitpack.io" ) }
  }
}
```


And add a dependency code to your **module**'s `build.gradle` file.
```gradle
dependencies {
        implementation 'com.github.iamageo:beautiful-dialog:1.0.8'
}
```

## Basic Usage
Add in you Activity file.

```kotlin
BeautifulDialog.build(this)
    .title("Title success", titleColor = R.color.black)
    .description("Description success",  color = R.color.black)
    .type(type= BeautifulDialog.TYPE.SUCCESS)
    .position(BeautifulDialog.POSITIONS.CENTER)
    .onPositive(text = "Confirm", shouldIDismissOnClick = false) {
        Toast.makeText(this, "confirm", Toast.LENGTH_SHORT).show()
    }
    .onNegative(text = "Cancel") {
        Toast.makeText(this, "cancel", Toast.LENGTH_SHORT).show()
    }
```

## How to hide Negative Button
just call in build:
```kotlin
.hideNegativeButton(hide = true)
```
## How to change animation 📌
📌 Note: your icon can be of type iconRes (Int)

if you call .dialogAnimation() don't call .type()
```kotlin
.dialogAnimation(iconRes)
```

## how not to cancel dialog on click ❌
just call property shouldIDismissOnClick in onPositive or onNegative:
```kotlin
.onPositive(text = "Confirm", shouldIDismissOnClick = false) {
        Toast.makeText(this, "click in positive button", Toast.LENGTH_SHORT).show()
}
```

## Type ✔️ ℹ️ ⚠ ❌
We can customize the type of Dialog.
```kotlin
TYPE.SUCCESS
TYPE.INFO
TYPE.ALERT
TYPE.ERROR
TYPE.NONE
```

|SUCCESS|INFO| ALERT |ERROR|NONE|
|:---------------------------------------------------------------------------------------------------------------------------------------------:|:---------------------------------------------------------------------------------------------------------------------------------------------:|:---------------------------------------------------------------------------------------------------------------------------------------------:|:---------------------------------------------------------------------------------------------------------------------------------------------:| :---------------------------------------------------------------------------------------------------------------------------------------------:| 
| <img src="https://github.com/iamageo/BeautifulDialog/assets/26925002/b9354c50-fb29-44a9-af2c-0693b6e1c9ff" align="center" width="100%"/> | <img src="https://github.com/iamageo/BeautifulDialog/assets/26925002/0babdd7c-b4e8-4bdd-850a-dc0c8c512b63" align="center" width="100%"/> |     <img src="https://github.com/iamageo/BeautifulDialog/assets/26925002/60638801-e226-4f92-987f-6daa086efe85" align="center" width="100%"/>   | <img src="https://github.com/iamageo/BeautifulDialog/assets/26925002/04513979-e505-4acd-8c36-4917302d4b59" align="center" width="100%"/> | <img src="https://github.com/iamageo/BeautifulDialog/assets/26925002/fd56d62d-ff54-45e5-8f2c-f3d91ea0c138" align="center" width="100%"/> |

## Positioning 📱
We can customize the Position of Dialog.
```kotlin
POSITIONS.TOP
POSITIONS.CENTER
POSITIONS.BOTTOM
```
By default, the Position is **CENTER**.

|                                                                    TOP                                                                     |                                                                   CENTER                                                                      |                                                                    BOTTOM   
|:---------------------------------------------------------------------------------------------------------------------------------------------:|:---------------------------------------------------------------------------------------------------------------------------------------------:| :---------------------------------------------------------------------------------------------------------------------------------------------:| 
| <img src="https://github.com/iamageo/BeautifulDialog/assets/26925002/8811dcf0-a1de-42b8-9774-914a7874bfb1" align="center" width="50%"/> | <img src="https://github.com/iamageo/BeautifulDialog/assets/26925002/95aaad55-76a2-4f63-b7dd-c046b230f5c1" align="center" width="50%"/> | <img src="https://github.com/iamageo/BeautifulDialog/assets/26925002/3b2b21f2-a62d-44df-9e65-503e022fe5d7" align="center" width="50%"/> |

## Hacktoberfest 2022
This project has been submitted for hacktoberfest 2022. [See more here](https://hacktoberfest.com/)

## Beautiful Dialog Attributes
| Attributes            | Type                                                         | Default          | Description                                                 |
|-----------------------|--------------------------------------------------------------|------------------|-------------------------------------------------------------|
| title                 | String                                                       | none             | Title of you dialog.                                        |
| description           | String                                                       | none             | Description of you dialog.                                  |
| position              | POSITIONS.BOTTOM, POSITIONS.CENTER                           | POSITIONS.BOTTOM | Indicates the position of the dialog.                       |
| type                  | TYPE.SUCCESS, TYPE.INFO, TYPE.ALERT, TYPE.ERROR or TYPE.NONE | success          | Indicates the dialog type, each type contains an icon.      |
| onPositive            | onClick                                                      | none             | Button positive click.                                      |
| onNegative            | onClick                                                      | none             | Button negative click.                                      |
| hideNegativeButton    | Boolean                                                      | false            | hide negative button.                                       |
| cancelable            | Boolean                                                      | false            | set if Beautiful is cancelable on click in screen ❌.        |
| shouldIDismissOnClick | boolean                                                      | true             | set if dialog dismiss on click in onPositive or onNegative. |
| dialogIcon            | Int, drawable                                                | none             | set dialog icon.                                            |

## Attributes of Positive and Negative Buttons
| Attributes            | Type     | Default | Description                   |
|-----------------------|----------|---------|-------------------------------|
| text                  | String   | none    | Text of button                |
| fontStyle             | typeface | default | Fontstyle of button           |
| buttonBackroundColor  | Int      | black   | Backround resource of button  |
| textColor             | Int      | gray    | Text color of button          |
| shouldIDismissOnClick | Boolean  | none    | Cancel dialog onclick if true |
| action                | Unit     | none    | what to do                    |

## Attributes of Title And Description
| Attributes | Type     | Default | Description      |
|------------|----------|---------|------------------|
| text       | String   | none    | Text             |
| fontStyle  | typeface | default | Fontstyle        |
| fontSize   | Int      | 14      | Change font size |
| color      | Int      | gray    | Text Color       |

## License
```
    Copyright 2022 Geovani Amaral

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

