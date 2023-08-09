package models;

import lombok.*;
import org.testng.annotations.Test;

import java.util.Objects;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class User {
    @EqualsAndHashCode.Exclude
    private int id;

    @NonNull
    private String username;
    @NonNull
    private String password;
    private String email;

    //@ToString.Exclude
    private String code;


}
