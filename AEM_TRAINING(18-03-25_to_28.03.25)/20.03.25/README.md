# AEM News Component Implementation

## 1. Create a New Component with Sling Model
### Requirements:
- **Title:** Should print as `<h2>`
- **News Detail:** Should print as `<p>`
- **Published Date:** Should be displayed
- **Source:** Should be included

### Solution:
- Create a **news** component under `ui.apps`.
- Implement a Sling Model to fetch values dynamically.

```java
@Model(adaptables = Resource.class)
public class NewsModel {

    @Inject
    private String title;

    @Inject
    private String newsDetail;

    @Inject
    private String publishedDate;

    @Inject
    private String source;

    public String getTitle() { return title; }
    public String getNewsDetail() { return newsDetail; }
    public String getPublishedDate() { return publishedDate; }
    public String getSource() { return source; }
}
```

### news.html
```html
<div class="cop-news-component">
    <h2>${newsModel.title}</h2>
    <p>${newsModel.newsDetail}</p>
    <span>${newsModel.publishedDate}</span>
    <strong>${newsModel.source}</strong>
</div>
```

---

## 2. Create Multi-field News Component
### Requirements:
- Allow multiple news entries using Sling Model.
- Fields: Title, Source

### Solution:
```java
@Model(adaptables = Resource.class)
public class MultiNewsModel {

    @Inject
    @Named("./newsItems")
    @Via("child")
    private List<NewsItem> newsItems;

    public List<NewsItem> getNewsItems() { return newsItems; }

    @Model(adaptables = Resource.class)
    public static class NewsItem {
        @Inject private String title;
        @Inject private String source;
        public String getTitle() { return title; }
        public String getSource() { return source; }
    }
}
```

### multi-news.html
```html
<div class="multi-news">
    <sly data-sly-list.news="${multiNewsModel.newsItems}">
        <h2>${news.title}</h2>
        <p>Source: ${news.source}</p>
    </sly>
</div>
```

---

## 3. Create Clientlibs for News Component
### Solution:
- Create `clientlibs` under `ui.apps/src/main/content/jcr_root/apps/myTraining/clientlibs/news`.
- Add styles and JavaScript.

#### clientlib-site.css
```css
.cop-news-component h2 { color: green; }
.cop-news-component p { color: yellow; }
.cop-news-component span { color: black; }
```

---

## 4. Add Custom Style Name
### Solution:
- Modify `cq_dialog.xml` to add style classes.

```xml
<items jcr:primaryType="nt:unstructured">
    <style jcr:primaryType="nt:unstructured"
           sling:resourceType="granite/ui/components/coral/foundation/form/select"
           fieldLabel="Style"
           name="./styleClass">
        <items jcr:primaryType="nt:unstructured">
            <default jcr:primaryType="nt:unstructured" value="cop-news-component" text="News Component"/>
        </items>
    </style>
</items>
```

---

## 5. Create a Base Page Component for Open Graph Metadata
### Solution:
- Add metadata fields in `basepage.html`.

```html
<meta property="og:title" content="${properties.ogTitle}"/>
<meta property="og:description" content="${properties.ogDescription}"/>
<meta property="og:image" content="${properties.ogImage}"/>
```

---

## 6. Create Custom Page Properties (Global Properties)
### Solution:
- Modify the page properties dialog.

```xml
<items jcr:primaryType="nt:unstructured">
    <ogTitle jcr:primaryType="nt:unstructured" fieldLabel="OG Title" name="./ogTitle"/>
    <ogDescription jcr:primaryType="nt:unstructured" fieldLabel="OG Description" name="./ogDescription"/>
    <ogImage jcr:primaryType="nt:unstructured" fieldLabel="OG Image" name="./ogImage"/>
</items>
```

---

## 7. What is extraClientlib and How to Add It?
### Explanation:
- `extraClientlib` is used to add additional client libraries at runtime.
- Add it to the **multi-field news component**.

### Solution:
Modify `multi-news.html`:
```html
<sly data-sly-use.clientlib="core/wcm/components/commons/v1/templates/clientlib.html"/>
<sly data-sly-call="${clientlib.js @ categories='myTraining.extraClientlib'}"/>
```

### clientlib-extra.js
```js
console.log("Extra ClientLib Loaded");
```

---

## Conclusion
This setup ensures:
- A structured News Component using Sling Model.
- Multi-field support for multiple news items.
- Styled with `clientlibs`.
- Added metadata support with Open Graph properties.
- Custom page properties for metadata fields.
- `extraClientlib` for additional assets.

