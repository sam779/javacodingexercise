# LittlePay Java Code Exercise
This project is a simple transit charge system that calculates charges for transit trips based on tap on and tap off events.

## Project setup
The project is a simple Java application built with Maven.

The core logic of the application resides in Main.java, which handles the reading of tap events from a CSV file, calculation of trip charges, and writing of trip data to another CSV file.

The project uses a simple dependency injection setup, allowing the tap reader and trip writer to be mocked for unit testing.

## Running the application
The project uses Maven, so you can build and run the project using the Maven command-line tool.

Here's how you can build and run the project:

### Build the project: 

Navigate to the project root directory in your terminal or command prompt and run the following command:

`mvn clean install`

This command cleans any previous builds, compiles the project, and runs the unit tests. If the build is successful, an executable JAR file is created in the target directory.

### Run the application: 

After building the project, you can run the application using the following command:

`java -cp target/JavaCodingExercise-1.0-SNAPSHOT.jar com.littlepay.javacodingexercise.Main`

Alternatively, you can clone the project locally and open it using IntelliJ IDEA and run the code within the IDE.

## Running the tests

The tests can be run as part of the Maven build process, or separately using your IDE's testing capabilities. For example, in IntelliJ IDEA, you can right-click on the test directory and click Run 'All Tests'.

To run the tests with Maven, use the following command:

`mvn test`

This command runs all unit tests in the project and provides a summary of the results.
