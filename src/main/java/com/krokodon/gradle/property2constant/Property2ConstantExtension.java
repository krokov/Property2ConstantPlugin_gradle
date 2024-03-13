package com.krokodon.gradle.property2constant;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
public class Property2ConstantExtension {

    private String sourceDir = "src/main/resources";
    private String outputDir = "gradle/build/generated/sources";
    private String packagePrefix = "com.user";

    public String getSourceDir() {
        return sourceDir;
    }

    public void setSourceDirs(String sourceDir) {
        this.sourceDir = sourceDir;
    }

    public String getOutputDir() {
        return outputDir;
    }

    public void setOutputDir(String outputDir) {
        this.outputDir = outputDir;
    }
    public String getPackagePrefix() {
        return packagePrefix;
    }
    public void setPackagePrefix(String prefix) {
        this.packagePrefix = prefix;
    }


}
