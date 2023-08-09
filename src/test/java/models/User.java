package models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.testng.annotations.Test;

import java.util.Objects;

@Getter
@Setter
@ToString
public class User {
    private String username;
    private String password;
    private String email;
    private String code;

}
