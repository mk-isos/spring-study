package study.data_jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.data_jpa.entity.Team;

//@Repository 어노테이션 없어도 스캔 가능
public interface TeamRepository extends JpaRepository<Team, Long> {
}
