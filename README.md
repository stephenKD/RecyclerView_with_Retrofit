# RecyclerView_with_Retrofit
Kotlin practice, call Restful API with Retrofit, and update RecyclerView.  

<img src="https://github.com/stephenKD/SampleRecycleView/blob/master/app/src/main/res/drawable/sample_pic.png?raw=true" width=20% height=20%/>

## Step 1
Add permission in "AndroidManifest.xml".
```
<uses-permission android:name="android.permission.INTERNET"/>
```

## Step 2
Add libs in "build.gradle".
```
buildFeatures{
    viewBinding true
}

//Retrofit2
implementation 'com.squareup.retrofit2:retrofit:2.9.0'
implementation 'com.squareup.retrofit2:converter-gson:2.4.0'
implementation 'com.squareup.okhttp3:okhttp:4.9.0'
implementation 'com.squareup.okhttp3:logging-interceptor:4.9.0'

//Coil
implementation("io.coil-kt:coil:1.3.2")
```

## Step 3
Add plugin "JSON To Kotlin Class" in Android Studio.   
Select Android Studio > Perfeneces... > Plugins > Marketplace  
Key "JSON To Kotlin Class" in search table, then install it.

## Step 4
Start practice.

# Open API
Sample API from "臺北旅遊網Open API - 台北"
[臺北旅遊網Open API - 台北](https://www.travel.taipei/open-api/swagger/ui/index)
