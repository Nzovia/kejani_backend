package com.example.kejani_backend.Usermanagement.services;

import com.example.kejani_backend.Usermanagement.entities.HouseOwner;
import com.example.kejani_backend.Usermanagement.repositories.UserManagementRepository;
import lombok.val;
import org.hibernate.annotations.NotFound;
import org.springframework.stereotype.Service;

@Service
public class UserManagementService {
    private final UserManagementRepository userManagementRepository;

    public UserManagementService(UserManagementRepository userManagementRepository) {
        this.userManagementRepository = userManagementRepository;
    }

    //create user
    public void save(HouseOwner houseOwner) {
//        var emailExists = userManagementRepository.findByEmail(houseOwner.getEmail());
//        var mobileNumberExists = userManagementRepository.findByMobileNumber(houseOwner.getMobileNumber());

        //TODO: validate whether user email and mobileNumber are already taken

        if(houseOwner.getMobileNumber().length() != 10){
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
