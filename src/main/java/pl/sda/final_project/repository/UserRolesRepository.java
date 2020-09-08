package pl.sda.final_project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRolesRepository extends JpaRepository<UserRole, Long> {

    @Query("select case when count(u)> 0 then true else false end from UserRole u where lower(u.roleName) like lower(?1)")
    boolean roleExists(String name);

    @Query("select u from UserRole u where lower(u.roleName) = lower(?1)")
    UserRole findByRoleName(String roleName);
}
