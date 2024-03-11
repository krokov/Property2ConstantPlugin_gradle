package com.krokodon.plugins.property2constant;

public class Property2ConstantExtension {

    private String sourceDir = "src/main/resources";
    private String outputDir = "build/generated/sources";
    private String packagePrefix = "com.user";

    public String getSourceDir() {
        return sourceDir;
    }

    public void setSourceDir(String sourceDir) {
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
