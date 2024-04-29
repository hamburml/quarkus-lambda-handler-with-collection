package de.hamburml.quarkus.aws.lambda.working;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.inject.Inject;


public abstract class HandleRequestCollectionHelper<INPUT_TYPE, OUTPUT_TYPE> implements RequestHandler<Object, OUTPUT_TYPE> {
    @Inject
    ObjectMapper objectMapper;

    @Override
    public OUTPUT_TYPE handleRequest(Object input, Context context) {
        INPUT_TYPE convertedInput = objectMapper.convertValue(input, this.getCollectionReference());
        this.handle(convertedInput, context);
        return null;
    }

    public abstract TypeReference<INPUT_TYPE> getCollectionReference();

    public abstract OUTPUT_TYPE handle(INPUT_TYPE input, Context context);

}
