package tests;

import helper_hw.DataHelper;
import lombok.ToString;
import models.User;
import models.UserBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LombokTest {
    @Test
    public void toStringTest() {
        User user = DataHelper.getUser();
        System.out.println(user.toString());
    }
    @Test
    public void equalsTest() {
        User user1 = DataHelper.getUser();
        user1.setId(1);
        User user2 = DataHelper.getUser();
        user2.setId(2);
        System.out.println(user1);
        System.out.println(user2);
        Assert.assertTrue(user1.equals(user2));
    }
    @Test
    public void constructorTest() {
        User user = new User(1, "Maksym", "12345", "maksym@email.com", "123");
        User user1 = new User("Maksym", "12345");

        System.out.println(user);
        System.out.println(user1);
    }
    @Test
    public void builderTest() {
        UserBuilder user = UserBuilder.builder()
                .id(1)
                .password("12345")
                .username("Maksym")
                .email("12123343")
                .code("1234")
                .build();

        UserBuilder user1 = UserBuilder.builder()
                .id(1)
                .password("12345")
                .username("Maksym")
                .email("12123343")
                .code("1234")
                .build();

        System.out.println(user);
        System.out.println(user1);

        Assert.assertTrue(user.equals(user1));
    }

}
