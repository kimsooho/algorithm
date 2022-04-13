
/**
 * @author suho kim
 * @no 14891
 * @title 톱니바퀴
 * @url https://www.acmicpc.net/problem/14891
 * @date 2022.04.13
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Gear {
  List<Integer> gear;

  public Gear() {
    this.gear = new ArrayList<Integer>();
  }

  public void setGear(String gear) {
    for (int i = 0; i < gear.length(); ++i) {
      this.gear.add(Integer.parseInt(Character.toString(gear.charAt(i))));
    }
  }

  public void rotation(int dir) {
    int tmp;
    int idx;
    if (dir == -1) {
      idx = 0;
      tmp = gear.get(idx);
      gear.remove(idx);
      gear.add(tmp);
    } else {
      idx = gear.size() - 1;
      tmp = gear.get(idx);
      gear.remove(idx);
      gear.add(0, tmp);
    }
  }

  public int getGearValue(int idx) {
    return gear.get(idx);
  }
}

class Gears {
  private Gear[] gears;

  public Gears() {
    this.gears = new Gear[4];
  }

  public void addGear(int idx, Gear gear) {
    gears[idx] = gear;
  }

  public void rotation(String cmd) {
    int idx = Integer.parseInt(cmd.split(" ")[0]) - 1;
    int dir = Integer.parseInt(cmd.split(" ")[1]);
    int[] prevValues = { gears[idx].getGearValue(2), gears[idx].getGearValue(6) };
    gears[idx].rotation(dir);

    int nextDir = dir;

    int nextGearPrevValue = prevValues[1];
    for (int i = idx - 1; i >= 0; --i) {
      nextDir *= -1;
      if (!isDifferentFromAcross(i, 2, nextGearPrevValue))
        break;

      nextGearPrevValue = gears[i].getGearValue(6);
      gears[i].rotation(nextDir);
    }

    nextDir = dir;
    nextGearPrevValue = prevValues[0];
    for (int i = idx + 1; i < gears.length; ++i) {
      nextDir *= -1;
      if (!isDifferentFromAcross(i, 6, nextGearPrevValue))
        break;

      nextGearPrevValue = gears[i].getGearValue(2);
      gears[i].rotation(nextDir);
    }
  }

  private boolean isDifferentFromAcross(int gearIdx, int valueIdx, int value) {
    return value != gears[gearIdx].getGearValue(valueIdx);
  }

  public int getSumNorthValue() {
    int val = 0;
    for (int i = 0; i < gears.length; ++i) {
      val += Math.pow(2, i) * gears[i].getGearValue(0);
    }

    return val;
  }
}

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Gears gears = new Gears();
    for (int i = 0; i < 4; ++i) {
      Gear gear = new Gear();
      gear.setGear(br.readLine());
      gears.addGear(i, gear);
    }

    int K = Integer.parseInt(br.readLine().trim());
    for (int i = 0; i < K; ++i) {
      gears.rotation(br.readLine());
    }

    System.out.println(gears.getSumNorthValue());
  }
}
