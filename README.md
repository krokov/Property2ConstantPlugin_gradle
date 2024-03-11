Turns .properties files into constant.java files
Naming changes from example.properties to ExampleConstants.java

To use do this in build.gradle of the project:

//groovy
plugins{
  id = 'com.krok.property2constant'
  ...
}
...
//These are default values, if fodler doesn't exist it will be made
Property2ConstantPlugin {
    sourceDir = 'src/main/resources' //Plugin will look through everything in directory to find all possible .properties files
    outputDir = 'build/gen/sources' //Where to place constant files
    packagePrefix = 'com.krok' //A package made in the outputDir that will actually contain the constant files, they refrence this as the package name
}

Like-wise for Kotlin and legacy implementation
To update constant files without building do this in command prompt(Pulls from sourceDir):

//For windows
gradle generatePropertyConstants

