package com.example.testrabbitmq02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SimpleController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    AmqpTemplate template;

    @ResponseBody
    @RequestMapping("/emit") //испускать
    String queue1() {
        log.info("Emit to queue");
        for(int i = 0;i<10;i++) {
            template.convertAndSend("query-example-2", "Message " + i);
        }
        return "Emit to queue";
    }
}
