package com.example.FilmBuffs.model;

import com.example.FilmBuffs.dto.response.CriticResponse;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "critic")
public class Critic {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String email;

    @OneToMany(mappedBy = "critic")
    private List<Review> reviewList;  //mappedBy indicates the field-name that maps the critic with all their reviews

    @OneToOne
    @JoinColumn
    private User user;

    public CriticResponse toCriticResponse() {
        return CriticResponse.builder()
                .name(this.name)
                .email(this.email)
                .build();
    }
}
