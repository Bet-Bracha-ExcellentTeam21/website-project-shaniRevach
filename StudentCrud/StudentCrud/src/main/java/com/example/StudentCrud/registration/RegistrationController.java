package com.example.StudentCrud.registration;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The registration controller.
 */
@AllArgsConstructor
@RestController
@RequestMapping("api/v1/registration")
public class RegistrationController {

    private RegistrationService registrationService; //The registration service.

    /**
     * The function get a request from the user to register, and add the new user to the user's table.
     * @param registrationRequest Request from the user to register.
     * @return Message if the registration succeed.
     */
    @PostMapping
    public String register(@RequestBody RegistrationRequest registrationRequest) {
        return registrationService.register(registrationRequest);
    }
}