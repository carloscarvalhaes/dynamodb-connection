package com.aws.mvp.dynamolocalstack.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.Data;
import org.springframework.data.annotation.Id;

@DynamoDBTable(tableName = "game")
@Data
public class Game {

    @Id
    private Long id;

    private String name;
    private String description;
    private String winner;
}
