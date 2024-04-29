package de.hamburml.quarkus.aws.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import io.quarkus.logging.Log;

import java.util.List;

public class FruitsLambda2 implements RequestHandler<List<Fruit>, Void> {

    @Override
    public Void handleRequest(List<Fruit> fruit, Context context) {
        fruit.forEach(this::printName);
        return null;
    }

    private void printName(Fruit fruit) {
        Log.info(fruit.name());
        Log.info(fruit.description());
    }
}
