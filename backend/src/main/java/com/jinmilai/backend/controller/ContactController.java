package com.jinmilai.backend.controller;

import com.jinmilai.backend.dto.ContactRequest;
import com.jinmilai.backend.dto.ContactResponse;
import com.jinmilai.backend.service.ContactNotificationService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contact")
public class ContactController {

    private static final Logger log = LoggerFactory.getLogger(ContactController.class);

    private final ContactNotificationService contactNotificationService;

    public ContactController(ContactNotificationService contactNotificationService) {
        this.contactNotificationService = contactNotificationService;
    }

    @PostMapping
    public ResponseEntity<ContactResponse> submitContact(
            @Valid @RequestBody ContactRequest request,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            String errorMsg = bindingResult.getAllErrors().get(0).getDefaultMessage();
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(ContactResponse.fail(errorMsg));
        }

        log.info("New contact message from website: name={}, company={}, email={}, phone={}, lang={}",
                request.getName(),
                request.getCompany(),
                request.getEmail(),
                request.getPhone(),
                request.getPreferredLanguage());

        boolean emailSent = contactNotificationService.sendContactEmail(request);

        String okMsg;
        if (emailSent) {
            okMsg = "Contact message received and notification email sent";
        } else {
            okMsg = "Contact message received, but failed to send notification email";
        }

        return ResponseEntity.ok(ContactResponse.ok(okMsg));
    }
}
