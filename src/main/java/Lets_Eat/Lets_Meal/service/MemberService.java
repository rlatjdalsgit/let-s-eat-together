package Lets_Eat.Lets_Meal.service;

import Lets_Eat.Lets_Meal.domain.Member;
import Lets_Eat.Lets_Meal.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
//@AllArgsConstructor//생성자를 만들어줌
@RequiredArgsConstructor//final 필드만 갖고 생성자를 만듦
public class MemberService {
    private final MemberRepository memberRepository;
    //회원가입
    public Long join(Member member) {
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }
    private void validateDuplicateMember(Member member) {//중복일때
        List<Member> findMembers = memberRepository.findByName(member.getUsername());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    //g회원 전체 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public Member findOne(Long memberId) {
        return memberRepository.findOne(memberId);
    }
}
