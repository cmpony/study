class Solution {

	public static void main(String[] args) {
		int[] ints = {0,0,1,0,1,0,0,0,1,0};
		System.out.println(canPlaceFlowers(ints, 3));
	}

	public static boolean canPlaceFlowers(int[] flowerbed, int n) {
		int m = 0;
		int len = flowerbed.length;
		for (int i = 0;i < len;i++) {
			if (i == 0) {
				if (flowerbed[0] == 0 && flowerbed[1] == 0) {
					n--;
				}
			}
			if (len -2 == i) {
				if (flowerbed[len -2] == 0 && flowerbed[len -1] == 0) {
					if (n > 0) {
						n--;
					}
				}
			}

			if (len - i > 3) {
				if (flowerbed[i] == 0 && flowerbed[i + 1] == 0 && flowerbed[i + 2] == 0) {
					if (n > 0) {
						n--;
					}
					i += 2;
				}
			}
			
		}
		
		if (n == 0) {
			return true;
		} else {
			return false;
		}
	}
}