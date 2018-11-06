[![Android Arsenal]( https://img.shields.io/badge/Android%20Arsenal-HighlightingView-green.svg?style=flat )]( https://android-arsenal.com/details/1/7294 )
[![API](https://img.shields.io/badge/API-19%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=19)
<br>
# HighlightingView
A simple layout working as a switch on-off button - Thanks to DreaminginCodeZH for Material Progress bar

<br>
<img src="https://github.com/ngallazzi/HighlightingView/blob/master/highlighted.gif" width="300" />
<br>

# Usage

in your build.gradle (Module)
```groovy
compile 'com.github.ngallazzi:HighlightingView:1.1.0'
```

in your build.gradle (Project)
```groovy
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```
in your layout file (.xml)
```groovy
	<com.ngallazzi.highlightingview.HighlightingView
        android:id="@+id/myEnlightingLayoutWithProgressTwo"
        android:layout_width="150dp"
        android:layout_height="150dp"
        android:layout_margin="20dp"
        android:layout_marginStart="8dp"
        android:layout_marginTop="8dp"
        custom:animationDurationInMillis="500"
        custom:bottomText="Download"
        custom:bottomTextColor="#ABABAB"
        custom:highlightedBackgroundColor="#4CAF50"
        custom:highlightedBottomText="Download completed"
        custom:highlightedIcon="@drawable/ic_done_black_24dp"
        custom:idleBackgroundColor="#3F51B5"
        custom:idleIcon="@drawable/ic_file_download_black_24dp"
        custom:layout_constraintStart_toStartOf="parent"
        custom:layout_constraintTop_toBottomOf="@+id/myEnlightingLayout"
        custom:middleText="image.jpg"
        custom:middleTextColor="@color/disabled" />
```
# Options
 - custom **animation duration**: "custom:animationDurationInMillis"
 - custom **bottom text**: "custom:bottomText"
 - custom **bottom text color**: "custom:bottomTextColor"
 - custom **idle status icon**: "custom:idleIcon"
 - custom **idle status background color**: "custom:highlightedBackgroundColor"
 - custom **highlighted status bottom text**: "custom:highlightedBottomText"
 - custom **highlighted status background color**: "custom:highlightedBackgroundColor"
 - custom **highlighted status icon**: "custom:highlightedIcon"
 - custom **middle text**: "custom:middleText"
 - custom **middle text color**: "custom:middleTextColor"
 
# Public Methods

 - public void **setMiddleText(String text)**
 - public void **setBottomText(String text)**
 - public void **setIcon(Drawable drawable)**
 - public void **setHighlighted(boolean isHighlighted)**
 - public boolean **isHighlighted()**
 - public void **showProgressBar()**
 - public void **hideProgressBar()**
 
 # License
```groovy 
Copyright 2017 Nicola Gallazzi

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
