package com.irojas.demojwt.EndpointsApp;

import com.irojas.demojwt.DTO.UserInfoDTO;
import com.irojas.demojwt.DTO.UserPaymentInfoDTO;
import com.irojas.demojwt.Models.Profile;
import com.irojas.demojwt.Services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/addProfile/{id_user}") // is working fine, theres a problem when i want to access to profiles from user, i cant get it.
    public ResponseEntity<Boolean> addProfile(
            @PathVariable Integer id_user,
            @RequestBody Profile profile) {
        return ResponseEntity.ok(userService.addProfile(profile, id_user));
    }

    @GetMapping("/infoUser/{id_user}")  // is working good
    public ResponseEntity<UserInfoDTO> getUserInfo(@PathVariable Integer id_user) {
        return ResponseEntity.ok(userService.getUserInfo(id_user));
    }

    @DeleteMapping("/deleteProfile/{id_profile}")
    public ResponseEntity<Boolean> deleteProfile(@PathVariable Integer id_profile) {
        return ResponseEntity.ok(userService.deleteProfile(id_profile));
    }

    @DeleteMapping("/deleteUser/{id_user}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable Integer id_user) {
        return ResponseEntity.ok(userService.deleteUser(id_user));
    }

    @GetMapping("/infoPayment/{id_user}") //is working good
    public ResponseEntity<UserPaymentInfoDTO> getPaymentInfo(@PathVariable Integer id_user) {
        return ResponseEntity.ok(userService.getPaymenteInfo(id_user));
    }

    @GetMapping("/getProfiles/{id_user}")
    public ResponseEntity<List<Profile>> getProfiles(@PathVariable Integer id_user) {
        return ResponseEntity.ok(userService.getProfiles(id_user));
    }

}
