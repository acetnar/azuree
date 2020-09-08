package pl.sda.final_project;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import pl.sda.final_project.repository.UserRolesRepository;

@Component
public class DataSeed implements InitializingBean {

    private UserRolesRepository userRolesRepository;

    public DataSeed(UserRolesRepository userRolesRepository) {
        this.userRolesRepository = userRolesRepository;
    }

    @Override
    public void afterPropertiesSet() {
        createRole(UserRole.Roles.ADMIN);
        createRole(UserRole.Roles.USER);
    }

    private void createRole(UserRole.Roles role) {
        if (!userRolesRepository.roleExists(role.name())) {
            userRolesRepository.save(UserRole.apply(role));
        }
    }
}
