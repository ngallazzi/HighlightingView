# EnlightingLayout
A simple layout working as a switch on-off button - Thanks to @DreaminginCodeZH for Material Progress bar


[![gif](https://github.com/ngallazzi/EnlightingLayout/blob/master/demo.gif)

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
<com.ngallazzi.enlightinglayout.EnlightingLayout
	android:id="@+id/myEnlightingLayoutK"
	android:layout_width="96dp"
	android:layout_height="96dp"
	custom:enlightedColor="#E91E63"
	custom:normalIcon="@drawable/your_drawable"
	custom:animationDurationInMillis="1500"
	custom:text="your_text">
</com.ngallazzi.enlightinglayout.EnlightingLayout>
```
# Options

 - custom **enlighted color**: "custom:enlightedColor"
 - custom **enlighted text color**: "custom:enlightedTextColor"
 - custom **normal status icon**: "custom:normalIcon"
 - custom **enlighted status icon**: "custom:enlightedIcon"
 - custom **animation duration**: "custom:animationDurationInMillis"
 - custom **text**: "custom:text"
 
# Public Methods

 - public void setEnlighted (Boolean status)
 - public void setText (String text)
 - public void setImage(Drawable drawable)
 - public boolean isEnlighted()
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
