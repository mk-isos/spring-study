package hellojpa;

import jakarta.persistence.*;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        //code
//        Member member1 = new Member();
//        member1.setId(1L);
//        member1.setName("HelloA");
//        em.persist(member1);    // 멤버 저장
//
//        Member member2 = new Member();
//        member2.setId(2L);
//        member2.setName("HelloB");
//        em.persist(member2);
//
//        tx.commit();

        //정석 코드 But 실제로는 스프링이 다 해줌
        try {

            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            Member member = new Member();
            member.setName("member1");
            member.setTeam(team);
            em.persist(member);

            //조회
            Member findMember = em.find(Member.class, member.getId());
            //연관관계가 없음
            Team findTeam = em.find(Team.class, team.getId());

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

//        em.close();
        emf.close();
    }
}
