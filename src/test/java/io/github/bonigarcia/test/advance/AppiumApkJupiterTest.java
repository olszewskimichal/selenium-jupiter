/*
 * (C) Copyright 2017 Boni Garcia (http://bonigarcia.github.io/)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package io.github.bonigarcia.test.advance;

//tag::snippet-in-doc[]
import java.io.File;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.github.bonigarcia.DriverCapabilities;
import io.github.bonigarcia.SeleniumExtension;

@ExtendWith(SeleniumExtension.class)
public class AppiumApkJupiterTest {

    @DriverCapabilities
    DesiredCapabilities capabilities = new DesiredCapabilities();
    {
        try {
            File apk = new File(this.getClass()
                    .getResource("/selendroid-test-app.apk").toURI());
            capabilities.setCapability("app", apk.getAbsolutePath());
            capabilities.setCapability("deviceName", "Android");

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @Disabled("Android emulator not available on Travis CI")
    @Test
    void testWithAndroid(AppiumDriver<MobileElement> android)
            throws InterruptedException {
        WebElement button = android.findElement(By.id("buttonStartWebview"));
        button.click();

        WebElement inputField = android.findElement(By.id("name_input"));
        inputField.clear();
        inputField.sendKeys("Custom name");
    }

}
// end::snippet-in-doc[]