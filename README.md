<h1 align="center">
SmartNest 
</h1>

<p align="center">
  <img src="https://img.shields.io/badge/-Kotlin-7c6fe1?style=flat&logo=kotlin&logoColor=white">
  <img alt="API" src="https://img.shields.io/badge/API-24%2B-orange.svg?style=flat"/>
</p>

SmartNest is an Android application designed to provide a smart home management experience. Users can control various aspects of their home environment, such as lighting, temperature, and security, all from a single interface.

## Table of Contents

- [Features](#features)
- [Open Source Libraries](#open-source-libraries)
- [WebSocket Integration](#websocket-integration)
- [Commit Practices](#commit-practices)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
- [Usage](#usage)
- [Contributing](#contributing)
- [Contact](#contact)
- [License](#license)

## Features

- **Smart Lighting Control**: Manage and control smart lights in your home.
- **Navigation**: Easy navigation between different sections of the app using a drawer layout.
- **Material Design**: A clean and modern user interface built with Material Design components.
- **View Binding**: Efficiently bind UI components to data sources.

## Open Source Libraries

This project utilizes the following open source libraries:

- [Kotlin](https://kotlinlang.org/) - A modern programming language for Android development.
- [AndroidX](https://developer.android.com/jetpack/androidx) - A set of libraries to help with Android development.
- [Dagger Hilt](https://dagger.dev/hilt/) - A dependency injection library for Android.
- [Coroutines](https://developer.android.com/kotlin/coroutines?hl=tr) - Provides a simple way to manage background threads, making asynchronous programming easier and more efficient.
* [Flow](https://developer.android.com/kotlin/flow) - A reactive streams API in Kotlin used for managing data streams asynchronously.
- [Material Components](https://material.io/develop/android) - A library for implementing Material Design in Android apps.
* [MVVM](https://developer.android.com/topic/libraries/architecture/viewmodel#implement) - A design pattern used to separate concerns, making the application more modular, testable, and maintainable.
  * [Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle) - Manages Android lifecycle-aware components.
  * [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Stores UI-related data that isn't destroyed on UI changes.
  * [UseCases](https://developer.android.com/topic/architecture/domain-layer) - Located domain layer that sits between the UI layer and the data layer.
  * [Repository](https://developer.android.com/topic/architecture/data-layer) - Located in the data layer that contains application data and business logic.
- [OkHttp](https://square.github.io/okhttp/) - An HTTP client for Android and Java applications.
- [Gson](https://github.com/google/gson) - A library for converting Java objects to JSON and vice versa.

## WebSocket Integration

SmartNest uses WebSockets to enable real-time communication between the app and the server. This allows for instant updates and notifications, enhancing the user experience. Key features of the WebSocket integration include:

- **Real-Time Updates**: Users receive immediate updates on their smart devices' status.
- **Efficient Communication**: WebSockets provide a persistent connection, reducing the overhead of establishing new connections for each request.
- **Event-Driven Architecture**: The app can respond to events from the server in real-time, improving responsiveness.

### How to Use WebSockets

1. Ensure that the WebSocket server is running and accessible.
2. Connect to the WebSocket server using the provided URL in the app.
3. Listen for messages and handle them appropriately in your application logic.

## Commit Practices

This project follows atomic commit practices and uses semantic commit messages. 

- **Atomic Commits**: Each commit should represent a single logical change. This makes it easier to understand the history of changes and to revert specific changes if necessary.
  
- **Semantic Commit Messages**: Commit messages should follow the format:
  - `type(scope): subject`
  - Examples of types include:
    - `feat`: A new feature
    - `fix`: A bug fix
    - `docs`: Documentation changes
    - `style`: Changes that do not affect the meaning of the code (white-space, formatting, etc.)
    - `refactor`: A code change that neither fixes a bug nor adds a feature
    - `test`: Adding missing tests or correcting existing tests
    - `chore`: Changes to the build process or auxiliary tools and libraries

This practice helps maintain a clear and organized commit history, making it easier for contributors to understand the project's evolution.

## Getting Started

### Prerequisites

- Android Studio
- Kotlin 2.1.0 or higher
- Android SDK 24 or higher

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/bengisusaahin/SmartNest.git
   ```

2. Open the project in Android Studio.

3. Sync the project with Gradle files.

4. Run the application on an emulator or a physical device.

## Usage

- Launch the app and log in with your credentials.
- Control your smart devices from the dashboard.

## Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository.
2. Create a new branch (`git checkout -b feature/YourFeature`).
3. Make your changes and commit them (`git commit -m 'Add some feature'`).
4. Push to the branch (`git push origin feature/YourFeature`).
5. Open a pull request.

## Contact

<table style="border-collapse: collapse; width: 100%;">
  <tr>
    <td style="padding-right: 10px;">Bengisu Şahin - <a href="mailto:bengisusaahin@gmail.com">bengisusaahin@gmail.com</a></td>
    <td>
      <a href="https://www.linkedin.com/in/bengisu-sahin/" target="_blank">
        <img src="https://img.shields.io/badge/linkedin-%231E77B5.svg?&style=for-the-badge&logo=linkedin&logoColor=white" alt="linkedin" style="vertical-align: middle;" />
      </a>
    </td>
  </tr>
</table>

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
