class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        
        if(strs.size()==1) //this is for the case when only one element is present
            return {{strs[0]}};
        
        vector<vector<string>> answer;
        unordered_map<string,vector<string>> Mp;
        
        for(int i=0;i<strs.size();i++)      //loop to enter the elements in a map corresponding to the sorted word of the element in the strs
        {
            string s = strs[i];
            sort(strs[i].begin(),strs[i].end()); //sort
            Mp[strs[i]].push_back(s); //push into map corr to the sorted word
        }
        for(auto i=Mp.begin();i!=Mp.end();i++) //push the value of the Map into the result vector
        {
            answer.push_back(i->second);
        }
        return answer;
    }
};
