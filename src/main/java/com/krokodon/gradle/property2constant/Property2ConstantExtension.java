package com.krokodon.gradle.property2constant;
import java.util.Arrays;
import java.util.List;
public class Property2ConstantExtension {
    /**
     * List of source directories that will be searched.
     */
    private List<String> sourceDir = Arrays.asList("src/main/resources");
    /**
     * Specified output directory.
     */
    private String outputDir = "build/generated-sources";
    /**
     * Package name that will be added to the output directory where the constant file will sit.
     */
    private String packagePrefix = "com.user";

    public List<String> getSourceDir() {
        return sourceDir;
    }

    public void setSourceDir(final List<String> dir) {
        this.sourceDir = dir;
    }
    public String getOutputDir() {
        return outputDir;
    }

    public void setOutputDir(final String dir) {
        this.outputDir = dir;
    }
    public String getPackagePrefix() {
        return packagePrefix;
    }
    public void setPackagePrefix(final String prefix) {
        this.packagePrefix = prefix;
    }
}
