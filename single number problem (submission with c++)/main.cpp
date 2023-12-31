#include <bits/stdc++.h>
using namespace std;
class Solution {
public:
    int singleNumber(vector<int>& nums) {
        vector<int> v=vector<int>(1000000);
        vector<int> v2=vector<int>(1000000);
        for(int i=0;i<nums.size();i++){
            if (nums[i]>=0)
            v[nums[i]]++;
            else
            v2[-nums[i]]++;
        }
        for(int i=0;i<v.size();i++){
            if (v[i]==1)
                return(i);
        }
        for(int i=0;i<v2.size();i++){
            if (v2[i]==1)
                return(-i);
        }
   return 0; }
};