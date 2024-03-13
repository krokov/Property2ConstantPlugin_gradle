package com.krokodon.gradle.property2constant;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.file.FileTree;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.util.List;
import java.nio.charset.StandardCharsets;

public class Property2ConstantPlugin implements Plugin<Project> {

    @Override
    public void apply(Project project) {
        project.getExtensions().create("Property2ConstantPlugin", Property2ConstantExtension.class);
        //Auto
        generateConstants(project);
        //Manual
        project.getTasks().register("generatePropertyConstants", task -> {
            task.doLast(t -> generateConstants(project));
        });

    }

    private void generateConstants(Project project) {
        Property2ConstantExtension extension = project.getExtensions().findByType(Property2ConstantExtension.class);

        String outputDir = extension.getOutputDir();
        String prefix = extension.getPackagePrefix();
        String sourceDir = extension.getSourceDir();

        FileTree propertyFiles = project.fileTree(sourceDir)
                .matching(pattern -> pattern.include("**/*.properties"));

        String currentDirectory = System.getProperty("user.dir");
        project.getLogger().lifecycle("working dir: " + currentDirectory);

        propertyFiles.forEach(file -> {
            try {
                List<String> lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
                String className = file.getName().replaceAll("\\.properties", "") + "Constants";
                className = className.substring(0, 1).toUpperCase() + className.substring(1);

                File outputDirectory = new File(currentDirectory + "/" + outputDir);
                outputDirectory.mkdirs();

                File packageDirectory = new File(outputDirectory, "/" + prefix);
                packageDirectory.mkdirs();

                File constantsFile = new File(packageDirectory, className + ".java");
                constantsFile.createNewFile();

                File oldConstantsFile = new File(packageDirectory, className + ".java");
                if (oldConstantsFile.exists()) {
                    oldConstantsFile.delete();
                }

                String constantsContent = generateConstantsContent(lines, prefix, className);
                try (FileOutputStream fos = new FileOutputStream(constantsFile);
                     OutputStreamWriter osw = new OutputStreamWriter(fos)) {
                    osw.write(constantsContent);
                } catch (IOException e) {
                    e.printStackTrace();
                }


                project.getLogger().lifecycle("Generated constants file: " + constantsFile.toPath());
            } catch (IOException e) {
                project.getLogger().error("Failed to generate constants file for: " + file.getAbsolutePath(), e);
            }
        });
            }



    private String generateConstantsContent(List<String> lines, String prefix, String className) {
        StringBuilder content = new StringBuilder();
        content.append("package ").append(prefix).append(";\n\n");
        content.append("public final class ").append(className).append(" {\n");
        content.append("private ").append(className).append("() {};\n");
        lines.stream()
                .filter(line -> !line.trim().startsWith("#") && line.contains("="))
                .map(line -> line.split("=")[0].trim())
                .distinct()
                .forEach(key -> {
                    String constantName = key.toUpperCase().replaceAll("[^\\p{L}\\p{N}_]+", "_");
                    content.append("\tpublic static final String ").append(constantName).append(" = \"").append(key).append("\";\n");
                });

        content.append("}\n");
        return content.toString();
    }
}