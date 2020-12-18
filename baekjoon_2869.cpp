#include <iostream>
using namespace std;

int main()
{
    int day, night, goal;    
    int count = 0;
    cin >> day >> night >> goal;

    int day_goal_gap = goal - day;        

    count = day_goal_gap / (day - night);
    if(day_goal_gap % (day - night) != 0)
        ++count;
    ++count;

    cout << count << endl;
}