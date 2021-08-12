import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static int N = 9;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int[] dwarfs = new int[N];
    for(int i=0; i<9; ++i)
    {
      dwarfs[i] = Integer.parseInt(br.readLine());
    }

    int[] bits = new int[N];
    for(int i = N-1; i >= N-7; --i)
    {
      bits[i] = 1;
    }

    do
    {
      int sum = 0;
      StringBuilder sb = new StringBuilder();
      for(int i=0; i<N; ++i)
      {
        if(bits[i] == 1)
        {
          sum += dwarfs[i];
          sb.append(String.valueOf(dwarfs[i])).append("\n");
        }
      }

      if(sum == 100)
      {
        System.out.println(sb.delete(sb.length() - 1, sb.length()));
        break;
      }
    }while(nextPermutation(bits));
  }

  private static boolean nextPermutation(int[] bits) {

    int i = N - 1;
    while (i > 0 && bits[i - 1] >= bits[i])
      --i;

    if (i == 0)
      return false;

    int j = N - 1;
    while (bits[i - 1] >= bits[j])
      --j;

    swap(bits, i - 1, j);

    int k = N - 1;
    while (i < k) {
      swap(bits, i++, k--);
    }

    return true;
  }

  private static void swap(int[] bits, int i, int j) {
    int tmp = bits[i];
    bits[i] = bits[j];
    bits[j] = tmp;
  }
}
