package com.daniil;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class WebSteps {
    @Step("Открываем https://github.com")
    public void openGit(){
        open("https://github.com");
    }
    @Step("Ищем репозиторий {repository}")
    public void searchRepository(String repository){
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repository);
        $(".header-search-input").submit();
    }
    @Step("Заходим в репозиторий {repository}")
    public void openRepository(){
        $(linkText("eroshenkoam/allure-example")).click();
    }
    @Step("Открываем таб Issue")
    public void openTabIssues(){
        $(partialLinkText("Issues")).click();
    }
    @Step("Ищем Issue № {number}")
    public void checkIssueExist(int number){
        $(withText(String.valueOf(number))).should(visible);
    }
    @Attachment(value = "Screenshot", type = "text/html", fileExtension = "html")
    public byte[] attachPageSource() {
        return WebDriverRunner.source().getBytes(StandardCharsets.UTF_8);
    }
}
