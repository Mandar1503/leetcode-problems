class Solution {
public:
    bool canAttendMeetings(vector<vector<int>>& intervals) {
        
        sort(intervals.begin(),intervals.end(),[](vector<int> a,vector<int> b){//sort the meetings by the starttime
            return a[0]<b[0];
        });
        
        for(int i=1;i<intervals.size();i++)             //iterate all the meetings
        {
            if(!(intervals[i-1][1]<=intervals[i][0]))   //check if the end time of the earlier meeting is less than the start time of the current meetinfg, if not return false
                    return false;
        }
        return true;                                    //else return true
    }
};