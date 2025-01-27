package com.texttosql.textToSql.controller;

import javax.validation.Valid;

import com.texttosql.textToSql.model.AuthRequest;
import com.texttosql.textToSql.model.User;
import com.texttosql.textToSql.service.AuthService;
import com.texttosql.textToSql.util.JwtUtil;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final AuthService authService;

    public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil, AuthService authService) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.authService = authService;
    }

    @PostMapping("/signup")
    public ResponseEntity<String> createUser(
            @Valid
            @RequestBody
            User input) {
        return authService.createUser(input);
    }

    @PostMapping("/login")
    public String login(
            @RequestBody
            AuthRequest authRequest) {
        try {
            //Uncomment below to check the encoded value/password
            //            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            //            String encodedPassword = encoder.encode("pwd3");
            //            System.out.println("encodedPassword"+encodedPassword);
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        } catch (Exception e) {
            System.err.println("Error authRequest : " + e.getMessage());
            return null;
        }
        return jwtUtil.generateToken(authRequest.getUsername());
    }

/*    @PostMapping("/logout")
    public ResponseEntity<String> logout(@RequestHeader("Authorization")  String token) {
        // Extract token (strip "Bearer " prefix)
        String jwtToken = token.startsWith("Bearer ") ? token.substring(7) : token;
        // Optionally, add the token to a blacklist
        //blacklistService.addTokenToBlacklist(jwtToken);
        return ResponseEntity.ok("Logged out successfully");
    }*/
}
