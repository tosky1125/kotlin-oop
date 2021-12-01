package hello.core.member

class MemberServiceImpl(
    private final val repository: MemberRepository
) : MemberService {

    override fun join(member: Member) {
        repository.save(member)
    }

    override fun findMember(memberId: Long): Member? {
        return repository.findById(memberId)
    }
}