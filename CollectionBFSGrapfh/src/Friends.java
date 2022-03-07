
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * Given a data structure representing a social network, write a function that
 * finds friends of a certain degree. Friends of the first degree are a member's
 * immediate friends, friends of the second degree are friends of a member's
 * friends excluding first degree friends, etc.
 * 
 * @author TCACAKMAK
 *
 */

public class Friends {

	public static List<Member> getFriendsOfDegree2(Member member, int degree) {

		if (degree < 0) {
			return new LinkedList<Member>();
		}

		Collection<Member> memberList = member.getFriends();

		for (int i = 1; i < degree; i++) {
			try {
				memberList = memberList.iterator().next().getFriends();
			} catch (Exception e) {
				return new LinkedList<Member>();
			}
		}

		return (List<Member>) memberList;

	}

	public static List<Member> getFriendsOfDegree(Member member, int degree) {
		int deg = 0;
		Queue<Member> q = new LinkedList<>();
		HashSet<Member> visited = new HashSet<Member>();

		q.add(member);
		visited.add(member);

		while (!q.isEmpty()) {
			if (deg == degree) {
				List<Member> friends = new ArrayList<Member>();
				while (!q.isEmpty())
					friends.add(q.poll());
				return friends;
			}
			deg++;
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Member mem = q.poll();
				for (Member friend : mem.getFriends()) {
					if (!visited.contains(friend)) {
						q.add(friend);
						visited.add(friend);
					}
				}
			}
		}
		return new LinkedList<Member>(); // cover the edge cases
	}

	public static void main(String[] args) {
		Member me = new Member("me@test.com");
		Member myFriend1 = new Member("my.friend@test.com");
		Member myFriend2 = new Member("my.friend2@test.com");
		Member myFriend3 = new Member("my.friend3.friend@test.com");
		Member myFriend4 = new Member("my.friend4.friend@test.com");
		Member myFriend5 = new Member("my.friend5.friend@test.com");

		Member myFriend6 = new Member("my.friend6.friend@test.com");
		Member myFriend7 = new Member("my.friend7.friend@test.com");

		me.addFriend(myFriend1);
		myFriend1.addFriend(myFriend2);
		myFriend1.addFriend(myFriend3);
		myFriend1.addFriend(myFriend4);
		myFriend2.addFriend(myFriend3);
		myFriend2.addFriend(myFriend5);
		myFriend3.addFriend(myFriend5);
		myFriend5.addFriend(myFriend7);
		myFriend3.addFriend(myFriend2);
		me.addFriend(myFriend6);
		myFriend6.addFriend(myFriend7);

		List<Member> list = getFriendsOfDegree(myFriend1, 2);
		for (Member friend : list)
			System.out.println(friend.getEmail());

		List<Member> list2 = getFriendsOfDegree(me, 2);
		for (Member friend : list2)
			System.out.println(friend.getEmail());

		// Correct output:
		// my.friends.friend@test.com
	}
}