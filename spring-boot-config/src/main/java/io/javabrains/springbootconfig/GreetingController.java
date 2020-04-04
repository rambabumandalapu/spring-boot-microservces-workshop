package io.javabrains.springbootconfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class GreetingController {

    @Value("${my.greeting}")
    private String greetingMessage;

    @Value("static message")
    private String staticMessage;

    @Value("${my.greeting.default: default value}")
    private String greetingDefaultMessage;

    @Value("${my.list.values}")
    private List<String> listValues;

    @Value("#{${dbValues}}")
    private Map<String, String> dbValue;


    @RequestMapping("/greeting")
    public String greeting() {
        return String.join(" : ",
                greetingMessage,
                staticMessage,
                greetingDefaultMessage,
                listValues.toString(),
                dbValue.toString());
    }
}
