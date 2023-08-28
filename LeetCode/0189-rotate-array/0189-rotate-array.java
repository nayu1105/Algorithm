class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;

        reverse(nums, 0, n - k - 1);

        reverse(nums, n - k, n - 1);

        reverse(nums, 0, n - 1);
    }
    private static void reverse(int[] nums, int start, int end) {
        int cnt = (end - start + 1) / 2;

        for(int i=0; i<cnt; i++){
            int temp = nums[end-i];
            nums[end-i] = nums[start+i];
            nums[start+i] = temp;
        }
    }
}