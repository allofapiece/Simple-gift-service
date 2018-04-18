package com.epam.service;

import com.epam.service.parser.PropertyParserInterface;
import com.epam.service.parser.TextPropertyParser;

import java.io.File;
import java.util.HashMap;

/**
 * This class provides access to application properties
 * Attention. File path with main properties described in
 * mainPropertyFilePath variable.
 */
public class Properties {

    private String mainPropertiesFilePath = "src\\com\\epam\\property\\property.txt"; //The main property file path. Change, if it is different
    private String propertiesFilePath;

    private File mainPropertiesFile;
    private File propertyFile;

    private HashMap<String, String> mainProperties;
    private HashMap<String, String> properties;

    public Properties() {
        initMainProperties(this.mainPropertiesFilePath);
    }

    public Properties(String mainPropertiesFilePath) {
        this.setMainPropertiesFilePath(mainPropertiesFilePath);

        initMainProperties(mainPropertiesFilePath);
    }

    public void load(String propertyFilePath) {
        initProperties(propertyFilePath);
    }

    private HashMap<String, String> loadMainProperties() {
        TextPropertyParser textPropertyParser = new TextPropertyParser();
        mainProperties = textPropertyParser.parse(this.mainPropertiesFilePath);

        return this.mainProperties;
    }

    private HashMap<String, String> loadProperties() {
        PropertyParserInterface textPropertyParser = new TextPropertyParser();
        properties = textPropertyParser.parse(this.propertiesFilePath);

        return this.properties;
    }

    private File initMainProperties(String path) {
        this.mainProperties = new HashMap<>();
        this.mainPropertiesFile = new File(path);

        return this.mainPropertiesFile;
    }

    private File initProperties(String path) {
        this.properties = new HashMap<>();
        this.propertyFile = new File(path);
        this.propertiesFilePath = path;

        return this.propertyFile;
    }

    public String getMainProperty(String property) {
        if (this.mainProperties.isEmpty()) {
            this.mainProperties = this.loadMainProperties();
        }
        property = property.toLowerCase();

        return this.mainProperties.get(property);
    }

    public String getProperty(String property) {
        if (this.properties.isEmpty()) {
            this.properties = this.loadProperties();
        }
        property = property.toLowerCase();

        return this.properties.get(property);
    }

    public String getMainPropertiesFilePath() {
        return mainPropertiesFilePath;
    }

    public void setMainPropertiesFilePath(String mainPropertiesFilePath) {
        this.mainPropertiesFilePath = mainPropertiesFilePath;
    }

    public File getMainPropertiesFile() {
        return mainPropertiesFile;
    }

    public void setMainPropertiesFile(File mainPropertiesFile) {
        this.mainPropertiesFile = mainPropertiesFile;
    }

    public String getPropertiesFilePath() {
        return propertiesFilePath;
    }

    public void setPropertiesFilePath(String propertiesFilePath) {
        this.propertiesFilePath = propertiesFilePath;
    }

    public File getPropertyFile() {
        return propertyFile;
    }

    public void setPropertyFile(File propertyFile) {
        this.propertyFile = propertyFile;
    }

    public HashMap<String, String> getMainProperties() {
        return mainProperties;
    }

    public void setMainProperties(HashMap<String, String> mainProperties) {
        this.mainProperties = mainProperties;
    }

    public HashMap<String, String> getProperties() {
        return properties;
    }

    public void setProperties(HashMap<String, String> properties) {
        this.properties = properties;
    }
}
