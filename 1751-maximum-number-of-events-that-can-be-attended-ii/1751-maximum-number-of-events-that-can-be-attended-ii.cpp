
class Solution {
public:
    int maxValue(vector<vector<int>>& events, int k) {
        events.push_back({0,0,0});
        int n = events.size();
        sort(events.begin(), events.end(), [](const auto& a, const auto& b){return a[1] < b[1];});
        vector<int> end_times(n,0);
        for (int i = 0; i < n; i++) end_times[i] = events[i][1];

        vector<vector<int>> dp(n, vector<int>(k+1, 0));
        int ret = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < k+1; j++) {
                auto it = lower_bound(end_times.begin(), end_times.end(), events[i][0]);
                assert(it != end_times.end());
                assert(it != end_times.begin());
                it--;
                int k = std::distance(end_times.begin(), it);
                dp[i][j] = max(events[i][2] + dp[k][j-1], dp[i-1][j]);
                ret = max(ret, dp[i][j]);
            }
        }
        return ret;
    }
};