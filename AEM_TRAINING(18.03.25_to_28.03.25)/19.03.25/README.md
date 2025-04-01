# AEM Training - Day 1 Tasks

## Table of Contents
- [What is DAM and Why We Use It?](#what-is-dam-and-why-we-use-it)
- [Create Folder and Upload Images](#create-folder-and-upload-images)
- [Renditions in AEM](#renditions-in-aem)
- [Modify HelloWorld Component](#modify-helloworld-component)
- [Use @ValueMapValue in HelloWorldModel](#use-valuemapvalue-in-helloworldmodel)
- [Package Manager & JAR Creation](#package-manager--jar-creation)
- [Configure Replication Agent & Publish Page](#configure-replication-agent--publish-page)

---

## What is DAM and Why We Use It?

<details>
<summary>Click to expand</summary>

**DAM (Digital Asset Management)** is a system that allows users to store, manage, and retrieve digital assets (images, videos, documents, etc.) efficiently. AEM provides a built-in DAM system under `/content/dam` for asset management.

**Why use DAM?**
- Centralized storage for digital assets.
- Efficient metadata management.
- Image renditions for different formats and sizes.
- Asset versioning and workflow capabilities.

</details>

---

## Create Folder and Upload Images

<details>
<summary>Click to expand</summary>

### 📌 Steps to Create Folder & Upload Images
1. **Go to AEM DAM Console:**
   ```
   http://localhost:4502/assets.html/content/dam
   ```
2. **Create a new folder:**
   - Navigate to `/content/dam`.
   - Click **Create** → **Folder**.
   - Enter **Folder Name**: `myTraining` → Click **Create**.
   - Inside `myTraining`, create another folder: `us/en-us`.
3. **Upload 2 Images:**
   - Open `us/en-us` folder.
   - Click **Upload** → Select 2 images from your system.
   - Click **Save**.
4. **Author Images on Page:**
   - Open **Sites Console**: `http://localhost:4502/sites.html/content/myTraining`.
   - Edit your page and drag & drop an **Image Component**.
   - Select one of the uploaded images and **Save** the page.

</details>

---

## Renditions in AEM

<details>
<summary>Click to expand</summary>

**What are Renditions?**
Renditions are different variations of an image created automatically when you upload an asset to DAM. AEM generates renditions in multiple sizes and formats.

### 📌 Steps to Check Renditions
1. **Go to DAM Console:**
   ```
   http://localhost:4502/assets.html/content/dam/myTraining/us/en-us
   ```
2. Click on an uploaded image.
3. Click **View Properties** → Navigate to the **Renditions** tab.
4. Check the available renditions (e.g., thumbnail, web-optimized versions, etc.).

</details>

---

## Modify HelloWorld Component

<details>
<summary>Click to expand</summary>

### 📌 Steps to Add FirstName & LastName Fields

1. **Open CRXDE:** `http://localhost:4502/crx/de/`
2. Navigate to:
   ```
   /apps/myTraining/components/helloworld
   ```
3. Locate `cq:dialog` node and add two new fields:
   ```
   firstName (Text Field)
   lastName (Text Field)
   ```
4. Save and update `helloWorld.html`:
   ```html
   <div>
       <h2>Hello World Component</h2>
       <p>First Name: ${properties.firstName}</p>
       <p>Last Name: ${properties.lastName}</p>
   </div>
   ```
</details>

---

## Use @ValueMapValue in HelloWorldModel

<details>
<summary>Click to expand</summary>

### 📌 Steps to Implement @ValueMapValue

1. **Open Java file:**
   ```
   /core/src/main/java/com/myTraining/core/models/HelloWorldModel.java
   ```
2. Update model:
   ```java
   @ValueMapValue
   private String firstName;
   
   @ValueMapValue
   private String lastName;
   ```
3. Update `helloWorld.html`:
   ```html
   <div data-sly-use.model="com.myTraining.core.models.HelloWorldModel">
       <h2>Hello World Component</h2>
       <p>First Name: ${model.firstName}</p>
       <p>Last Name: ${model.lastName}</p>
   </div>
   ```
</details>

---

## Package Manager & JAR Creation

<details>
<summary>Click to expand</summary>

### 📌 Create DAM Package (Images)
1. Open **Package Manager**: `http://localhost:4502/crx/packmgr/index.jsp`
2. Create a new package:
   - Name: `myTraining_DAM_Package`
   - Group: `myTraining`
   - Path: `/content/dam/myTraining/us/en-us`
3. Click **Build** & **Download** the package.

### 📌 Create HelloWorld Component Package
1. Create another package:
   - Name: `myTraining_HelloWorld_Package`
   - Group: `myTraining`
   - Path: `/apps/myTraining/components/helloworld`
2. Click **Build** & **Download** the package.

</details>

---

## Configure Replication Agent & Publish Page

<details>
<summary>Click to expand</summary>

### 📌 Configure Replication Agent
1. Open **Replication Agents:**
   ```
   http://localhost:4502/etc/replication/agents.author.html
   ```
2. Edit **Default Agent**:
   - URI: `http://localhost:4503/bin/receive`
   - User: `admin`
   - Password: `admin`
3. Click **Test Connection** (Should say ✅ Successful).

### 📌 Publish Page to 4503
1. Open **Sites Console:**
   ```
   http://localhost:4502/sites.html/content
   ```
2. Select your page → Click **Publish**.
3. Open in **Publish Instance (4503):**
   ```
   http://localhost:4503/content/myTraining/us/en.html
   ```

</details>

---

