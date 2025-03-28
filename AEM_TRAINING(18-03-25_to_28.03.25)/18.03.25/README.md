# Maven & AEM Project Overview

## Maven Lifecycle
<details>
  <summary>What is Maven Lifecycle?</summary>
  Maven lifecycle consists of different phases such as:
  - **Validate**: Checks if the project is correct and all necessary information is available.
  - **Compile**: Compiles the source code.
  - **Test**: Runs unit tests.
  - **Package**: Bundles the compiled code into a deployable format (e.g., JAR, WAR, ZIP).
  - **Verify**: Runs additional checks.
  - **Install**: Installs the package in the local repository.
  - **Deploy**: Deploys the package to a remote repository.
</details>

## POM.xml File
<details>
  <summary>What is pom.xml and why do we use it?</summary>
  - `pom.xml` (Project Object Model) is the core configuration file for Maven.
  - It defines the project, dependencies, build settings, and plugins.
  - It enables automation of builds and dependency management.
</details>

## Maven Dependencies
<details>
  <summary>How do dependencies work?</summary>
  - Dependencies are managed inside `pom.xml` using `<dependencies>`.
  - Maven automatically downloads dependencies from the Maven Central Repository.
  - Example:
    ```xml
    <dependencies>
      <dependency>
        <groupId>org.apache.sling</groupId>
        <artifactId>org.apache.sling.api</artifactId>
        <version>2.24.0</version>
      </dependency>
    </dependencies>
    ```
</details>

## Maven Repository
<details>
  <summary>How to check the Maven repository?</summary>
  - Maven repositories store JAR files and metadata for dependencies.
  - Types of repositories:
    - **Local Repository** (`.m2` folder on your machine)
    - **Central Repository** (Maven Central: https://repo.maven.apache.org/maven2/)
    - **Remote Repository** (Company-specific repositories like Nexus, Artifactory)
</details>

## Building Modules with Maven
<details>
  <summary>How do all modules build using Maven?</summary>
  - Use the following command to build all modules:
    ```sh
    mvn clean install
    ```
  - This command compiles, tests, packages, and installs the project in the local repository.
</details>

<details>
  <summary>Can we build a specific module?</summary>
  - Yes, use:
    ```sh
    mvn clean install -pl <module-name> -am
    ```
  - Example:
    ```sh
    mvn clean install -pl core -am
    ```
</details>

## AEM Folder Structure
<details>
  <summary>Role of ui.apps, ui.content, and ui.frontend folders?</summary>
  - **ui.apps**: Stores the OSGi configurations, component definitions, templates, etc.
  - **ui.content**: Stores content such as pages and assets.
  - **ui.frontend**: Stores client-side code (JavaScript, CSS, etc.)
</details>

## Run Modes in AEM
<details>
  <summary>Why are we using run mode?</summary>
  - Run modes allow different configurations based on the environment (dev, stage, prod).
  - Example:
    ```sh
    java -jar aem-author.jar -r author,dev
    ```
</details>

## Publish Environment
<details>
  <summary>What is the Publish environment?</summary>
  - The **Publish environment** is where the final content is served to end-users.
  - It receives replicated content from the Author instance.
</details>

## Dispatcher in AEM
<details>
  <summary>Why are we using a dispatcher?</summary>
  - The dispatcher is a caching and security layer between the AEM Publish instance and end-users.
  - It improves performance and provides load balancing.
</details>

## Accessing CRX/DE
<details>
  <summary>Where can we access CRX/DE?</summary>
  - **Author Instance:** `http://localhost:4502/crx/de`
  - **Publish Instance:** `http://localhost:4503/crx/de`
</details>
