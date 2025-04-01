# Maven in AEM

## Maven Lifecycle
Maven follows a lifecycle consisting of several phases:
- **validate** – Validates the project structure and necessary configuration.
- **compile** – Compiles the source code.
- **test** – Runs unit tests.
- **package** – Packages compiled code into JAR/WAR.
- **verify** – Verifies the package.
- **install** – Installs the package into the local repository.
- **deploy** – Deploys the built package to a remote repository.

## What is `pom.xml` and Why Do We Use It?
The `pom.xml` (Project Object Model) file is the configuration file for a Maven project. It contains project metadata, dependencies, plugins, build settings, and profiles. It helps in managing the build process efficiently.

## How Dependencies Work?
Maven uses dependencies to include external libraries in the project. Dependencies are declared in the `pom.xml` file. When Maven builds the project, it fetches the required libraries from the Maven repository and adds them to the project.

Example:
```xml
<dependencies>
    <dependency>
        <groupId>org.apache.sling</groupId>
        <artifactId>org.apache.sling.api</artifactId>
        <version>2.20.0</version>
    </dependency>
</dependencies>
```

## Checking the Maven Repository
Maven repositories store dependencies and artifacts. You can check:
- **Local Repository:** Stored in `~/.m2/repository` on your system.
- **Central Repository:** Available at [Maven Central](https://repo.maven.apache.org/maven2/).
- **Remote Repositories:** Configured in `pom.xml` for fetching dependencies.

## How Are All Modules Built Using Maven?
Maven follows a modular approach in AEM projects. The `all` module aggregates all other modules (`core`, `ui.apps`, `ui.content`, etc.) and builds them together.

To build all modules:
```sh
mvn clean install
```

## Can We Build a Specific Module?
Yes, you can build a specific module by navigating to its directory and running:
```sh
mvn clean install
```
Example:
```sh
cd ui.apps
mvn clean install
```

## Role of `ui.apps`, `ui.content`, and `ui.frontend` Folders
- **ui.apps** – Contains AEM components, templates, and OSGi configurations.
- **ui.content** – Stores content packages such as pages, assets, and configurations.
- **ui.frontend** – Handles frontend assets like JavaScript, CSS, and client libraries.

## Why Are We Using Run Modes?
Run modes allow AEM to adapt configurations based on the environment (e.g., development, staging, production). Different configurations can be applied using run modes.

Example:
```sh
-Dsling.run.modes=author,dev
```

## What is the Publish Environment?
The **publish environment** is where the final content is available for end-users. Authors create content in the **author** instance, which is then activated (published) to the publish instance.

## Why Are We Using Dispatcher?
The **dispatcher** is a caching and security layer in AEM. It helps:
- Improve performance by caching pages.
- Secure the publish instance by restricting direct access.
- Load balancing between multiple publish instances.

## Accessing CRX/DE
The **CRX/DE** is AEM’s developer interface for managing JCR (Java Content Repository).
- **Author Instance:** `http://localhost:4502/crx/de`
- **Publish Instance:** `http://localhost:4503/crx/de`

---
This document provides a foundational understanding of Maven in AEM projects. 🚀
