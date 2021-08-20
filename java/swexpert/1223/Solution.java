/**
 * @author suho kim
 * @no 1223
 * @title [S/W 문제해결 기본] 6일차 - 계산기2
 * @date 2021.08.19
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    

    for(int t=1; t<=10; ++t)
    {
      Integer.parseInt(br.readLine());
      StringBuilder sb = new StringBuilder();
      Stack<Character> stack = new Stack<Character>();

      String line = br.readLine();

      for(int i=0; i<line.length(); ++i)
      {
        char c = line.charAt(i);

        if(c == '+')
        {
          while(!stack.isEmpty())
          {
            sb.append(stack.pop());
          }
          stack.push(c);
        }
        else if(c == '*')
        {
          stack.push(c);
        }
        else
        {
          sb.append(c);
        }
      }

      while(!stack.isEmpty())
        sb.append(stack.pop());

      String str = sb.toString();

      Stack<Integer> nStack = new Stack<Integer>();

      for(int i=0; i<str.length(); ++i)
      {
        char c = str.charAt(i);

        if(c == '*')
        {
          nStack.push(nStack.pop() * nStack.pop());
        }
        else if(c == '+')
        {
          nStack.push(nStack.pop() + nStack.pop());
        }
        else
        {
          nStack.push(c - '0');
        }
      }

      System.out.println(String.format("#%d %d", t, nStack.pop()));
    }
  }
}
