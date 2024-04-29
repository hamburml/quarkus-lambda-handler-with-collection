package de.hamburml.quarkus.aws.lambda.notworking;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import de.hamburml.quarkus.aws.lambda.Fruit;
import io.quarkus.logging.Log;
import jakarta.inject.Named;

import java.util.List;

@Named("fruit")
public class FruitsLambda implements RequestHandler<List<Fruit>, Void> {

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
