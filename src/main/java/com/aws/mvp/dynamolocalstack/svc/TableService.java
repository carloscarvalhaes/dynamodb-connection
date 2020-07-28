package com.aws.mvp.dynamolocalstack.svc;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.model.AttributeDefinition;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.CreateTableResult;
import com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazonaws.services.dynamodbv2.model.KeyType;
import com.amazonaws.services.dynamodbv2.model.ScalarAttributeType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TableService {

    private static final String tableName = "games";
    private static final String attributeName = "id";

    private final AmazonDynamoDB dynamoDB;

    public int createTable(){
        List<AttributeDefinition> definitions = new ArrayList<>();
        definitions.add(new AttributeDefinition(attributeName, ScalarAttributeType.N));

        List<KeySchemaElement> keySchema = new ArrayList<>();
        keySchema.add(new KeySchemaElement(attributeName, KeyType.HASH));

        CreateTableRequest request = new CreateTableRequest()
                .withAttributeDefinitions(definitions)
                .withKeySchema(keySchema)
                .withTableName(tableName);

        CreateTableResult result = dynamoDB.createTable(request);
        return result.getSdkHttpMetadata().getHttpStatusCode();
    }

}
