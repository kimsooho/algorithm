import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st= new StringTokenizer(br.readLine());

    int t = Integer.parseInt(st.nextToken());
    ArrayList<Member> members = new ArrayList<Member>();
    while(t-- != 0)
    {
      st = new StringTokenizer(br.readLine());
      members.add(new Member(t, Integer.parseInt(st.nextToken()), st.nextToken()));
    }

    Collections.sort(members, new Comparator<Member>(){
      @Override
      public int compare(Member m1, Member m2)
      {
        if(m1.age != m2.age)
          return m1.age - m2.age;

        return m2.idx - m1.idx;
      }
    });

    for(Member member : members)
    {
      System.out.println(String.format("%d %s", member.age, member.name));
    }
  }
}

class Member
{
  int idx;
  int age;  
  String name;  
  public Member(int idx, int age, String name)
  {
    this.idx = idx;
    this.age = age;
    this.name = name;
  }
}
