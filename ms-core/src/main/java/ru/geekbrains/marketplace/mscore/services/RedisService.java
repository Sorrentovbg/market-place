package ru.geekbrains.marketplace.mscore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.marketplace.mscore.repositories.RedisRepository;

import java.time.Duration;

@Service
public class RedisService  {

    @Autowired
    RedisRepository redisRepository ;

    public void putInvalidToken(String token){
        redisRepository.putToken(token, Duration.ofHours(1));
    }

    public boolean checkToken(String authorizationHeader){
        boolean existToken = false;
        if(redisRepository.getToken(authorizationHeader) != null){
            existToken = true;
        }
       return existToken;
    }
}
