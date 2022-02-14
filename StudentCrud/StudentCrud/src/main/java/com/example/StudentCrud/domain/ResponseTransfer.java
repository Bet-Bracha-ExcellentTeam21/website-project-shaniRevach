package com.example.StudentCrud.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


/**
 * Response for requests.
 */
@AllArgsConstructor
@Getter
@Setter
public class ResponseTransfer {
    private String message; //The message of the response.

}
