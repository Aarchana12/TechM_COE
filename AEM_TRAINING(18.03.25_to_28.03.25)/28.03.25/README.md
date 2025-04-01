# Newsroom Portfolio Website Assignment

## Overview
This assignment involves building a **Newsroom Portfolio Website** using **Adobe Experience Manager (AEM)**. The project consists of a **Header, Footer, Home Page, News Page, About Me Page, and Contact Me Page**. The website will be fully functional with dynamic content, fetching news articles and displaying them in a structured manner.

---

## 📌 Features

- **OOTB Header & Footer** with proper styling
- **Home Page** featuring a teaser component for award ceremonies
- **News Page** dynamically fetching news articles from AEM content structure
- **About Me Page** using a custom journalist component
- **Contact Me Page** for connecting with the author
- **Reusable Template Structure** for consistency across all pages

---

## 🚀 Implementation Steps

### 1️⃣ Header Setup

**Objective:** Create a navigation menu with drop-down support.

- Use **OOTB Header Component**.
- Add menu items: **News, About Me, Contact Me, Home Page**.
- **Books section should be a drop-down**, with **News appearing inside it**.

📌 **Implementation** (Use AEM Site Console):
1. Navigate to **/apps/components/header**.
2. Configure navigation items.
3. Style the header using **clientlibs** (`ui.frontend`):

```css
.header {
    background-color: #f8f9fa;
    font-size: 18px;
}
.dropdown {
    position: relative;
    display: inline-block;
}
```

---

### 2️⃣ Footer Sections

**Sections Required:**
1. **About Me**
2. **Contact Me**
3. **Latest 5 News (List Component with Hyperlinks in a new tab)**
4. **Social Media Section** (Use List Component to provide links)

📌 **Implementation:**
1. Create an **Experience Fragment** under **/content/experience-fragments/newsroom/footer**.
2. Add necessary **OOTB components** (Text, List, etc.).
3. Use **AEM Component Dialogs** for content configuration.

```html
<!-- List Component for Latest News -->
<ul data-sly-list.news="${newsList}">
    <li><a href="${news.link}" target="_blank">${news.title}</a></li>
</ul>
```

---

### 3️⃣ Home Page

**Objective:** Display a **Teaser Component** featuring an **Award Ceremony**.

📌 **Steps:**
1. **Use OOTB Teaser Component**.
2. Configure fields:
   - **Image** (Award Ceremony Picture)
   - **Title & Description**
   - **CTA (Links to the Full News Page)**
3. Author the Teaser with relevant content.

```html
<sly data-sly-use.teaser="com.adobe.cq.wcm.core.components.models.Teaser">
    <img src="${teaser.image}" alt="Award Ceremony">
    <h2>${teaser.title}</h2>
    <p>${teaser.description}</p>
    <a href="${teaser.link}" class="btn">Read More</a>
</sly>
```

---

### 4️⃣ News Page (Dynamic News Fetching)

**Objective:** Create a **NewsRoom Component** that dynamically fetches news articles.

📌 **Steps:**
1. **Create `newsroom` component** under `/apps/newsroom/components/newsroom`.
2. Use **Sling Models** to fetch news articles from `/content/news`.

📌 **Sling Model for Fetching News:**
```java
@Model(adaptables = Resource.class)
public class NewsroomModel {
    @Inject
    private ResourceResolver resourceResolver;
    
    public List<NewsArticle> getNewsArticles() {
        List<NewsArticle> newsList = new ArrayList<>();
        Resource newsRoot = resourceResolver.getResource("/content/news");
        
        for (Resource child : newsRoot.getChildren()) {
            ValueMap props = child.getValueMap();
            newsList.add(new NewsArticle(props.get("title", String.class),
                                         props.get("description", String.class),
                                         props.get("image", String.class)));
        }
        return newsList;
    }
}
```

📌 **HTL for Displaying News Articles as Cards:**
```html
<div class="newsroom-container">
    <sly data-sly-list.news="${newsroom.newsArticles}">
        <div class="news-card">
            <img src="${news.image}" alt="News Image">
            <h3>${news.title}</h3>
            <p>${news.description}</p>
        </div>
    </sly>
</div>
```

📌 **CSS Styling for News Cards:**
```css
.news-card {
    border: 1px solid #ddd;
    padding: 10px;
    margin: 10px;
    background-color: #f9f9f9;
}
```

---

### 5️⃣ About Me Page

📌 **Steps:**
1. **Create a `journalist` component** under `/apps/newsroom/components/journalist`.
2. Fields Required:
   - **Name**
   - **Biography**
   - **Profile Picture**

📌 **HTL for Journalist Component:**
```html
<div class="journalist-profile">
    <img src="${properties.profileImage}" alt="Journalist">
    <h2>${properties.name}</h2>
    <p>${properties.bio}</p>
</div>
```

---

### 6️⃣ Contact Me Page

📌 **Steps:**
1. **Use OOTB Teaser or Text Component**.
2. Add:
   - **Email**
   - **Phone Number**
   - **Social Media Links**

📌 **Example HTML:**
```html
<div class="contact-info">
    <p>Email: journalist@email.com</p>
    <p>Phone: +1234567890</p>
    <p>Follow on: <a href="#">Twitter</a> | <a href="#">LinkedIn</a></p>
</div>
```

---

### 📌 Final Touches
- Ensure **Header and Footer are at the Template Level**.
- **Home Page uses the OOTB Content Page Template**.
- **News Page uses a Custom Template** for dynamic news fetching.

---

## ✅ Conclusion
This project demonstrates how to build a **Newsroom Portfolio Website** in **AEM** using:
- **OOTB and Custom Components**
- **Sling Models for Data Fetching**
- **HTL and Clientlibs for Rendering & Styling**
- **AEM Templates and Content Structures**
