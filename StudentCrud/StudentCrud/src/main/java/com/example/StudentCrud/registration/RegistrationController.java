package com.example.StudentCrud.registration;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@AllArgsConstructor
public class RegistrationController {

    private RegistrationService registrationService;

    public String register(@RequestBody RegistrationRequest request) {
        return registrationService.register(request);
    }

}
