package ru.geekbrains.marketplace.mscore.interfaces;

import org.springframework.data.keyvalue.repository.KeyValueRepository;
import ru.geekbrains.marketplace.mscore.models.UserInfo;

public interface TokenRedisRepository extends KeyValueRepository<UserInfo,String> {

    void save(UserInfo user,String token);
}
