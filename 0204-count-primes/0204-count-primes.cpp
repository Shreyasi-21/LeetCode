
class Solution {
public:
    int countPrimes(int n) {
        if(n <= 2)
            return 0;
        bool primes[n];
        int i, j, count = 0;
        for(i = 2; i < n; i++){
            primes[i] = true;
        }
        for(i = 2; i <= sqrt(n); i++){
            if(primes[i]){
                for(j = i+i; j < n; j += i)
                    primes[j] = false;
            }
        }
        for(i = 2; i < n; i++)
            if(primes[i])
                count++;
        return count;
    }
};