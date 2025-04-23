package com.irojas.demojwt.Services;

import com.irojas.demojwt.DTO.UserInfoDTO;
import com.irojas.demojwt.DTO.UserPaymentInfoDTO;
import com.irojas.demojwt.Models.Profile;
import com.irojas.demojwt.Models.User;
import com.irojas.demojwt.Repositories.ProfileRep;
import com.irojas.demojwt.Repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final ProfileRep profileRep;
    private static final int maxProfiles = 4;

    public UserService(UserRepository userRepository, ProfileRep profileRep) {
        this.userRepository = userRepository;
        this.profileRep = profileRep;
    }

    public Boolean addProfile(Profile profile, Integer id_user) {
        Optional<User> user = userRepository.findById(id_user);

        if (user.isPresent()) {
            User currentUser = user.get();

            if (currentUser.getProfiles().size() < maxProfiles) {
                // Asociamos el perfil al usuario
                profile.setUser(currentUser);
                currentUser.getProfiles().add(profile);

                // Guardamos el usuario y el perfil
                userRepository.save(currentUser);
                profileRep.save(profile);

                System.out.println("Perfil agregado correctamente.");
                return true;
            } else {
                System.out.println("No se puede agregar más perfiles, el límite ha sido alcanzado.");
            }
        } else {
            System.out.println("Usuario no encontrado.");
        }

        System.out.println("user not found");

        return false;
    }

    public UserInfoDTO getUserInfo(Integer idUser) {
        Optional<User> user = userRepository.findById(idUser);

        if(user.isPresent()){
            User currentUser = user.get();
            UserInfoDTO userInfoDTO = new UserInfoDTO();

            userInfoDTO.setEmail(currentUser.getEmail());
            userInfoDTO.setUsername(currentUser.getUsername());
            userInfoDTO.setLastName(currentUser.getLastname());
            userInfoDTO.setFirstName(currentUser.getFirstname());

            System.out.println("dto is ready");

            // user info and user paymente is separted because at front its split in two different pages

            return userInfoDTO;
        }

        System.out.println("user not found");

        return null;
    }

    public Boolean deleteProfile(Integer idProfile) {
        Optional<User> user = userRepository.findById(idProfile);

        if(user.isPresent()){
            User currUser = user.get();

            if(!currUser.getProfiles().isEmpty()){
                for(Profile profile : currUser.getProfiles()){
                    if(Objects.equals(profile.getId_profile(), idProfile)){
                        currUser.getProfiles().remove(profile);
                        System.out.println("profile removed");
                        return true;
                    }
                }
            }
        }

        System.out.println("user not found");

        return false;
    }

    public Boolean deleteUser(Integer idUser) {
        Optional<User> user = userRepository.findById(idUser);

        // here we can save user info in another table just in casa the user would like to recover his account

        if(user.isPresent()){
            User currUser = user.get();
            userRepository.delete(currUser);
            System.out.println("user is deleted");
            return true;
        }

        System.out.println("user not found");

        return false;
    }

    public UserPaymentInfoDTO getPaymenteInfo(Integer idUser) {
        Optional<User> user = userRepository.findById(idUser);

        if(user.isPresent()){
            User currentUser = user.get();
            UserPaymentInfoDTO paymentInfoDTO = new UserPaymentInfoDTO();

            paymentInfoDTO.setCardNumber(currentUser.getCardNumber());
            paymentInfoDTO.setPlanType(currentUser.getPlanType());

            System.out.println("dto is ready");

            // user info and user paymente is separted because at front its split in two different pages

            return paymentInfoDTO;
        }

        System.out.println("user not found");

        return null;
    }


    public List<Profile> getProfiles(Integer idUser) {
        Optional<User> user = userRepository.findById(idUser);

        if(user.isPresent()){
            User currentUser = user.get();
            System.out.println(currentUser.getProfiles().get(0));
            return currentUser.getProfiles();
        }

        System.out.println("user not found");
        return null;

    }
}
