package main.java.report;

import java.io.FileWriter;
import java.io.IOException;
import main.java.analysis.*;
public class ReportGenerator {

    public void generate(AnalysisResult result) {
        // Print to console
        result.getIssues().forEach(issue -> System.out.println(issue.getMessage()));

        // Optionally, write to a file
        try (FileWriter writer = new FileWriter("analysis_report.txt")) {
            for (var issue : result.getIssues()) {
                writer.write(issue.getMessage() + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
