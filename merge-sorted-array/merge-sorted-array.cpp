class Solution {
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
       
        vector<int> nums1C = nums1; //make a copy of nums1 as nums1C
        
        int p1 = 0;
        int p2 = 0;
        
        for(int p=0;p<m+n;p++) //iterate p till m+n
        {
            if( p2==n || (p1<m && nums1C[p1]<nums2[p2]))  //check if p1 less then m and if p2>=n in
            {
                nums1[p] = nums1C[p1];
                p1++;
            }
            else
            {
                nums1[p] = nums2[p2];
                p2++;
            }
        }
    }
};