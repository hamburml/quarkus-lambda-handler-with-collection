package de.hamburml.quarkus.aws.lambda.working;

import io.quarkus.test.junit.QuarkusTestProfile;

import java.util.Collections;
import java.util.Map;

public class FruitsLambda2Profile implements QuarkusTestProfile {
    @Override
    public Map<String, String> getConfigOverrides() {
        return Collections.singletonMap("quarkus.lambda.handler","fruit2");
    }
}
