package com.example.kejani_backend.Usermanagement.services;

import com.example.kejani_backend.Usermanagement.entities.HouseOwner;
import com.example.kejani_backend.Usermanagement.repositories.UserManagementRepository;
import com.example.kejani_backend.valiadations.EmailValidation;
import lombok.val;
import org.hibernate.annotations.NotFound;
import org.springframework.http.HttpStatus;
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
    public void save(HouseOwner houseOwner) {
        var emailAddress = houseOwner.getEmail();
        var phoneNumber = houseOwner.getMobileNumber();
        var validationPattern = "^(.+)@(\\S+)$";
        EmailValidation emailValidation = new EmailValidation();
        //check if the email is valid format
        if (emailValidation.patternMatches(emailAddress,validationPattern ) == true){

            //check if the email and mobile number exists
            Optional<HouseOwner> emailExists = userManagementRepository.findByEmail(emailAddress);
            Optional<HouseOwner> phoneNumberExists = userManagementRepository.findByMobileNumber(phoneNumber);
            if(emailExists.isPresent()){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The email is already take");
            }
            if(phoneNumberExists.isPresent()){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "the phone number is taken");
            }
        }
        if(phoneNumber.length() != 10){
            throw  new IllegalArgumentException("Digits less than 10");
        }else{
            userManagementRepository.save(houseOwner);
        }
    }

    public HouseOwner showUserDetails(Long id) {
        return userManagementRepository.findById(id).orElse(null);
    }

    //delete user profile
    public void deleteAccount(Long id){
        userManagementRepository.deleteById(id);
    }

    //updating user profile
    public HouseOwner updateProfile(HouseOwner houseOwner){
        HouseOwner userExists = userManagementRepository.findById(houseOwner.getUserId()).orElse(null);
        userExists.setUserName(houseOwner.getUserName());
        userExists.setEmail(houseOwner.getEmail());
        userExists.setMobileNumber(houseOwner.getMobileNumber());

        //save userExists object to Reset
        return userManagementRepository.save(userExists);
    }


}
