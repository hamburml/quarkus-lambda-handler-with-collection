package de.hamburml.quarkus.aws.lambda.notworking;

import io.quarkus.test.junit.QuarkusTestProfile;

import java.util.Collections;
import java.util.Map;

public class FruitsLambdaProfile implements QuarkusTestProfile {
    @Override
    public Map<String, String> getConfigOverrides() {
        return Collections.singletonMap("quarkus.lambda.handler","fruit");
    }
}
