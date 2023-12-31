#include <bits/stdc++.h>
class Solution {
public:
    vector<int> twoSum(vector<int>& v, int target) {
        vector <int> res;
        for (int i=0;i<v.size();i++){
            int rech=target-v[i];
            auto it = std::find(v.begin(), v.end(), rech);
            if (find(v.begin(),v.end(),rech)!=v.end() && (it-v.begin())!=i ) {

                res.push_back(i);
                res.push_back(it-v.begin());
                break;
            }
        }
        return(res);

    }
};
