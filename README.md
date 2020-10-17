# VideoStreamer 

An Open source android app to stream Videos powered by.

![](https://theme.zdassets.com/theme_assets/25476/12654f8b32c6637f780caf6bd6855e81531d13b0.png "DAILYMOTION")

Introduction:
=====

I have built videoStreamer as my practice project and it is the place where, I try new things and experiment my learnings.
Currently I have integrated network requests, local databases and Material design in it, still need to write test cases in it.

I have practiced **Kotlin**, **Coroutines**, **Jetpack** and **androidx** also tried to follow **Solid and Dry** principles.

Screenshots: 
======
<p>
  <img src="https://i.imgur.com/Froxney.jpg" width="250" style="margin:2px"/>
</p>

Structure: 
=======

### [Kotlin](https://kotlinlang.org/):
I have used kotlin over java because it have shorter porgrams for the same task, easy to code. It have compatibility with java and it eliminates null references :heart:.

### [JetPack Architecture Components](https://developer.android.com/jetpack) - & AndroidX:
<br>**Room** - Database Layer.
<br>**ViewModel** - Data Preservation across configuration changes.
<br>**Paging 3.0** - Pagination using latest jetpack component.
<br>**Lifecycle** - Handling annoying issues with Activities / Fragments namely when pushing data during false states.
<br>**Navigation** - Easy Fragment Transactions.
<br>**Data Binding** - Binds view with data.
<br>**AndroidX, Material Components** - For Material Design.

### [Koin](https://insert-koin.io/) - Dependency Injection:
Kotlin has a powerful feature, reified that enables Kotlin to be able to process generic type in its concrete form during runtime.
I have used KOIN as it takes advantage of this feature, enables one to link up all its dependencies.

### [GSON](https://github.com/google/gson) + [Retrofit](https://square.github.io/retrofit/) - Networking:
I have used custom convertor to get the result in the JsonObject we can also put that as generic type.

### Multi Modular:
I have seperated project with multiple modules, it have core and data modules as base module and seperate feature module for faster build and dynamic delivery.

### Other
- [Kotlin Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html)






