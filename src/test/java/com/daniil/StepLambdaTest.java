package com.daniil;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class StepLambdaTest {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final int NUMBER = 56;
    @Test
    public void lambdaStepTest() {

        step("Открываем https://github.com", () -> {
            open("https://github.com");
        });
        step("Ищем репозиторий " + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });
        step("Открываем репозиторий " + REPOSITORY, () -> {
            $(linkText("eroshenkoam/allure-example")).click();
        });
        step("Открываем таб issue", () -> {
            $(partialLinkText("Issues")).click();
        });
        step("Ищем Issue № " + NUMBER, () -> {
            Allure.addAttachment("Page Source", "text/html", WebDriverRunner.source(), "html");
            // Разобраться с этой записью
            $(withText(String.valueOf(NUMBER))).should(visible);
        });
    }
}
