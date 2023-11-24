package com.example.employeetraining.service.email;


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.task.TaskExecutor;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;

@Component("emailSender")
@Slf4j
public class EmailSender {

    private final JavaMailSenderImpl javaMailSender;
    private final TaskExecutor taskExecutor;

    @Value("${spring.mail.sender.name}")
    private String senderName;

    @Value("${spring.mail.sender.email}")
    private String senderEmail;

    public EmailSender(JavaMailSenderImpl javaMailSender, @Qualifier("taskExecutor") TaskExecutor taskExecutor) {
        this.javaMailSender = javaMailSender;
        this.taskExecutor = taskExecutor;
    }

    public boolean send(String email, String subject, String message) {
        return send(null, email, subject, message);
    }

    public boolean send(String from, String email, String subject, String message) {
        MimeMessage mime = javaMailSender.createMimeMessage();
        if (StringUtils.isEmpty(from)) {
            from = senderEmail;
        }
        if (StringUtils.isEmpty(from)) {
            from = "admin@mail.com";
        }

        boolean isSuccess = false;
        try {
            log.info("Sending email to: {}", email);
            log.info("Sending email from: {}", from);
            log.info("Sending email with subject: {}", subject);

            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mime, true);
            mimeMessageHelper.setFrom(from, senderName);
            mimeMessageHelper.setTo(email);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(message, true);
            javaMailSender.send(mime);
            log.info("Successfully sent message to {}", email);
            isSuccess = true;
        } catch (Exception exception) {
            log.error("Error sending email", exception);
        }

        return isSuccess;
    }

    public void sendAsync(final String to, final String subject, final String message) {
        taskExecutor.execute(() -> send(to, subject, message));
    }
}
