package com.example.FilmBuffs.dto.request;

import com.example.FilmBuffs.model.Critic;
import com.example.FilmBuffs.model.User;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateCriticRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String email;

    @NotBlank
    private String username;

    @NotBlank
    private String password;


    public Critic toCritic() {
        return Critic.builder()
                .name(this.name)
                .email(this.email)
                .user(User.builder()
                        .username(this.username)
                        .password(this.password)
                        .build())
                .build();
    }
}
