# EnlightingLayout
A simple layout working as a switch on-off button

[![gif](https://github.com/ngallazzi/EnlightingLayout/blob/master/demo.gif)

#Usage

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
in your layout file
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