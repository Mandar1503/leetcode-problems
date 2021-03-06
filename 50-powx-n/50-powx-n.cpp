//Recursive solution (To understand Dry run it)
class Solution {
public:
    double fastPow(double x, long long n)
    {
        if(n==0)
            return 1.0;
        
        double half = fastPow(x,n/2);
        if(n % 2 == 0)
            return half*half;
        else
            return half*half*x;
    }
    
    double myPow(double x, int n) {
        long long N = n;
        if(N<0)
        {
            x = 1/x;
            N=-N;
        }
        return fastPow(x,N);
    }
};


//Fast Power Iterative Algo (Difficult to understand)
// class Solution {
// public:
//     double myPow(double x, int n) {
       
//         long long N = n;
//         if(N<0)
//         {
//             x = 1/x;
//             N = -N;
//         }
        
//         double ans = 1;
//         double curr = x;
    
//         for (long long i = N; i ; i /= 2) {
//             if ((i % 2) == 1) {
//                 ans = ans * curr;
//             }
//             curr = curr * curr;
//         }
//         return ans;
            
//     }
// };

