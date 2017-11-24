# EnlightingLayout
A simple layout working as a switch on-off button - Thanks to DreaminginCodeZH for Material Progress bar

![Demo video](https://github.com/ngallazzi/HighlightingView/blob/master/demo.mp4)
<br>
<br>
![](https://github.com/ngallazzi/HighlightingView/blob/master/Screenshot_20171124-173501.png)
![](https://github.com/ngallazzi/HighlightingView/blob/master/Screenshot_20171124-173505.png)
<br>
![](https://github.com/ngallazzi/HighlightingView/blob/master/Screenshot_20171124-173508.png)

# Usage

in your build.gradle (Module)
```groovy
compile 'me.ngallazzi.android.enlightinglayout:enlightinglayout:1.0.0'
```

in your build.gradle (Project)
```groovy
allprojects {
    repositories {
        jcenter()
        maven {
            url  "http://dl.bintray.com/ngallazzi/maven"
        }
    }
}
```
in your layout file (.xml)
```groovy
<com.ngallazzi.highlightingview.HighlightingView
	android:id="@+id/myEnlightingLayoutK"
	android:layout_width="150dp"
	android:layout_height="150dp"
	android:layout_margin="20dp"
	custom:idleBackgroundColor="#FFFFFF"
	custom:enlightedBackgroundColor="#4CAF50"
	custom:middleText="Computer"
	custom:middleTextColor="#F44336"
	custom:icon="@drawable/ic_computer_black_24dp"
	custom:animationDurationInMillis="200"
	custom:bottomText="Off"
	custom:bottomTextColor="#A3000000">
</com.ngallazzi.highlightingview.HighlightingView>
```
# Options

 - custom **idle status background color**: "custom:enlightedBackgroundColor"
 - custom **highlighted status text color**: "custom:enlightedTextColor"
 - custom **middle text*: "custom:middleText"
 - custom **middle text color*: "custom:middleTextColor"
 - custom **icon**: "custom:icon"
 - custom **animation duration**: "custom:animationDurationInMillis"
 - custom **bottom text**: "custom:bottomText"
 - custom **bottom text color**: "custom:bottomTextColor"
 
# Public Methods

 - public void setMiddleText (String text)
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
