package com.rookie.hustle.common.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * zbhou
 */
@Data
@ConfigurationProperties(prefix = "spring.swagger")
public class SwaggerProperties {
    private String title;

    private String description;

    private String termsOfServiceUrl;

    private String contactName;

    private String contactUrl;

    private String contactEmail;

    private String license;

    private String licenseUrl;

    private String version;

    private boolean enable;

    private String basePackage;

}
