## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## How to Run the Program

1. **Compile the Program**  
   Open a terminal in the project directory and run the following command to compile the Java files:
   ```
   javac -d bin src/**/*.java
   ```

2. **Run the Program**  
   After successful compilation, run the program using:
   ```
   java -cp bin web_scraping
   ```
   Replace `web_scraping` with the name of the main class containing the `public static void main(String[] args)` method.

> Ensure that all dependencies are properly added to the `lib` folder and configured in your project settings if required.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).
