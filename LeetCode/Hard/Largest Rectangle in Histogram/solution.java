class Solution {
    public int largestRectangleArea(int[] heights) {
        int ma=0,n=heights.length;
        Stack<Integer> stack = new Stack<>();
        int i=0;
        while(i<n||!stack.isEmpty()){
            if(i<n && (stack.isEmpty()||heights[i]>=heights[stack.peek()])){
                stack.push(i);
                i++;
            }else{
                int h =  heights[stack.pop()];
                int w = stack.isEmpty()?i:i-stack.peek()-1;
                ma = Math.max(ma,h*w); 
            }
        }
        return ma;
    }
}