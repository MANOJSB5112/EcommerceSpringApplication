package com.example.ecommercespringapplication.commons;

import com.example.ecommercespringapplication.dtos.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthenticationCommons {

    private RestTemplate restTemplate;

    @Autowired
    AuthenticationCommons(RestTemplate restTemplate)
    {
        this.restTemplate=restTemplate;
    }

    public UserDto validateToken(String token)
    {
        ResponseEntity<UserDto> response=restTemplate.postForEntity(
                "http://localhost:8081/users/validate" +token,
                null,
                UserDto.class
        );
        if(response.getBody()==null)
        {
            return null;
        }
        return response.getBody();
    }
}
