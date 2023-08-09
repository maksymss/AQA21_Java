package models;

import lombok.*;

@Builder
@ToString
@EqualsAndHashCode
public class UserBuilder {
    private int id;
    private String username;
    private String password;
    private String email;
    private String code;


}
