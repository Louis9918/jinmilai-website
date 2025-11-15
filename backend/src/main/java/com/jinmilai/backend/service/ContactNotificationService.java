package com.jinmilai.backend.service;

import com.jinmilai.backend.dto.ContactRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class ContactNotificationService {

    private static final Logger log = LoggerFactory.getLogger(ContactNotificationService.class);

    private final JavaMailSender mailSender;
    private final String notifyTo;
    private final String fromAddress;
    private final String subjectPrefix;

    public ContactNotificationService(
            JavaMailSender mailSender,
            @Value("${jinmilai.contact.notify-to}") String notifyTo,
            @Value("${spring.mail.username}") String fromAddress,
            @Value("${jinmilai.contact.notify-subject-prefix:New contact from Jinmilai website}") String subjectPrefix
    ) {
        this.mailSender = mailSender;
        this.notifyTo = notifyTo;
        this.fromAddress = fromAddress;
        this.subjectPrefix = subjectPrefix;
    }

    /**
     * 发送通知邮件，成功返回 true，失败返回 false（失败时仅记录日志，不抛异常）
     */
    public boolean sendContactEmail(ContactRequest request) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();

            // 发件人与收件人可以是同一个，也可以分开配置
            message.setFrom(fromAddress);
            message.setTo(notifyTo);

            String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            String lang = request.getPreferredLanguage() == null ? "" : request.getPreferredLanguage().toUpperCase();

            String subject = subjectPrefix + " [" + now + "]";
            message.setSubject(subject);

            StringBuilder body = new StringBuilder();
            body.append("New contact message from Jinmilai website").append("\n\n");
            body.append("Time: ").append(now).append("\n");
            body.append("Preferred Language: ").append(lang).append("\n\n");
            body.append("Name: ").append(nullSafe(request.getName())).append("\n");
            body.append("Company: ").append(nullSafe(request.getCompany())).append("\n");
            body.append("Email: ").append(nullSafe(request.getEmail())).append("\n");
            body.append("Phone: ").append(nullSafe(request.getPhone())).append("\n");
            body.append("Message:\n").append(nullSafe(request.getMessage())).append("\n");

            message.setText(body.toString());

            mailSender.send(message);

            log.info("Contact notification email sent to {}", notifyTo);
            return true;
        } catch (Exception e) {
            log.error("Failed to send contact notification email", e);
            return false;
        }
    }

    private String nullSafe(String v) {
        return v == null ? "" : v;
    }
}
