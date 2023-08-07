package models;

import baseEntities.BaseTest;
import pages.ProductsPage;

public class Project extends BaseTest {
    private String username;
    private String password;
    private boolean addProduct;
    private boolean shoppingCart;
    private boolean checkout;
    private String firstName;
    private String lastName;
    private String zipCode;
    private boolean submit;


    public static class Builder {
        private Project newProject;

        public Builder() {
            this.newProject = new Project();
        }

        public Builder withUsername(String username) {
            newProject.username = username;
            return this;
        }
        public Builder withPassword(String password) {
            newProject.password = password;
            return this;
        }
        public Builder withAddProduct(boolean addProduct) {
            newProject.addProduct = addProduct;
            return this;
        }
        public Builder withShoppingCart(boolean shoppingCart) {
            newProject.shoppingCart = shoppingCart;
            return this;
        }
        public Builder withCheckout(boolean checkout) {
            newProject.checkout = checkout;
            return this;
        }
        public Builder withFirstName(String firstName) {
            newProject.firstName = firstName;
            return this;
        }
        public Builder withLastName(String lastName) {
            newProject.lastName = lastName;
            return this;
        }
        public Builder withZipCode(String zipCode) {
            newProject.zipCode = zipCode;
            return this;
        }

        public Project build() {
            return newProject;
        }
    }
}
