package com.myTraining.core.servlets;

import com.day.cq.commons.jcr.JcrConstants;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.propertytypes.ServiceDescription;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Servlet that writes some sample content into the response.
 * It is mounted for all resources of a specific Sling resource type.
 * The {@link SlingSafeMethodsServlet} shall be used for HTTP methods that are idempotent.
 * For write operations use the {@link SlingAllMethodsServlet}.
 */
@Component(service = { Servlet.class }, property = {
        "sling.servlet.resourceTypes=myTraining/components/sample",
        "sling.servlet.methods=" + HttpConstants.METHOD_GET,
        "sling.servlet.extensions=txt"
})
@ServiceDescription("Simple Demo Servlet")
public class SimpleServlet extends SlingAllMethodsServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(SlingHttpServletRequest req, SlingHttpServletResponse resp) throws ServletException, IOException {
        // Get the resource from the request
        final Resource resource = req.getResource();

        // Set content type to plain text
        resp.setContentType("text/plain");

        // Get the title property from the resource and write it into the response
        String title = resource.getValueMap().get(JcrConstants.JCR_TITLE, "No Title");
        resp.getWriter().write("Title = " + title);
    }
}
