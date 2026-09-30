class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums); // Step 1: Sort the array

        for (int i = 0; i < nums.length; i++) {
            // Optimization: If the current number is > 0, the sum can never be 0
            if (nums[i] > 0) {
                break;
            }

            // Skip duplicate values for the first element of the triplet
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // Step 2: Set up two pointers
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];

                if (currentSum < 0) {
                    left++; // We need a larger sum
                } else if (currentSum > 0) {
                    right--; // We need a smaller sum
                } else {
                    // Triplet found!
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Move both pointers inward
                    left++;
                    right--;

                    // Skip duplicate values for the left pointer
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }

                    // Skip duplicate values for the right pointer
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
            }
        }
        return res;
    }
}
