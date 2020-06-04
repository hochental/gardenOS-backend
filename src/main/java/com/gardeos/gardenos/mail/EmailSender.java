package com.gardeos.gardenos.mail;

import org.springframework.stereotype.Repository;

@Repository
public interface EmailSender {
    void sendEmail(String to, String subject, String content);
}
