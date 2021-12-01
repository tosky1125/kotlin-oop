package hello.core.member

class MemoryMemberRepository : MemberRepository {
    companion object {
        private val store = HashMap<Long, Member>()
    }

    override fun save(member: Member) {
        store.put(member.id, member)
    }

    override fun findById(memberId: Long): Member? {
        return store.get(memberId)
    }
}