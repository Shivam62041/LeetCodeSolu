class Solution 
{
    public long maxSubarrays(int n, int[][] conflictingPairs) 
    {
        // Step 1: Prepare the conflict list
        List<Integer>[] conflicts = new List[n + 2];
        for (int i = 0; i < conflicts.length; i++) 
        {
            conflicts[i] = new ArrayList<>();
        }
        
        for (int[] pair : conflictingPairs) 
        {
            int a = pair[0];
            int b = pair[1];
            
            // Store the smaller number in the list of the larger number
            if (a < b) 
            {
                conflicts[b].add(a);
            } 
            else 
            {
                conflicts[a].add(b);
            }
        }

        // Step 2: Initialize tracking variables
        int maxLeft = 0;
        int secondMaxLeft = 0;
        long[] gains = new long[n + 2];  // For recoverable subarrays
        long validSubarrays = 0;

        // Step 3: Loop through numbers from 1 to n (as subarray end points)
        for (int right = 1; right <= n; right++) 
        {
            for (int left : conflicts[right]) 
            {
                if (left > maxLeft) 
                {
                    secondMaxLeft = maxLeft;
                    maxLeft = left;
                } 
                else if (left > secondMaxLeft) 
                {
                    secondMaxLeft = left;
                }
            }

            // Count valid subarrays ending at 'right'
            validSubarrays += right - maxLeft;
            // Track how many subarrays were blocked due to conflict gap
            gains[maxLeft] += maxLeft - secondMaxLeft;
        }

        // Step 4: Return total valid subarrays + best recoverable gain
        long maxGain = 0;
        for (long gain : gains) 
        {
            if (gain > maxGain) 
            {
                maxGain = gain;
            }
        }

        return validSubarrays + maxGain;
    }
}