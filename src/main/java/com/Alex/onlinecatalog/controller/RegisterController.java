package com.Alex.onlinecatalog.controller;

import com.Alex.onlinecatalog.model.PendingUser;
import com.Alex.onlinecatalog.model.User;
import com.Alex.onlinecatalog.repository.PendingUserRepository;
import com.Alex.onlinecatalog.repository.UserRepository;
import com.Alex.onlinecatalog.service.RandomStringGenerator;
import com.Alex.onlinecatalog.service.SendGridEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class RegisterController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PendingUserRepository pendingUserRepository;

    @Autowired
    private RandomStringGenerator randomStringGenerator;

    @Autowired
    private SendGridEmailService sendGridEmailService;

    @GetMapping("/register")
    public String registerUser() {
        return "security/register";
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @PostMapping("/register")
    public String registerUser(String username, String password, String emailAddress) {
        User user = new User();
        user.setEmailAddress(emailAddress);
        user.setUsername(username);
        user.setPassword(encoder().encode(password));
        //userRepository.save(user);
        userRepository.save(user);


        PendingUser pendingUser = new PendingUser();
        String activationCode = randomStringGenerator.getAlphaNumericString(20);
        pendingUser.setActivationCode(activationCode);
        sendGridEmailService.sendHTML("alex.m.duma@gmail.com", user.getEmailAddress(), "Please confirm account",
                randomStringGenerator.linkCreator(activationCode, "https://online-school-catalog-ad.herokuapp.com"));
        pendingUser.setUser(user);
        pendingUserRepository.save(pendingUser);

        return "redirect:/login";
    }
    @GetMapping("/userValidation")
    public String validateUser(String activationCode) {
        System.out.println(activationCode);
        Optional<PendingUser> optionalPendingUser = pendingUserRepository.findByActivationCode(activationCode);
        if(optionalPendingUser.isPresent()){
            PendingUser pendingUser = optionalPendingUser.get();
            System.out.println(pendingUser.getActivationCode());
            //userRepository.save(pendingUser.getUser());
            pendingUserRepository.delete(pendingUser);
        }
        return "security/login";
    }
}
