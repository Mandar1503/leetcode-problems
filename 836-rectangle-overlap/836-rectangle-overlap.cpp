class Solution {
public:
    bool isRectangleOverlap(vector<int>& rec1, vector<int>& rec2) {
        //just check the area overlapped is positive in this case
        return (max(rec1[0], rec2[0]) < min(rec1[2], rec2[2]) &&
                max(rec1[1], rec2[1]) < min(rec1[3],rec2[3]));
    }
};

// class Solution {
// public:
//     bool isRectangleOverlap(vector<int>& rec1, vector<int>& rec2) {
        
//         //check if any if the two rectangles is a straight line
//         if(rec1[0] == rec1[2] || rec1[1] == rec1[3] || rec2[0] == rec2[2] || rec2[1] == rec2[3])
//             return false;
            
//         //check if even one case in the below conditions is false the the rectangle is not overlapping 
//         return !(rec1[2] <= rec2[0] || rec1[0] >= rec2[2] || rec1[3] <= rec2[1] || rec1[1] >= rec2[3]);
//     }
// };