class Solution {
    public boolean isPerfectSquare(int n) {
        long i=1;
        while(i*i<n)i++;
        return i*i==n;
    }
}