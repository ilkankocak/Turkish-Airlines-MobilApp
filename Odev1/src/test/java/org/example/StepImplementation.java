package org.example;

import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.example.BaseTest.appiumDriver;

public class StepImplementation {

   @Step("<id> elemente id ile tıkla")
    public void click(String element){
        appiumDriver.findElement(By.id(element)).click();



    }

    @Step("<second> sn bekle")
    public void waitForsecond(int second) throws InterruptedException {
        Thread.sleep(1000*second);
    }

    @Step("<id> idi elemente <text> text gonder")
    public void sendKeys(String id,String text) {
        appiumDriver.findElement(By.id(id)).sendKeys(text);
        MobileElement element = appiumDriver.findElement(By.id(id));
        element.click();
        System.out.println(element+"elemente tıklandı");
    }

    @Step("<element> elemente xpath ile tıkla")
    public void clickXpath(String element) {
        appiumDriver.findElement(By.xpath(element)).click();
        MobileElement element = appiumDriver.findElement(By.xpath(xpath));
        element.sendKeys(key);
        System.out.println(element+"elemente tıklandı");


    }
}
