package com.fstg.gymspringproject.Services;


import com.fstg.gymspringproject.Entity.User;
import com.fstg.gymspringproject.Entity.Role;
import com.fstg.gymspringproject.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    // Injection de dépendance via le constructeur
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Méthode pour récupérer un utilisateur par email
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    // Méthode pour récupérer un utilisateur par son identifiant
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Méthode pour ajouter ou mettre à jour un utilisateur
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // Méthode pour supprimer un utilisateur
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    // Méthode pour vérifier si un utilisateur existe par email
    public boolean existsByEmail(String email) {
        return userRepository.findByEmail(email).isPresent();
    }


}
