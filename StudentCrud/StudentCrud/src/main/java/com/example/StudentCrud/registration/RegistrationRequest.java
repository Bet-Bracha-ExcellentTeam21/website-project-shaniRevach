package com.example.StudentCrud.registration;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
/**
 * The all variables of new user for register request.
 */
public class RegistrationRequest {

    private final String firstName; //The first name on the register request of the new user.
    private final String lastName; //The last name on the register request of the new user.
    private final String email; //The email on the register request of the new user.
    private final String password; //The password on the register request of the new user.
}
