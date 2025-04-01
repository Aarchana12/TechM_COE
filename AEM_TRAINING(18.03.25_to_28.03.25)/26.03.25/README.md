# AEM Servlet Implementations

## 1. Create `SampleServlet`
### Task:
- Extend `SlingAllMethodsServlet`
- Register using `resourceType`

### Implementation:
```java
@Designate(ocd = SampleServlet.Config.class)
@SlingServletResourceTypes(resourceTypes = "myTraining/components/sample", methods = {"GET"}, extensions = "json")
public class SampleServlet extends SlingAllMethodsServlet {
    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.getWriter().write("{\"message\": \"Hello from SampleServlet!\"}");
    }
}
```

---

## 2. Create `CreatePageServlet`
### Task:
- Extend `SlingSafeMethodsServlet`
- Register using `path`

### Implementation:
```java
@SlingServletPaths("/bin/createpage")
public class CreatePageServlet extends SlingSafeMethodsServlet {
    @Reference
    private ResourceResolverFactory resolverFactory;

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        String pageName = request.getParameter("pageName");
        try (ResourceResolver resolver = resolverFactory.getServiceResourceResolver(null)) {
            PageManager pageManager = resolver.adaptTo(PageManager.class);
            if (pageManager != null) {
                Page newPage = pageManager.create("/content/us/en", pageName, "/apps/wknd/components/page", pageName);
                response.getWriter().write("Page created successfully: " + newPage.getPath());
            }
        } catch (Exception e) {
            response.getWriter().write("Error: " + e.getMessage());
        }
    }
}
```

---

## 3. Take Page Name from User & Create Pages in AEM
### Steps:
- Accept user input (`pageName`)
- Use `PageManager` API to create a new page
- Handle exceptions properly

---

## 4. SearchServlet Using PredicateMap
### Task:
- Search content using `PredicateMap`
- Use QueryBuilder API

### Implementation:
```java
@SlingServletPaths("/bin/searchcontent")
public class SearchServlet extends SlingSafeMethodsServlet {
    @Reference
    private QueryBuilder queryBuilder;

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        Map<String, String> predicates = new HashMap<>();
        predicates.put("type", "cq:Page");
        predicates.put("path", "/content/us/en");
        predicates.put("fulltext", request.getParameter("query"));
        predicates.put("p.limit", "10");

        try (ResourceResolver resolver = request.getResourceResolver()) {
            Session session = resolver.adaptTo(Session.class);
            Query query = queryBuilder.createQuery(PredicateGroup.create(predicates), session);
            SearchResult result = query.getResult();

            for (Hit hit : result.getHits()) {
                response.getWriter().write(hit.getPath() + "\n");
            }
        } catch (Exception e) {
            response.getWriter().write("Error: " + e.getMessage());
        }
    }
}
```

---

## References:
- [AEM Query Builder Guide](https://medium.com/@manumathew28.94/query-builder-aem-5869a1850c85)
