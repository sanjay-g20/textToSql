package com.texttosql.textToSql.controller;

import com.texttosql.textToSql.util.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.swing.plaf.synth.SynthTabbedPaneUI;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public String login(@RequestBody AuthRequest authRequest) {
        System.out.println("authRequest:"+authRequest.getUsername()+ authRequest.getPassword());

        try{
            //Uncomment below to check the encoded value/password
//            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//            String encodedPassword = encoder.encode("pwd3");
//            System.out.println("encodedPassword"+encodedPassword);
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        }catch (Exception e) {
            System.err.println("Error authRequest : " + e.getMessage());
            return null;
        }
        return jwtUtil.generateToken(authRequest.getUsername());
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(@RequestHeader("Authorization") String token) {
        // Extract token (strip "Bearer " prefix)
        String jwtToken = token.startsWith("Bearer ") ? token.substring(7) : token;

        // Optionally, add the token to a blacklist
        // blacklistService.addTokenToBlacklist(jwtToken);
        return ResponseEntity.ok("Logged out successfully");
    }
}

class AuthRequest {
    private String username;
    private String password;

    // Getters and setters

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
