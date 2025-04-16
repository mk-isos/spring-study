package hello.springtx.propagation;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    private Long id;
    private String username;

    // 이거 기본생성자는 JPA 스펙상 있어야지
    public Member() {
    }

    public Member(String username) {
        this.username = username;
    }
}
