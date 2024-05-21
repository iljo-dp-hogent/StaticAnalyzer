package main.java.parser;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseResult;
import com.github.javaparser.ast.CompilationUnit;
import main.java.config.Configuration;
import main.java.analysis.AnalysisResult;
import main.java.analysis.Analyzer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;

public class Parser {
    
    public AnalysisResult parseAndAnalyze(String source, Configuration config) throws IOException {
	    new JavaParser();
	    AnalysisResult result = new AnalysisResult();
        
        Files.walk(Paths.get(source))
                .filter(Files::isRegularFile)
                .filter(path -> path.toString().endsWith(".java"))
                .forEach(path -> {
                    try {
                        // Parse the file and get the ParseResult
                        ParseResult<CompilationUnit> parseResult = JavaParser.parse(new File(path.toString()));
                        
                        // Extract the CompilationUnit from the ParseResult
                        Optional<CompilationUnit> cuOptional = parseResult.getResult();
                        
                        if (cuOptional.isPresent()) {
                            CompilationUnit cu = cuOptional.get();
                            // Perform analysis
                            Analyzer analyzer = new Analyzer(config);
                            result.merge(analyzer.analyze(cu));
                        } else {
                            System.err.println("Could not parse: " + path);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
        
        return result;
    }
}