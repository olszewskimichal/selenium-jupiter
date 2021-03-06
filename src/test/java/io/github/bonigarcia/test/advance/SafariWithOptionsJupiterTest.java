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
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.DriverOptions;
import io.github.bonigarcia.Option;
import io.github.bonigarcia.SeleniumExtension;

@ExtendWith(SeleniumExtension.class)
public class SafariWithOptionsJupiterTest {

    @Disabled("SafariDriver requires Safari 10 running on OSX El Capitan or greater.")
    @Test
    public void safariTest(@DriverOptions(options = {
            @Option(name = "useCleanSession", value = "true"),
            @Option(name = "useTechnologyPreview", value = "false") }) SafariDriver safari) {
        safari.get(
                "https://webrtc.github.io/samples/src/content/devices/input-output/");
    }

}
// end::snippet-in-doc[]