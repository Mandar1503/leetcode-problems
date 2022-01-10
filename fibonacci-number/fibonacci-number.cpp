//Memoization technique (storing in map to avoid recurring calculations)
class Solution {
    
     map<int,int> cache; //declared global since the same map should be accessible to all the recuring functions
public:
    int fib(int n) {
        
        if(cache.find(n)!=cache.end()) //if found return 
            return cache.at(n);
        
        int result;
        
        if(n<2) //if n=1 or n=0 return that itself
            result = n;
        else
        {
            result = fib(n-1) + fib(n-2); //recursive call and add ans
        }
        cache.insert(pair<int,int>(n,result)); //you have came this far since the ans is not in the map thus insert into the map
        return result; //return the result
    }
};