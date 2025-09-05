class Solution {
      static final long MOD = 1000000007L;
    static long power(long base, long exp) {
        if (exp == 0) return 1L;
        long half = power(base, exp / 2);
        long result = (half * half) % MOD;
        if ((exp & 1L) == 1L) result = (result * base) % MOD;
        return result;
    }

    public int countGoodNumbers(long n) {
        long evenPositions = (n + 1) / 2; // ceil(n/2)
        long oddPositions  = n / 2;       // floor(n/2)

        long evenWays = power(5L, evenPositions);
        long oddWays  = power(4L, oddPositions);

        return (int) ((evenWays * oddWays) % MOD);
    }
}
