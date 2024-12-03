package com.fstg.gymspringproject.Services;

import com.fstg.gymspringproject.Entity.Role;
import com.fstg.gymspringproject.Repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    // Créer un rôle
    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    // Trouver un rôle par son nom
    public Role findRoleByName(Role role) {
        return roleRepository.findByName(role)
                .orElseThrow(() -> new RuntimeException("Rôle non trouvé"));
    }
}


