package pl.sda.final_project;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.sda.final_project.dto.RegistrationDto;
import pl.sda.final_project.repository.UserRepository;
import pl.sda.final_project.repository.UserRolesRepository;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserRolesRepository userRolesRepository;
    private final PasswordEncoder passwordEncoder;


    public UserService(UserRepository userRepository, UserRolesRepository userRolesRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userRolesRepository = userRolesRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(RegistrationDto registrationDto) {
        String passEncode = passwordEncoder.encode(registrationDto.getPassword());
        if (userWithEmailExists(registrationDto.getLogin())) {
            throw new RuntimeException("Użytkownik o emailu " + registrationDto.getLogin() + " istnieje");
        }
        User userToSave = User.apply(registrationDto, passEncode);
        userToSave.addRole(userRolesRepository.findByRoleName(UserRole.Roles.USER.name()));
        userRepository.save(userToSave);
    }

    private boolean userWithEmailExists(String login) {
        return userRepository.existsByLogin(login);
    }

}
