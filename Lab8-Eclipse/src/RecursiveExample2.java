import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Lab 8, CS 2334, Section 010, 18 April 2017
 * <P>
 * This class demonstrates a simple recursive method. It includes a
 * <code>main</code> method to run the recursive method.
 * 
 * </P>
 * 
 * @author Dean Hougen
 * @version 1.0
 */

public class RecursiveExample2 {

	private static void printFriends(Friend friend, int distance){
		if (distance == 0) {
			System.out.println(friend);
		} else {
			for (Friend f : friend.getFriends()) {
				printFriends(f, distance - 1);
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Friend> friendList = new ArrayList<Friend>();

		Friend reuben = new Friend("Reuben");
		Friend soumitra = new Friend("Soumitra");
		Friend ken = new Friend("Ken");
		Friend elisa = new Friend("Elisa");
		Friend isaac = new Friend("Isaac");

		friendList.add(reuben);
		friendList.add(soumitra);
		friendList.add(ken);
		friendList.add(elisa);
		friendList.add(isaac);

		reuben.addFriend(soumitra);
		reuben.addFriend(ken);

		soumitra.addFriend(reuben);

		ken.addFriend(reuben);
		ken.addFriend(elisa);

		elisa.addFriend(ken);
		elisa.addFriend(isaac);

		isaac.addFriend(elisa);

		BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
		String inputName = "";
		String inputValue = "";
		Friend inputFriend = null;
		int inputInt = 0;

		System.out.println("Blank entry at any prompt exits program.");

		while (true) {
			System.out.print("Enter a person's name: ");
			try {
				inputName = inputReader.readLine();
			} catch (IOException e) {
				System.err.println("Error reading from console.");
			}

			if (inputName.equals("")) {
				System.out.println("Run complete.");
				System.exit(0);
			}

			inputFriend = new Friend(inputName);

			if (friendList.contains(inputFriend)) {
				inputFriend = friendList.get(friendList.indexOf(inputFriend));
				System.out.print("Enter a non-negative integer: ");
				try {
					inputValue = inputReader.readLine();
				} catch (IOException e) {
					System.err.println("Error reading from console.");
				}

				if (inputValue.equals("")) {
					System.out.println("Run complete.");
					System.exit(0);
				}

				try {
					inputInt = Integer.valueOf(inputValue);
				} catch (NumberFormatException e) {
					System.err.println("Must enter integer.");
					continue;
				}

				if (inputInt < 0) {
					System.out.println("Must be non-negative");
				} else {
					printFriends(inputFriend, inputInt);
				}
			} else {
				System.out.println(inputFriend + " not found.");
			}
		}
	}
}
