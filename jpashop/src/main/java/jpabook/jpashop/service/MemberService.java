package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor // final 붙은 것만 생성자 만들어 줌
public class MemberService {

    private final MemberRepository memberRepository;


    ////    @Autowired // <- 이게 여기쓰면 문제가 좀 있음 수정을 하고 싶을때 못함
//    private MemberRepository memberRepository;
//
//    @Autowired // 이거 안써도 생성자 하나뿐이면 자동으로 주입해주긴 함.
//    public MemberService(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }

    /**
     * 회원 가입
     */
    @Transactional
    public Long join(Member member) {
        validateDuplicateMember(member); //중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        //예외 터트려야징

        List<Member> findMembers = memberRepository.findByName(member.getName());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }


    //회원 전체 조회
//    @Transactional(readOnly = true)
    public List<Member> findAll() {
        return memberRepository.findAll();
    }

//    @Transactional(readOnly = true) // 조금더 성능을 최적화
    public Member findOne(Long memberId) {
        return memberRepository.findOne(memberId);
    }



}
