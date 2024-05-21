# StaticAnalyzer
# Requirements Gathering
- Language Support: Java

## Analysis Types:
    Syntax analysis
    Semantic analysis
    Code style checks
    Complexity analysis
    Dependency analysis
## Features:
    Command-line interface (CLI)
    Configurable rules and thresholds
    Report generation in various formats (text, JSON, XML)
    Integration with build tools (Maven, Gradle)
    Extensibility for custom rules
# 2. Architecture Design
## Core Components:
    CLI Module: Handles command-line interactions.
    Parser Module: Parses Java code into an abstract syntax tree (AST).
    Analysis Module: Performs various static analysis tasks.
    Reporting Module: Generates and formats reports.
    Configuration Module: Manages user-defined settings and rules.
# 3. Technology Stack
Language: Java (for ease of integration with Java projects)
Libraries and Tools:
JavaParser: For parsing Java code and generating ASTs.
ANTLR: For custom parsing and lexer rules.
JUnit: For unit testing.
Picocli: For building the CLI.
4. Implementation Plan

To compile the code and run it, make sure you have you JAVA_HOME set in your path

Then run
```
./gradlew build
```
and then
```
java -jar build/libs/StaticAnalyzer.jar analyze path/to/your/source/code -c path/to/config.properties
```

Currently I'm still fighting 1 mayor bug

