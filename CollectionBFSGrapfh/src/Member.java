

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class Member {
    private String email;
    private Collection<Member> friends;

    public Member(String email) {
        this(email, new ArrayList<Member>());
    }

    public Member(String email, Collection<Member> friends) {
        this.email = email;
        this.friends = friends;
    }

    public String getEmail() {
        return email;

    }

    public Collection<Member> getFriends() {
        return friends;
    }

    public void addFriends(Collection<Member> friends) {
        this.friends.addAll(friends);
    }

    public void addFriend(Member friend) {
        friends.add(friend);
    }
}