# Plugin Template

Template for new RADAR pRMT plugins

## Installation

First, add the plugin code to your application:

```gradle
repositories {
    maven { url  'https://dl.bintray.com/radar-cns/org.radarcns' }
    maven { url  'https://repo.thehyve.nl/content/repositories/releases' }
}

dependencies {
    runtimeOnly 'org.radarcns:radar-android-xxx:0.1.0'
}
```

## Configuration

TBD

## Contributing

Code should be formatted using the [Google Java Code Style Guide](https://google.github.io/styleguide/javaguide.html), except using 4 spaces as indentation. Make a pull request once the code is working.
