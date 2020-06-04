package com.gardeos.gardenos.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@RestController
public class EmailController {

    private final EmailSender emailSender;
    private final TemplateEngine templateEngine;

    @Autowired
    public EmailController(EmailSender emailSender,
                           TemplateEngine templateEngine) {
        this.emailSender = emailSender;
        this.templateEngine = templateEngine;
    }

    @RequestMapping("/email")
    public String send() {
        Context context = new Context();
        context.setVariable("header", "NAGLOWEK");
        context.setVariable("title", "TYTUL");
        context.setVariable("description", "ciag dalszy");
        String body = templateEngine.process("template", context);
        emailSender.sendEmail("labiwo3094@psk3n.com", "testowy email", body); //temp mail
        return "ok";
    }
}
