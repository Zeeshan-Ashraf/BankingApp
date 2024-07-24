package com.github.zeeshan_ashraf.Banking.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //diff between @Controller & @RestController https://docs.google.com/document/d/1ZnLDtYnOusA60QuJJqPW5_LWRniHgn4M03xa9C9lIT4/edit#heading=h.am23tre0nlqg
public class AccountController {

    @Value("${HOME}")  //even if HOME is declared in properties or yml file it'll pick from system env var
    private String home;

    @Value("${grandparent.parent.child}") //gets data from application.yml
    private String childValue;

    @Value("${grandparent.parent.child2}")
    private String child2Value;

    @Value("${zee.region}")
    private String region;

    @Value("${grandparent.parent.child3}") //will be picked from application.properties file instead of application.yml. so precedence of .properties > .yml
    private String child3Value;

    @Value("${value.doesnt.exists:the_default_value also with space}") //when value doesn't exists in env nor in properties nor in yml file
    private String defaultValue;

    @Value("${planets}")
    private List<String> planets;  // converts comma seperated to list (but not space seperated) [mercury, venus, earth, mars and jupiter]

    @GetMapping("/configuration-values")
    public String createAccount() {
        return home + "#" + childValue + "#" + child2Value + "#" + child3Value + "#" + region + "#" + planets + "#" + defaultValue;
    }
}
