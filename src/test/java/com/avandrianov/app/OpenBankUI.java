package com.avandrianov.app;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class OpenBankUI {
    @Test
    public void testName() {
        open("http://google.com");
        $(By.name("q")).setValue("Открытие").pressEnter();
        $(byXpath("//link[@href='https://www.open.ru/']")).should(Condition.exist);
        $(byXpath("//link[@href='https://www.open.ru/']/..//a")).click();
        String usdBay = $$(byXpath("//span[@class='main-page-exchange__rate']")).get(0).getText();
        String usdSell = $$(byXpath("//span[@class='main-page-exchange__rate']")).get(1).getText();
        String eurBay = $$(byXpath("//span[@class='main-page-exchange__rate']")).get(2).getText();
        String eurSell = $$(byXpath("//span[@class='main-page-exchange__rate']")).get(3).getText();
        assert (Double.parseDouble(usdBay.replace(',','.'))<Double.parseDouble(usdSell.replace(',','.')));
        assert (Double.parseDouble(eurBay.replace(',','.'))<Double.parseDouble(eurSell.replace(',','.')));
    }
}
