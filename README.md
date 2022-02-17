# ViewPager2ForSupport

As we know, there still are so many legacy projects using support library so far. ViewPager2 contains
many useful features, which is better than ViewPager. However, unfortunately, it is exclusively
for androidx, and support can't use it. In order to use it on legacy support project, I migrate
androidx.viewpager2:viewpager2:1.0.0 to support version. So you can use it in your support project.

### Usage:

#### Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:
```groovy
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

#### Step 2. Add the dependency

```groovy
	dependencies {
        implementation 'com.github.VinsonGuo:ViewPager2ForSupport:1.0.0'
	}
```

#### Step 3. Use it

```xml
<com.vinsonguo.viewpager2.widget.ViewPager2
        android:id="@+id/viewPager2"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />
```