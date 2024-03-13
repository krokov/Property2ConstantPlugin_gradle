package com.krokodon.gradle.property2constant;
import java.util.Arrays;
import java.util.List;
public class Property2ConstantExtension {
    private List<String> sourceDir = Arrays.asList("src/main/resources");
    private String outputDir = "build/generated/sources";
    private String packagePrefix = "com.user";

    public List<String> getSourceDir() {
        return sourceDir;
    }

    public void setSourceDir(List<String> sourceDir) {
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