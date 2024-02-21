#include <bits/stdc++.h>

typedef long long ll;
using namespace std;

ll solve(ll r, ll c) {
    ll ans = 0;
    if(r >= c) {
        ll start = (r % 2 == 0) ? (r * r) : ((r-1) * (r-1)) + 1;

        if(r % 2) ans = (start) + (c - 1);
        else ans = (start) - (c - 1);

    }else {
        ll start = (c % 2 == 0) ? ((c-1) * (c-1)) + 1 : (c * c);

        if(c % 2) ans = start - (r - 1);
        else ans = start + (r - 1);
    }
    return ans;
}
int main() {


    int x = 1234;
    cout << (int)log10(x);

    return 0;
}
// int main() {

//     ll t;
//     cin >> t;

//     while(t-- > 0) {
//         ll r, c;
//         cin >> r >> c;

//         cout << solve(r, c) << endl;
//     }

//     return 0;
// }
