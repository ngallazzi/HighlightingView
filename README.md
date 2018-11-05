# HighlightingView
A simple layout working as a switch on-off button - Thanks to DreaminginCodeZH for Material Progress bar

<br>
![](https://github.com/ngallazzi/HighlightingView/blob/master/highlighted.gif)
<br>

# Usage

in your build.gradle (Module)
```groovy
compile 'com.github.ngallazzi:HighlightingView:1.0.2'
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
		android:id="@+id/myEnlightingLayout"
		android:layout_width="150dp"
		android:layout_height="150dp"
		android:layout_margin="20dp"
		custom:idleBackgroundColor="#FFFFFF"
		custom:highlightedBackgroundColor="#4CAF50"
		custom:middleText="Computer"
		custom:middleTextColor="#F44336"
		custom:icon="@drawable/ic_bluetooth_connected"
		custom:animationDurationInMillis="200"
		custom:bottomText="Off"
		custom:bottomTextColor="#A3000000"
		custom:highlightedBottomText="On">
	</com.ngallazzi.highlightingview.HighlightingView>
```
# Options

 - custom **idle status background color**: "custom:highlightedBackgroundColor"
 - custom **highlighted status background color**: "custom:highlightedBackgroundColor"
 - custom **middle text*: "custom:middleText"
 - custom **middle text color*: "custom:middleTextColor"
 - custom **icon**: "custom:icon"
 - custom **animation duration**: "custom:animationDurationInMillis"
 - custom **bottom text**: "custom:bottomText"
 - custom **bottom text color**: "custom:bottomTextColor"
 - custom **highlighted status bottom text**: "custom:highlightedBottomText"
 
# Public Methods

 - public void setMiddleText(String text)
 - public void setBottomText(String text)
 - public void setIcon(Drawable drawable)
 - public void setHighlighted(boolean isHighlighted)
 - public boolean isHighlighted()
 - public void showProgressBar()
 - public void hideProgressBar()
 
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
