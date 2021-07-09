package io;

import utils.CSVUtils;

import java.io.IOException;

public class App {
    public static void main(String... args) throws IOException {
        App application = new App();
        application.init();
    }

    public void init() throws IOException {
        CSVUtils.loadFiles();
        Console.printWelcome();
        Console.mainMenu();
    }
}
