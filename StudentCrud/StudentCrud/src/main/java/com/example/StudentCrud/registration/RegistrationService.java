package com.example.StudentCrud.registration;

import com.example.StudentCrud.user.User;
import com.example.StudentCrud.user.UserRole;
import com.example.StudentCrud.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.apache.commons.validator.routines.EmailValidator;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final UserService userService;

    public String register(RegistrationRequest request) {
        boolean isValidEmail = EmailValidator.getInstance().isValid(request.getEmail());
        if (!isValidEmail){
            throw new IllegalStateException("Wrong email");
        }
        return userService.singUp(new User(
                request.getFirstName(),
                request.getLastName(),
                request.getEmail(),
                request.getPassword(),
                UserRole.USER ));
    }
}
