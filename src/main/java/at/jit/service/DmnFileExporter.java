package at.jit.service;

import org.camunda.bpm.model.dmn.Dmn;
import org.camunda.bpm.model.dmn.DmnModelInstance;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

public class DmnFileExporter {
    public void exportToDmnFile(DmnModelInstance dmnModelInstance, String path) {
        try (FileWriter fileWriter = new FileWriter(path)) {
            PrintWriter printWriter = new PrintWriter(fileWriter);
            String dmnToWrite = new String(Dmn.convertToString(dmnModelInstance).getBytes(), StandardCharsets.UTF_8);
            printWriter.print(dmnToWrite);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
