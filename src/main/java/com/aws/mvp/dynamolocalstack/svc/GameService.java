package com.aws.mvp.dynamolocalstack.svc;

import com.aws.mvp.dynamolocalstack.model.Game;
import com.aws.mvp.dynamolocalstack.repository.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GameService {

    private final GameRepository gameRepository;

    public void save(Game game){

        gameRepository.save(game);

    }

    public Game getGameById(Long gameId){
        return gameRepository.findById(gameId).orElse(null);
    }

    public List<Game> getAllGames(){
        List<Game> games = new ArrayList<>();
        gameRepository.findAll().forEach(games::add);
        return games;
    }

}
