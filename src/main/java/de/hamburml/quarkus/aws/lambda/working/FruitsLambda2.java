package de.hamburml.quarkus.aws.lambda.working;

import com.amazonaws.services.lambda.runtime.Context;
import com.fasterxml.jackson.core.type.TypeReference;
import de.hamburml.quarkus.aws.lambda.Fruit;
import io.quarkus.logging.Log;
import jakarta.inject.Named;

import java.util.List;

@Named("fruit2")
public class FruitsLambda2 extends HandleRequestCollectionHelper<List<Fruit>, Void> {

    @Override
    public TypeReference<List<Fruit>> getCollectionReference() {
        return new TypeReference<>() { };
    }

    @Override
    public Void handle(List<Fruit> input, Context context) {
        input.forEach(this::printName);
        return null;
    }

    private void printName(Fruit fruit) {
        Log.info(fruit.name());
        Log.info(fruit.description());
    }
}
