Turns .properties files into constant.java files
Naming changes from example.properties to ExampleConstants.java

To use do this in build.gradle of the project:

//groovy
plugins{
  id = 'com.krokodon.gradle.property2constant'
  ...
}
...


Property2ConstantPlugin {
    sourceDir = ['src/main/resources'] //Plugin will look through everything in the directories to find all possible .properties files
    outputDir = 'build/gen/sources' //Where to place constant files
    packagePrefix = 'com.example' //A package made in the outputDir that will actually contain the constant files, they refrence this as the package name
}

//These are default values, if directories don't exist they will be made

Like-wise for Kotlin and legacy implementation
To update constant files without building do this in command prompt(Pulls from sourceDir):

//For windows to manually generate
gradle generatePropertyConstants

