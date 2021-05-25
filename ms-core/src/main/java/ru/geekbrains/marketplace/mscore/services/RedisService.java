package ru.geekbrains.marketplace.mscore.services;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import ru.geekbrains.marketplace.mscore.interfaces.TokenRedisRepository;
import ru.geekbrains.marketplace.mscore.models.UserInfo;

@Service
public class RedisService  {


    TokenRedisRepository tokenRedisRepository;

    public void putInvalidToken(UserInfo user,String token){
        tokenRedisRepository.save(user,token);
    }

    public boolean checkToken(String token){
       return tokenRedisRepository.existsById(token);
    }
}
