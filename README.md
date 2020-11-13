# afrikaburn
[AfrikaBurn](https://www.afrikaburn.com/) is a community of participants who come together to create art, burning structures, costume, performance, theme camps, music, mutant vehicles and much, much more.
All of this is created through the volunteer culture of the citizens of Tankwa Town in the Karoo once a year. It is roughly based on the [Burning Man](https://burningman.org/) event in the USA.

It kinda looks like this:
![Image of AfrikaBurn](https://instagram.fcpt7-1.fna.fbcdn.net/v/t51.2885-15/sh0.08/e35/s640x640/71043349_189528182068380_4301480977726295338_n.jpg?_nc_ht=instagram.fcpt7-1.fna.fbcdn.net&_nc_cat=100&_nc_ohc=bouuwIqBTTYAX_xpejG&oh=6c99fafbdbef221ac2c512cb404040db&oe=5F620B65)

Get it from the [![Google Play Store](https://img.shields.io/badge/appStore-blue?style=plastic&logo=google-play)](https://play.google.com/store/apps/details?id=asterixorobelix.afrikaburn)!

## Kotlin
Kotlin is Google's preferred programming language for Android Developers.
Furthermore, Google have taken a "Kotlin first" approach whereby features will be released for Kotlin prior to release for Java.

## Architecture

The [Google Recommended App Architecture](https://developer.android.com/jetpack/docs/guide) is followed. Broadly speaking, this mandates a MVVM (Model, View, ViewModel) and single Activity architecture.

![Architecture Diagram](https://developer.android.com/topic/libraries/architecture/images/final-architecture.png)

Furthermore, [Android Jetpack](https://developer.android.com/jetpack) components were used whenever feasible. The Jetpack libraries will help by placing the Android OS fragmentation burden largely upon Google. 
Additionally, the Jetpack libraries facilitate adherance to the Architectural practices described in this document.

The modular programming software design technique is utilized within this app. Modular programming emphasizes separating the functionality of a program into independent modules.
Each module then contains everything necessary to execute only one aspect of the desired functionality. These libraries would provide the required functionality in an independent and encapsulated, loosely coupled manner.

The Afrikaburn app can therefore be viewed as a collection of modules delivering the required functionality.

## Consequences

A number of advantages of the architecture outlined above have been identified, including:

* Reduced build times. This is due to changes requiring module rebuilds, rather than app rebuilds.
* Enforced separation of concerns due to a module encapsulating a limited set of functionality.
* Adoption of an API orientated mindset
* Improved ability to write Unit Tests due to limited object scope
* Code reuse by means of libraries which can be used by multiple other libraries.
* Enhanced scope for refactoring due to library module code base being smaller than application code base.

The following disadvantages with the proposed approach are noted:

* Dependency management - each library module will have a unique Gradle file declaring dependencies.
These Gradle files will have to be kept in sync on a continual basis.
* Versioning of library modules must be carefully managed and documented, since the library modules will be developed separately.
Compatibility of these different library module versions in client apps would need to be carefully managed.
* The transfer of information and navigation between library modules introduces more developer friction than in a monolithic application.
* Increased QE load due to testing of the interaction between library modules.

Risks associated with this approach:

* Library modules may need to be split into further sub-modules at a later stage, which could entail extensive refactoring.
* Both Kotlin and the Jetpack libraries are production ready, however they are a recent addition to the Android ecosystem.
As a result, both the developer and the Android development community at large relatively unfamiliar with aforementioned technologies.

## Offline map
The map tiles are downloaded on first launch for offline capability, thanks to [Mapbox](https://docs.mapbox.com/android/maps/overview/offline/)

## API keys
You will need to provide the following or contact me:
* API keys have been [hidden from source control](https://medium.com/code-better/hiding-api-keys-from-your-android-repository-b23f5598b906)
* [Get your Mapbox API key](https://www.mapbox.com/)
* google-services.json
* [Jitpack](https://jitpack.io/)

## Offline capable
Offline capability is provided by [Firebase](https://firebase.google.com/docs/firestore)

### Android Analytics

## Privacy Policy
[Policy](https://asterixorobelix.github.io/privacy_policy.html) generated with [this awesome privacy policy generator](https://app-privacy-policy-generator.firebaseapp.com/#)

## Building
You will need to provide a google-services.json file and a [mapbox API key](https://docs.mapbox.com/android/maps/overview/) in your Global gradle.properties

## AndroidX/Jetpack Libraries
* [Navigation Graphs](https://developer.android.com/jetpack/androidx/releases/navigation)
* [Navigation](https://developer.android.com/topic/libraries/architecture/navigation.html)
* [Material Design](https://material.io/develop/android/docs/getting-started/)
* [ViewPager2](https://developer.android.com/jetpack/androidx/releases/viewpager2)
* [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)
* [Data Binding](https://developer.android.com/topic/libraries/data-binding)
* [LiveData](https://developer.android.com/topic/libraries/architecture/livedata)
* [Room database](https://developer.android.com/training/data-storage/room/)
* [Pagination](https://developer.android.com/topic/libraries/architecture/paging/)

## 3rd Party Libraries
* I tried [Dagger Hilt](https://developer.android.com/training/dependency-injection/hilt-android), many components are beta currently and I would recommend switching to [Koin](https://github.com/InsertKoinIO/koin). It is a service locator, but extremely easy and intuitive to setup.
* [LeakCanary](https://square.github.io/leakcanary/getting_started/) - identifying memory leaks
* [Gson](https://github.com/google/gson) - deserialization
* [Shimmer](https://facebook.github.io/shimmer-android/) - loading indication
* [Lottie Android Docs](http://airbnb.io/lottie/android/android.html#sample-app), which animates [Lottie files](https://www.lottiefiles.com/)
* [Mapbox](https://docs.mapbox.com/android/maps/overview/) - offline map functionality
* [Firebase Firestore](https://firebase.google.com/docs/firestore)

## Inspiration
* [Google IO Schedule app](https://github.com/google/iosched)
* [Android Showcase app](https://github.com/igorwojda/android-showcase)
* [Material design demo](https://github.com/Eajy/MaterialDesignDemo)
* [Plaid](https://github.com/android/plaid)
* [Lego app](https://github.com/Eli-Fox/LEGO-Catalog?source=post_page-----7749b2bae5f7----------------------)
* [Sunflower app](https://github.com/android/sunflower)
* [Material example app](https://github.com/material-components/material-components-android)

## Icons
* [Noun project](https://thenounproject.com/search/?q=question&i=670406)
* [Material icons](https://material.io/resources/icons/?style=baseline)
