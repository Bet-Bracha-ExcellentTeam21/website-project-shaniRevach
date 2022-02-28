package com.example.StudentCrud.registration;

import com.example.StudentCrud.user.User;
import com.example.StudentCrud.user.UserRole;
import com.example.StudentCrud.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.apache.commons.validator.routines.EmailValidator;

/**
 * The services of the registration.
 */
@Service
@AllArgsConstructor
public class RegistrationService {

    private final UserService userService; //The services of the user.

    /**
     * The function get a request to register from the controller, validate the email,
     * and add the new user to the user's table.
     * @param registrationRequest Request from the user to register.
     * @return Message if the registration succeed.
     */
    public String register(RegistrationRequest registrationRequest) {
        boolean isValidEmail = EmailValidator.getInstance().isValid(registrationRequest.getEmail());
        if (!isValidEmail){
            throw new IllegalStateException("Wrong email");
        }
        return userService.singUp(new User(
                registrationRequest.getFirstName(),
                registrationRequest.getLastName(),
                registrationRequest.getEmail(),
                registrationRequest.getPassword(),
                UserRole.USER ));
    }
}
