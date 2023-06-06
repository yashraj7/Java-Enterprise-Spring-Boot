
public class _4Flowers {
	public static boolean canPlaceFlowers(int[] flowerbed, int n) {
		int count = 0;
		int length = flowerbed.length;
		int i = 0;

		while (i < length) {
			// Check if the current plot and its adjacent plots are empty
			if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == length - 1 || flowerbed[i + 1] == 0)) {
				flowerbed[i] = 1; // Plant a flower in the current plot
				count++; // Increment the count of planted flowers

				// Check if the required number of flowers have been planted
				if (count == n) {
					return true;
				}
			}

			i++;
		}

		return false;
	}

	public static void main(String[] args) {
		int[] flowerbed = { 1, 0, 0, 0, 1 };
		int n = 1;

		boolean canPlantFlowers = canPlaceFlowers(flowerbed, n);

		System.out.println("Output: " + canPlantFlowers);
	}
}
