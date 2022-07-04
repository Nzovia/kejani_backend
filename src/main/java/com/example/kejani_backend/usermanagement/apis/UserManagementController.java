package com.example.kejani_backend.usermanagement.apis;
import com.example.kejani_backend.payload.UserProfileReq;
import com.example.kejani_backend.usermanagement.entities.HouseOwner;
import com.example.kejani_backend.usermanagement.services.UserManagementService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserManagementController {
    
    private final UserManagementService userManagementService;

    public UserManagementController(UserManagementService userManagementService) {
        this.userManagementService = userManagementService;
    }

    //UserCreation api
    @PostMapping("/registration")
    public void createUser(@RequestBody HouseOwner houseOwner){
        userManagementService.save(houseOwner);
    }

    //fetching single userDetails api
    @GetMapping("/profile/{id}")
    public HouseOwner getSingleHouseOwner(@PathVariable Long id, UserProfileReq profile){
        return userManagementService.showUserDetails(id);
    }

    //deleting users api
    @DeleteMapping("/deleteAccount/{id}")
    public void deletingUserAccount(@PathVariable Long id){
        userManagementService.deleteAccount(id);
    }

    //update users api
    @PutMapping
    public HouseOwner updateProfile(@RequestBody HouseOwner houseOwner){
        return userManagementService.updateProfile(houseOwner);
    }
}
