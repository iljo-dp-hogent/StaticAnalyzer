package main.java.cli;

import main.java.analysis.AnalysisResult;
import picocli.CommandLine;
import java.util.concurrent.Callable;
import main.java.config.Configuration;
import main.java.parser.*;
import main.java.report.*;
@CommandLine.Command(name = "analyze", mixinStandardHelpOptions = true, version = "1.0",
    description = "Static code analysis for Java projects.")
public class StaticAnalyzerCLI implements Callable<Integer> {

    @CommandLine.Parameters(index = "0", description = "The Java source file or directory to analyze.")
    private String source;

    @CommandLine.Option(names = {"-c", "--config"}, description = "Configuration file for analysis rules.")
    private String configFilePath;

    @Override
    public Integer call() throws Exception {
        // Initialize configuration
        Configuration config = Configuration.load(configFilePath);

        // Parse and analyze code
        Parser parser = new Parser();
        AnalysisResult result = parser.parseAndAnalyze(source, config);

        // Generate report
        ReportGenerator reportGenerator = new ReportGenerator();
        reportGenerator.generate(result);

        return 0;
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new StaticAnalyzerCLI()).execute(args);
        System.exit(exitCode);
    }
}
