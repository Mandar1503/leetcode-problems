//My code doesn't work for repeated numbers
// class Solution {
// public:
//     string originalDigits(string s) {
//         map<string,string> nos;
//         nos.insert({"0","zero"});
//         nos.insert({"1","one"});
//         nos.insert({"2","two"});
//         nos.insert({"3","three"});
//         nos.insert({"4","four"});
//         nos.insert({"5","five"});
//         nos.insert({"6","six"});
//         nos.insert({"7","seven"});
//         nos.insert({"8","eight"});
//         nos.insert({"9","nine"});
        
//         map<string,string> :: iterator itr;
//         string result;
//         for(itr = nos.begin();itr!=nos.end();itr++)
//         {
//             string no = itr->second;
//             int flag = 1;
//             for(auto i=0;i<no.size();i++)
//             {
//                 if(s.find(no[i]) == string::npos)
//                 {
//                     flag = 0;
//                     break;
//                 }
//             }
//             if(flag==1)
//             {
//                 result.append(itr->first);
//             }
//         }
//         return result;
//     }
// };


class Solution {
public:
    string originalDigits(string s) {
        map<char,int> count;
        for(int i=0; i<s.size();i++)
        {
            count[s[i]]++;
        }
        
        map<int,int> nos;
        nos[0] = count['z'];
        nos[2] = count['w'];
        nos[4] = count['u'];
        nos[6] = count['x'];
        nos[8] = count['g'];
        nos[3] = count['h'] - nos[8];
        nos[5] = count['f'] - nos[4];
        nos[7] = count['s'] - nos[6];
        nos[9] = count['i'] - nos[5] - nos[8] - nos[6];
        nos[1] = count['n'] - nos[7] - 2*nos[9];
        
        string result;
        
        map<string, int> :: iterator itr; 
        for(int i=0; i<10 ; i++)
        {
            for(int j=0;j<nos[i];j++)
            {
                result.append(to_string(i));
            }
        }
        return result;    
    }
};