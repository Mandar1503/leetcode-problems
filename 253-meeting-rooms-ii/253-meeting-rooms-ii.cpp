class Solution {
public:
    int minMeetingRooms(vector<vector<int>>& intervals) {
        
        priority_queue<int,vector<int>,greater<int>> pq; //declare a min heap to keep track of the no of meeting rooms
        
        sort(intervals.begin(),intervals.end(),[](vector<int> a,vector<int> b){
            return a[0]<b[0];
        });                                             //sort the intervals array using a function to compare
        
        for(auto meet:intervals)                        //iterate through the 2d vector
        {
            if(!pq.empty() && pq.top()<=meet[0])         //check if !pq.empty for initial condition and check if the top of the pq ie the end time of the nearest meeting to end is <= the new meeting's start time which is about to start.
            {
                pq.pop();                               //in this case pop the top meeting since its place is replaced by a new meeting
            }
            pq.push(meet[1]);                           //if not the case then just make a new space for the new meeting
        }
        return pq.size();                               //at last the size if the pq is the number of the meeting rooms created in total
    }
};