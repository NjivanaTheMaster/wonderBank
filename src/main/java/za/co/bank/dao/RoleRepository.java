package za.co.bank.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.bank.model.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByName(String name);
}
