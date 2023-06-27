package test;

public class Test {

	public static void main(String[] args) {

		String name = "Indastry";
		String newName = name.replace("a", "u");

		System.out.println("Name is: " + name + " and new name is : " + newName);
		System.out.println(name.hashCode() + ", " + newName.hashCode());

		char[] names = name.toCharArray();

		for (char nam : names) {
			System.out.print(nam + " ");
		}

		System.out.println("\n");

		String packs = "com.src.java.my.ext";

		String[] pack = packs.split("\\."); // Please explain "-?\\."
		// does not work with- ".?\\." or even, "+?\\." or on "."

		for (String p : pack) {
			System.out.println(p);
		}

		int len = pack.length;
		System.out.println(len);
		System.out.println(pack[len - 1]);
		System.out.println(pack[len - 2]);
	}

}
