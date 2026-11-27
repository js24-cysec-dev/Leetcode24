
class Solution {
    public  int findMaxConsecutive(int[] bars) {
        if (bars.length == 0) {
            return 0;
        }
        Arrays.sort(bars);
        int maxLength = 1;
        int currentLength = 1;
        for (int i = 1; i < bars.length; i++) {
            if (bars[i] == bars[i - 1] + 1) {
                currentLength++;
            } else {
                currentLength = 1;
            }
            maxLength = Math.max(maxLength, currentLength);
        }
        return maxLength;
    }

    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        int maxHConsecutive = findMaxConsecutive(hBars);
        int maxVConsecutive = findMaxConsecutive(vBars);

        long side = Math.min(maxHConsecutive + 1, maxVConsecutive + 1);

        return (int)(side * side);
    }
}