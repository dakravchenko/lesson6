package com.daniil;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class AnnotatedSteps {
    WebSteps steps = new WebSteps();
    String repository = "eroshenkoam/allure-example";

    @AfterEach
    public void saveSources() {
        steps.attachPageSource();
    }
    @Test
    public void AnnotatedStepsTest(){
        steps.openGit();
        steps.searchRepository(repository);
        steps.openRepository();
        steps.openTabIssues();
        steps.checkIssueExist(56);
    }
}
