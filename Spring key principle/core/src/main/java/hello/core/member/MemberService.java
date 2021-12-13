package hello.core.member;

//회원가입, 조회가 되어야 함
public interface MemberService {
    void join(Member member); //가입

    Member findMember(Long memberId); //조회
}
