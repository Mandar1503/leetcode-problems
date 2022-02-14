// //Using hashset
// class Solution {
// public:
//     bool isHappy(int n) {
//         set<int> val;
//         while(n!= 1 && val.find(n)==val.end())
//         {
//             val.insert(n);
//             n = nextNumber(n);
//         }
//         return (n==1);
//     }
    
//     int nextNumber(int n)
//     {
//         int sum = 0;
//         while(n>0)
//         {
//             int no = n % 10;
//             n = n / 10;
//             sum+= no*no;
//         }
//         return sum;
//     }   
// };

//Using Floyds cycle finding algo
class Solution {
public:
    int nextNumber(int n){
        int sum = 0;
        while(n>0)
        {
            int no = n%10;
            n = n/10;
            sum +=no*no;
        }
        return sum;
    }
    
    bool isHappy(int n) {
        int slow = n;
        int fast = nextNumber(n);
        while(fast!=1 && slow!=fast)
        {
            slow = nextNumber(slow);
            fast = nextNumber(nextNumber(fast));
        }
        return fast==1;
    }
};