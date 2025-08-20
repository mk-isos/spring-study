package study.data_jpa.repository;

import study.data_jpa.entitiy.Member;

import java.util.List;

public interface MemberRepositoryCustom {

    List<Member> findMemberCustom();
}
