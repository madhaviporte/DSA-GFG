
class Solution {
    static final long MOD = 1000000007L;

    long reachTime(long x, long a, long b) {
        if (x <= 0) return 0;

        if (x <= a) return x;

        long g = a - b;
        long k = (x - a - 1) / g + 1;

        return x + 2 * b * k;
    }

    long mul(long a, long b) {
        return ((a % MOD) * (b % MOD)) % MOD;
    }

    long sum(long first, long last, long n) {
        return mul(mul(n, first + last), 500000004L);
    }

    long prefix(long n, long a, long b) {
        if (n <= 0) return 0;

        long ans = 0;
        long base = Math.min(n, a);

        ans = sum(1, base, base);

        if (n <= a) return ans;

        long g = a - b;
        long q = n - a;

        long k = q / g;
        long rem = q % g;

        if (k > 0) {
            long count = k * g;

            ans = (ans + sum(a + 1, a + count, count)) % MOD;

            long extra = mul(b, g);
            extra = mul(extra, k);
            extra = mul(extra, k + 1);

            ans = (ans + extra) % MOD;
        }

        if (rem > 0) {
            long first = a + k * g + 1;
            long last = first + rem - 1;

            ans = (ans + sum(first, last, rem)) % MOD;

            long extra = mul(rem, 2 * b);
            extra = mul(extra, k + 1);

            ans = (ans + extra) % MOD;
        }

        return ans;
    }

    public int minTime(int a, int b, int d, int l, int r) {

        long normal = reachTime(d, a, b);

        long low = l;
        long high = (long) r + 1;

        while (low < high) {
            long mid = low + (high - low) / 2;

            long x = Math.max(0L, (long) d - mid);

            long jump = reachTime(x, a, b) + 1;

            if (jump < normal) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        long first = low;
        long ans = 0;

        if (first > r) {
            return (int) mul((long) r - l + 1, normal);
        }

        long normalCount = first - l;

        ans = mul(normalCount, normal);

        long jumpCount = (long) r - first + 1;

        ans = (ans + jumpCount) % MOD;

        long jHigh = Math.min((long) r, (long) d - 1);

        if (first <= jHigh) {
            long yLow = (long) d - jHigh;
            long yHigh = (long) d - first;

            long part = prefix(yHigh, a, b)
                      - prefix(yLow - 1, a, b);

            part = (part + MOD) % MOD;

            ans = (ans + part) % MOD;
        }

        return (int) ans;
    }
}
