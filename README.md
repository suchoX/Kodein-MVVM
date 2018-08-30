Kodein-MVVM
======

This is a simple sample Android app written in **Kotlin**, to showcase how to use **Kodein** dependency injection in your app. It uses **MVVM Architecture**, **Architecture Components** and **Kodein** to provide a robust base to the app. The **Retrofit** library is used to fetch jokes along with the **RxJava 2** and **RxAndroid 2** which handles connections asynchronously and makes the app more reliable.  

Dependency Injection has been layered into 3 separate Modules for better structure: AppModule, ActivityModule and FragmentModule

SupportFragment has been used to support Architecture Component ViewModel. (Fragment has also been deprecated since Android P)

Kodein is a viable replacement over Dagger 2 which is less complex and easier to setup (But requires more Boilerplate and needs Context for injection). Personally I feel, Kodein is suitable for smaller projects

**Setup**
	
- [Kodein](https://github.com/Kodein-Framework/Kodein-DI) for Dependency Injection 
- MVVM pattern using Architecture Components
- [Retrofit](https://github.com/square/retrofit), [RxJava 2, RxAndroid 2](https://github.com/ReactiveX/RxJava) for API calls

This app can be used as a base template for yor Android Apps and can be used as a template for your apps. 
