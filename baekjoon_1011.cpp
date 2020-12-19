#include <iostream>
#include <math.h>

using namespace std;

int main()
{
    long testcase, x, y, distance, num;
    cin >> testcase;

    for (int i = 0; i < testcase; ++i)
    {
        num = 1;
        cin >> x >> y;

        distance = y - x;

        while (++num * num < distance){}

        if (pow(num - 1, 2) == distance)
        {
            cout << num - 1 + num - 2;
        }
        else if ((pow(num, 2) + pow(num - 1, 2)) / 2 > distance)
        {
            cout << (num - 1) * 2;
        }
        else
        {
            cout << num * 2 - 1;
        }

        cout << endl;
    }
}