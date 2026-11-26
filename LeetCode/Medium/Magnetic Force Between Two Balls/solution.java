class Solution {
    public int maxDistance(int[] pos, int m) {
        long l=1,h=Arrays.stream(pos).max().getAsInt()+1;
        Arrays.sort(pos);
        while(l<h){
            long mid = (l+h+1)/2;
            int c=1,p=pos[0];
            for(int i:pos){
                if(i-p>=mid){
                    c++;
                    p=i;
                }
            }
            if(c>=m)l=mid;
            else h=mid-1;
        }
        return (int) l;
    }
}