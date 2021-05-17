//package ru.geekbrains.marketplace.eurekafeignclient.auth;
//
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import ru.geekbrains.marketplace.mscore.models.UserInfo;
//import ru.geekbrains.marketplace.mscore.models.dto.AuthRequestDto;
//import ru.geekbrains.marketplace.mscore.models.dto.AuthResponseDto;
//
//@FeignClient("ms-auth")
//public interface AuthClient {
//
//    @PostMapping("/login")
//    public AuthResponseDto login(@RequestBody AuthRequestDto request);
//}
