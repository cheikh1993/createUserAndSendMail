package com.example.User_add.service;

import com.example.User_add.Entity.UserEntity;
import com.example.User_add.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailService emailService;

    @Override
    public UserEntity addUser(UserEntity user) {
        String defaultPassword = generatePassword();
        user.setPassword(defaultPassword);

        // Envoyer un mail a l'utilisateur

        String message = "Bienvenue!\nVotre login: "  + user.getEmail() + " \nVotre mot de passe:"  + defaultPassword;
    emailService.sendEmail(user.getEmail(), "FORCE-N", message);
        return userRepository.save(user);
    }

    @Override
    public UserEntity updateUser(UserEntity user) {
        String message = " votre mot de passe a ete modifie ," + user.getPassword();
        emailService.sendEmail(user.getEmail(), "Bienvenu dans votre systeme",message);
        return userRepository.save(user);
    }

    private String generatePassword() {
    return UUID.randomUUID().toString().substring(0, 8);
    }
}
