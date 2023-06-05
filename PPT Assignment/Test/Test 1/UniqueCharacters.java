
public class UniqueCharacters {

	public static void main(String[] args) {

		String s = "aabb";
		char[] hash = new char[26];
		int ans = -1;
		for (int i = 0; i < s.length(); i++)
			hash[(char) (s.charAt(i) - 'a')]++;
		for (int i = 0; i < hash.length; i++)
			if (hash[i] == 1)
				ans = i;
		System.out.println(ans);
	}

}
