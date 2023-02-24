package utils;

import com.codeborne.selenide.Configuration;

public class WebDriverFactory {
    public void GetDriver(String name){
        if("FIREFOX".equalsIgnoreCase(name)){
            Configuration.browser = "firefox";
        } else{
            Configuration.browser = "Chrome";
        }
        Configuration.browserSize = "1400x900";
    }
}
