package com.example.StudentCrud.user;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * The services of the user
 */
@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository; //Repository for search exist users by email.
    private final BCryptPasswordEncoder bCryptPasswordEncoder; //Encodes passwords.

    /**
     * Search of exist user, if it's not exist throws an exception.
     * @param email The username of the user.
     * @return The user with the email that accepted.
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email).orElseThrow(() ->
                new UsernameNotFoundException(String.format("user with user name %s not found", email)));
    }

    /**
     * Add the new user to the table if the email isn't already exist, and after encoded the password.
     * @param user The new user.
     * @return "Welcome" massage if the register succeed.
     */
    public String singUp(User user){
        boolean userExist = userRepository.findByEmail(user.getEmail()).isPresent();
        if(userExist) {
            throw new IllegalStateException("Email already exist");
        }

        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);

        return "Welcome";
    }
}
