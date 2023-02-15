public class UserBuilder
{
    final String name;
    int age;
    String phone;
    String address;

    public UserBuilder(String name) {

        this.name = name;
    }
    public UserBuilder age(int age) {
        this.age = age;
        return this;
    }
    public UserBuilder phone(String phone) {
        this.phone = phone;
        return this;
    }
    public UserBuilder address(String address) {
        this.address = address;
        return this;
    }

    public User build() {
        User user =  new User(this);
        return user;
    }

}
