package com.aws.mvp.dynamolocalstack.repository;

import com.aws.mvp.dynamolocalstack.model.Game;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@EnableScan
@Repository
public interface GameRepository extends CrudRepository<Game, Long> {
}
