package main.java.parser;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import main.java.config.Configuration;
import main.java.analysis.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Parser {

    public AnalysisResult parseAndAnalyze(String source, Configuration config) throws IOException {
        JavaParser javaParser = new JavaParser();
        AnalysisResult result = new AnalysisResult();

        Files.walk(Paths.get(source))
             .filter(Files::isRegularFile)
             .filter(path -> path.toString().endsWith(".java"))
             .forEach(path -> {
                 try {
                     CompilationUnit cu = javaParser.parse(new File(path.toString())).getResult().orElse(null);
                     if (cu != null) {
                         // Perform analysis
                         Analyzer analyzer = new Analyzer(config);
                         result.merge(analyzer.analyze(cu));
                     }
                 } catch (IOException e) {
                     e.printStackTrace();
                 }
             });

        return result;
    }
}

