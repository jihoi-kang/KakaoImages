# Kakao Images
Displays an endless list of grid images.

## Screen shots
<p align="center">
<img src="/preview/preview_01.png" width="33%"/>
<img src="/preview/preview_02.png" width="33%"/>
<img src="/preview/preview_03.png" width="33%"/>
</p>

## How to set rest api key
Get your [API key](https://developers.kakao.com/docs/latest/ko/daum-search/common) and add your rest api key in your `local.properties` file.
```xml
rest_api_key=YOUR_API_KEY
```

## Tech stack used
- [Kotlin](https://kotlinlang.org/) language
- JetPack
  - [AAC ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)
  - [LiveData](https://developer.android.com/topic/libraries/architecture/livedata)
  - [LifeCycle](https://developer.android.com/topic/libraries/architecture/lifecycle)
- Architecture
  - MVVM architecture(View - DataBinding - ViewModel - Model)
  - Repository pattern
- [Dagger2](https://dagger.dev/)
- [RxJava2](https://github.com/ReactiveX/RxJava)
- [Retrofit](https://github.com/square/retrofit)
- [Gson](https://github.com/google/gson)
- [Glide](https://github.com/bumptech/glide)
