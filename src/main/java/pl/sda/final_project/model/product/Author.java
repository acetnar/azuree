package pl.sda.final_project.model.product;

import pl.sda.final_project.model.user.BaseEntity;

import javax.persistence.Entity;

@Entity
public class AuthorEntity extends BaseEntity {

    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
