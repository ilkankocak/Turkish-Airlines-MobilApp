package org.example;

import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    protected static AppiumDriver<MobileElement> appiumDriver;
    protected boolean localAndroid = true;

    @BeforeScenario
    public void setUp() throws MalformedURLException {

        // JSON Representation Kısmı dün çalıştığı halde bugun hata verdi. Json Representation kısmı bir türlü ayağa kaldıralamadı.
        // Yardım aldıgım halde ekran kısmı patladı hata vermeyen kodlar hata vermeye başladı.
        // Sistem'de birçok kod hata verdi toparlaya bildiğim kadar süre içerisinde toparladım.

        if (localAndroid){
            System.out.println("Android testi başlıyor");
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
            desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"com.turkishairlines.mobile.ui.ACSplash");
            desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"com.turkishairlines.mobile");
            desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,3000);
            URL url = new URL("http://127.0.0.1:4723/wd/hub");
            appiumDriver = new AndroidDriver(url,desiredCapabilities);

        }else {
            System.out.println("android testi başlıyor");
        }

    }

    @AfterScenario
    public void afterSenaryo(){
        appiumDriver.quit();
    }












}
