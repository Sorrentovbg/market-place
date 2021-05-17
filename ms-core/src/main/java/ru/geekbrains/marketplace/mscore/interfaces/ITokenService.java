package ru.geekbrains.marketplace.mscore.interfaces;

import ru.geekbrains.marketplace.mscore.models.UserInfo;

public interface ITokenService {

    String generateToken(UserInfo user);

    UserInfo parseToken(String token);

}
