package main.java.analysis;

import java.util.List;
import java.util.ArrayList;

public class AnalysisResult {

    private final List<AnalysisIssue> issues = new ArrayList<>();

    public void addIssue(AnalysisIssue issue) {
        issues.add(issue);
    }

    public void merge(AnalysisResult other) {
        issues.addAll(other.issues);
    }

    public List<AnalysisIssue> getIssues() {
        return issues;
    }
}
