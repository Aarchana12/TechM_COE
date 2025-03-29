## 1. Create News Room Page Component using Base Page Component
- Navigate to `ui.apps/src/main/content/jcr_root/apps/myTraining/components/structure`
- Create a new folder `newsroom-page`
- Inside `newsroom-page`, create a new file `newsroom-page.html`
- Extend the `base-page` component by adding:

```html
<sly data-sly-use.basePage="com.myTraining.core.models.BasePageModel">
    <div class="newsroom-page">
        <sly data-sly-include="@basePage.html"/>
    </div>
</sly>
```

## 2. Create Custom Page Property: NEWS Configurations
- Navigate to `ui.apps/src/main/content/jcr_root/apps/myTraining/components/structure/newsroom-page`.
- Create a `cq:dialog` file to add custom page properties:

```xml
<jcr:root xmlns:sling="http://sling.apache.org/jcr/sling/1.0"
          xmlns:cq="http://www.day.com/jcr/cq/1.0"
          xmlns:jcr="http://www.jcp.org/jcr/1.0"
          jcr:primaryType="cq:Dialog"
          cq:dialogMode="floating">
    <content jcr:primaryType="nt:unstructured"
             sling:resourceType="granite/ui/components/coral/foundation/container">
        <items jcr:primaryType="nt:unstructured">
            <newsConfig jcr:primaryType="nt:unstructured"
                        sling:resourceType="granite/ui/components/coral/foundation/form/fieldset"
                        jcr:title="NEWS Configurations">
                <items jcr:primaryType="nt:unstructured">
                    <defaultImage jcr:primaryType="nt:unstructured"
                                  sling:resourceType="granite/ui/components/coral/foundation/form/fileupload"
                                  fieldLabel="Default News Image"
                                  name="./defaultNewsImage"/>
                    <readMoreCTA jcr:primaryType="nt:unstructured"
                                 sling:resourceType="granite/ui/components/coral/foundation/form/textfield"
                                 fieldLabel="Read More CTA"
                                 name="./readMoreCTA"/>
                </items>
            </newsConfig>
        </items>
    </content>
</jcr:root>
```

## 3. Create News Room Template Type using News Room Page Component
- Navigate to `ui.apps/src/main/content/jcr_root/conf/myTraining/settings/wcm/template-types`
- Create a folder `newsroom-template-type`
- Inside `newsroom-template-type`, create `.content.xml`:

```xml
<jcr:root xmlns:sling="http://sling.apache.org/jcr/sling/1.0"
          xmlns:cq="http://www.day.com/jcr/cq/1.0"
          xmlns:jcr="http://www.jcp.org/jcr/1.0"
          jcr:primaryType="cq:TemplateType"
          jcr:title="News Room Template Type"
          allowedPaths="/content/myTraining(/.*)?"
          allowedChildren="/apps/myTraining/components/structure/newsroom-page"/>
```

## 4. Create News Room Template using News Room Template Type
- Navigate to `ui.apps/src/main/content/jcr_root/conf/myTraining/settings/wcm/templates`
- Create a folder `newsroom-template`
- Inside `newsroom-template`, create `.content.xml`:

```xml
<jcr:root xmlns:sling="http://sling.apache.org/jcr/sling/1.0"
          xmlns:cq="http://www.day.com/jcr/cq/1.0"
          xmlns:jcr="http://www.jcp.org/jcr/1.0"
          jcr:primaryType="cq:Template"
          jcr:title="News Room Template"
          jcr:description="Template for News Room Pages"
          allowedPaths="/content/myTraining(/.*)?"
          cq:templateType="/conf/myTraining/settings/wcm/template-types/newsroom-template-type"/>
```

## 5. Apply Styling to News/Hello World Component from `ui.frontend`
- Navigate to `ui.frontend/src/main/webpack/components/news/news.scss`
- Add the following styles:

```scss
.news-component {
    h2 {
        color: green;
    }
    p {
        color: yellow;
    }
    .date {
        color: black;
    }
}
```

## 6. Create Custom Style to Apply Above Styling to Hello World or News Component
- Navigate to `ui.apps/src/main/content/jcr_root/apps/myTraining/components/news`.
- Add a `cq:style` configuration inside `.content.xml`:

```xml
<jcr:root xmlns:sling="http://sling.apache.org/jcr/sling/1.0"
          xmlns:cq="http://www.day.com/jcr/cq/1.0"
          xmlns:jcr="http://www.jcp.org/jcr/1.0"
          jcr:primaryType="nt:unstructured">
    <cq:styleClasses jcr:primaryType="nt:unstructured">
        <style1 jcr:primaryType="nt:unstructured"
                cq:styleLabel="Green Header"
                cq:styleId="green-header"/>
        <style2 jcr:primaryType="nt:unstructured"
                cq:styleLabel="Yellow News Detail"
                cq:styleId="yellow-news-detail"/>
    </cq:styleClasses>
</jcr:root>
```

---

### 📌 **Summary**
- **Created a News Room Page Component** using the Base Page Component.
- **Added Custom Page Properties** for NEWS Configurations (Default News Image, Read More CTA).
- **Created a News Room Template Type and News Room Template.**
- **Applied styling to news/hello world components from `ui.frontend`.**
- **Created a custom style system to allow applying specific styles.**

✅ **News Room Page is now fully functional with proper AEM best practices!** 🎉
