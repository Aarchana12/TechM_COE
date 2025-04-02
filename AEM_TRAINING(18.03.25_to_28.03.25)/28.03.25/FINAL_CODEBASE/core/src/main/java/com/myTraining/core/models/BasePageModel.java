package com.myTraining.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class)
public class BasePageModel {

    @ValueMapValue
    private String pageTitle;

    @ValueMapValue
    private String pageDescription;

    // New properties for News Configuration
    @ValueMapValue
    private String defaultNewsImage;  // URL or path to the image

    @ValueMapValue
    private String readMoreCTA;  // Text for "Read More" CTA

    // Getters for pageTitle and pageDescription
    public String getPageTitle() {
        return pageTitle;
    }

    public String getPageDescription() {
        return pageDescription;
    }

    // New getters for News Configuration
    public String getDefaultNewsImage() {
        return defaultNewsImage;
    }

    public String getReadMoreCTA() {
        return readMoreCTA;
    }
}
