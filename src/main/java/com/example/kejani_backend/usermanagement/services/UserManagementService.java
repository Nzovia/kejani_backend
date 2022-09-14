package com.example.kejani_backend.usermanagement.services;

import com.example.kejani_backend.usermanagement.entities.HouseOwner;
import com.example.kejani_backend.usermanagement.repositories.UserManagementRepository;
import com.example.kejani_backend.valiadations.EmailValidation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class UserManagementService {
    private final UserManagementRepository userManagementRepository;

    public UserManagementService(UserManagementRepository userManagementRepository) {
        this.userManagementRepository = userManagementRepository;
    }

    //create user
    public ResponseEntity<?> save(HouseOwner houseOwner) {
        var emailAddress = houseOwner.getEmail();
        var phoneNumber = houseOwner.getMobileNumber();
        var validationPattern = "^(.+)@(\\S+)$";
        EmailValidation emailValidation = new EmailValidation();
        //check if the email is valid format
        if (emailValidation.patternMatches(emailAddress, validationPattern) == false) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Enter valid email");
        }
        //check if the email and mobile number exists
        Optional<HouseOwner> emailExists = userManagementRepository.findByEmail(emailAddress);
        Optional<HouseOwner> phoneNumberExists = userManagementRepository.findByMobileNumber(phoneNumber);
        if (emailExists.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The email is already taken");
        }
        if (phoneNumberExists.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "the phone number is taken");
        }
        if (phoneNumber.length() != 10) {
            throw new IllegalArgumentException("Digits less than 10");
        }

        var pass1 = houseOwner.getPassword();
        var pass2 = houseOwner.getConfirmPassword();

        if (!pass1.equals(pass2)) {
            throw new IllegalArgumentException("There is password mismatch");
        }

        return new ResponseEntity(userManagementRepository.save(houseOwner), HttpStatus.OK);
    }

    public HouseOwner showUserDetails(Long id) {
        return userManagementRepository.findById(id).orElse(null);
    }

    //delete user profile
    public void deleteAccount(Long id) {
        userManagementRepository.deleteById(id);
    }

    //updating user profile
    public HouseOwner updateProfile(HouseOwner houseOwner) {
        HouseOwner userExists = userManagementRepository.findById(houseOwner.getUserId()).orElse(null);
        userExists.setUserName(houseOwner.getUserName());
        userExists.setEmail(houseOwner.getEmail());
        userExists.setMobileNumber(houseOwner.getMobileNumber());

        //save userExists object to Reset
        return userManagementRepository.save(userExists);
    }


}
