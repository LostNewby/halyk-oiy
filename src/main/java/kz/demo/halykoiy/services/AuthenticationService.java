package kz.demo.halykoiy.services;


import kz.demo.halykoiy.models.JwtAuthenticationResponse;
import kz.demo.halykoiy.models.SignUpRequest;
import kz.demo.halykoiy.models.SigninRequest;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse signin(SigninRequest request);
}