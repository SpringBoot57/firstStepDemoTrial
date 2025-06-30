package com.example.posttracking.service.impl;

import com.example.posttracking.dto.AuthResponse;
import com.example.posttracking.dto.LoginRequest;
import com.example.posttracking.dto.RegisterRequest;
import com.example.posttracking.model.Role;
import com.example.posttracking.model.User;
import com.example.posttracking.repository.RoleRepository;
import com.example.posttracking.repository.UserRepository;
import com.example.posttracking.service.AuthService;
import com.example.posttracking.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @Override
    public AuthResponse login(LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtUtil.generateToken(authentication.getName());
        return new AuthResponse(token);
    }

    @Override
    public void register(RegisterRequest request) {
        Role role = roleRepository.findByName(request.getRole());
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(role);
        userRepository.save(user);
    }
}
