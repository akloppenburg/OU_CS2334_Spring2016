import java.util.ArrayList;
import java.util.List;

public class Friend {
	private String name;
	private List<Friend> friendList = new ArrayList<Friend>();

	public Friend(String name) {
		this.name = name;
	}

	public void addFriend(Friend friend) {
		this.friendList.add(friend);
	}

	protected List<Friend> getFriends() {
		return this.friendList;
	}

	public String toString() {
		return this.name;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Friend) {
			return this.name.equals(((Friend) o).name);
		}
		return false;
	}
}