package practice03;

import com.github.javafaker.Faker;

public class C03_Faker {
    public static void main(String[] args) {
        Faker faker = new Faker();
        System.out.println(faker.name().firstName());
        System.out.println(faker.name().lastName());
        System.out.println(faker.internet().emailAddress());
        System.out.println(faker.address().fullAddress());
        System.out.println(faker.address().country());
        System.out.println(faker.internet().password());
        System.out.println(faker.internet().password(8,12,true,true));

    }

}
