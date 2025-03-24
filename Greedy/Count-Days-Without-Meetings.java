class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a , b) -> a[0] - b[0]);
        //[[3,4],[4,8],[2,5],[3,8]]
        //[2, 5], [3, 4], [3, 8], [4, 8]

        int count = 0;
        int lastEnd = 0; // Track the end of the last processed meeting

        // Check for days before the first meeting
        count += Math.max(0, meetings[0][0] - 1);
        lastEnd = meetings[0][1];

        // Iterate through the meetings
        for (int i = 1; i < meetings.length; i++) {
            // Check for gaps between meetings
            count += Math.max(0, meetings[i][0] - lastEnd - 1);
            // Update lastEnd to the maximum end time (handle overlaps)
            lastEnd = Math.max(lastEnd, meetings[i][1]);
        }

        // Check for days after the last meeting
        count += Math.max(0, days - lastEnd);

        return count;
        //check if curr index [i][1] > index + 1's [i][0] then are overlapping
        //if not then do index+1's [i][0] - curr Ind [i][1] - 1 
        //and add that to count
        //if we're on last index do a days - [i][1] and add that to count
        //return the count 
    }
}