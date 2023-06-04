package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AppLogger implements Runnable {
    private static final String LOG_FILE = "C:\\Users\\RexBeer\\Documents\\Tel-ran\\git\\TelRan\\HomeWork_30.05.2023\\log.txt";
    private static final DateTimeFormatter TIMESTAMP_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private final PrintWriter writer;

    public AppLogger() throws IOException {
        writer = new PrintWriter(new FileWriter(LOG_FILE, true));
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            // Logging user choices and results
            try {
                Thread.sleep(1000); // Adjust the sleep duration as needed
                log("Logging user choices and results...");
                // Add your logging logic here, such as writing the choices and results to the file
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        writer.close();
    }

    private void log(String message) {
        String timestamp = LocalDateTime.now().format(TIMESTAMP_FORMATTER);
        writer.println(timestamp + " - " + message);
    }
}
