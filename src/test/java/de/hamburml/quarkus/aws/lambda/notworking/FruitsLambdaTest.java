package de.hamburml.quarkus.aws.lambda.notworking;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.hamburml.quarkus.aws.lambda.Fruit;
import io.quarkus.test.junit.TestProfile;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

import java.util.LinkedList;
import java.util.List;

import static io.restassured.RestAssured.given;

@QuarkusTest
@TestProfile(FruitsLambdaProfile.class)
class FruitsLambdaTest {

    @Inject
    ObjectMapper objectMapper;

    @Test
    void testFruitsLambda() throws Exception {

        List<Fruit> fruits = new LinkedList<>();
        fruits.add(new Fruit("apple", "an apple a day..."));
        fruits.add(new Fruit("strawberry", "red fruit"));

        given()
                .body(objectMapper.writeValueAsString(fruits))
                .when()
                .post()
                .then()
                .statusCode(200);
    }

}
