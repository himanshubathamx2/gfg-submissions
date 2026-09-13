class Solution {
  public:
    int minSteps(vector<int>& arr, int start, int end) {
        priority_queue<pair<int,int>,vector<pair<int,int>>,greater<>> q;
        q.push({0,start});
        vector<int> dist(1000,INT_MAX);
        dist[start] = 0;
        while(!q.empty())
        {
            int num = q.top().second;
            int steps = q.top().first;
            q.pop();
            if(steps > dist[num])
                continue;
            if(num==end)
                return steps;

            for(int n : arr)
            {
                int next = (1LL*n*num)%1000;
                if(steps + 1 < dist[next])
                {
                    dist[next]=steps+1;
                    q.push({steps+1,next});
                }
            }
        }
        return -1;
    }
};