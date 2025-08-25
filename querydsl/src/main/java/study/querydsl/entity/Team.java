package study.querydsl.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter //학습용이니
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"id", "name"})
public class Team {

    @Id
    @GeneratedValue
    @Column(name = "team_id")
    private Long id;
    private String name;

    @OneToMany(mappedBy = "team")
    private List<Member> members = new ArrayList<>();

    //JPA 는 기본 생성자가 있어야함 Protected까지 허용 그래서 -> @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public Team(String name) {
        this.name = name;
    }
}
