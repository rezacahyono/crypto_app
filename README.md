# LEARN CLEAN ARCHITECTURE SAMPLE
___

## Apa itu clean architecture ?
___
Clean architecture adalah salah satu referensi arsitekture yang ditawarkan oleh Robert C.Martin(uncle bob).
Pada dalam bukunya _uncle bob_ yang berjudl __Clean Code__ arsitektur ini lebih menekankan prinsip _*SOLID PRINCIPLE*_, terutama _Single Responbility Principle_.


![image](https://cdn-images-1.medium.com/max/1200/1*B7LkQDyDqLN3rRSrNYkETA.jpeg)
## Alur clean architecture
___
![image](https://rubygarage.s3.amazonaws.com/uploads/article_image/file/2060/Artboard_15587.png)
### 1. Entitas
Bisnis logic seluruh aplikasi yang merangkum bisnis logic umum dan berisi _data transfer object_ (**DTO**)
ketika suatu eksternal berubah maka entitas paling kecil kemungkinannya untuk berubah.
### 2. Use Case
Bisa disebut juga interactor yang berfungsi untuk mengambil atau mengirim data ke **API** dan mengelola data sesuai kasus.
Ini mempermudahkan membuat _Mocking Request_ ke api untuk keperluan _Unit Test_.
### 3. Data
Layer ini berfungsi untuk sebagi tempat mendefinisikan variasi _Data Model_ yang akan digunakan.
Layer ini bisa menjadi tempat menyimpan dan merequest data dari **API** maupun **LOCAL**.
### 4. Presentation
Layer ini menjadi tempat mengelompokan class yang berfunsgi sebagai interaksi dengan _**UI**_.
Biasanya berisi android UI (_Activity, Fragment, Views_), ViewModel dan tergantung pattern apa kalian pilih 
seperti 
* **MVP** (Model-View-Presenter)
* **MVC** (Model-View-Controller)
* **MVVM** (Model-View-ViewModel)

### Library yang di pakai
___
* [Kotlin](https://kotlinlang.org/) Bahasa pemograman untuk pengembangan android.
* [Dagger-Hil](https://dagger.dev/hilt/) Dependency injection.
* [Coroutine](https://developer.android.com/kotlin/coroutines) Untuk Background Task secara Asynchronous.
* [Lifecycle](https://developer.android.com/jetpack/androidx/releases/lifecycle) Komponen untuk merespon perubahan data ke UI.
* [Retrofit](https://square.github.io/retrofit/) Library untuk memanggil data Api.
* [Coinpaprike](https://coinpaprika.com/) Api crypto currency

### Struktur Project
___
```bash
─com
    └───rcyono
        └───cryptoapp
            ├───common
            ├───data
            │   ├───remote
            │   │   ├───api
            │   │   └───dto
            │   │       ├───coin
            │   │       └───tickers
            │   └───repository
            ├───di
            ├───domain
            │   ├───model
            │   ├───navigation
            │   │   └───destinantion
            │   ├───repository
            │   └───usecase
            │       ├───getcoin
            │       └───getcoindetail
            └───presentation
                ├───coindetail
                │   └───components
                ├───coinlist
                │   └───components
                ├───splash
                └───ui
                    └───theme
```
