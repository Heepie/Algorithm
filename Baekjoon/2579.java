import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Pos> q = new LinkedList<Pos>();

		Pos curPos;
		int[] arr;
		int[][] cache;
		int N, max =  -1;

		N = sc.nextInt();
		arr = new int[N+3];
		cache = new int[N+1][2];

		for (int i=1; i<=N; i++) {
			cache[i][0] =  -1;
			cache[i][1] =  -1;
			arr[i] = sc.nextInt();
		}

		q.add(new Pos(1, arr[1], 0));
		q.add(new Pos(2, arr[2], 0));

		while(!q.isEmpty()) {
			curPos = q.poll();
//			System.out.println("Log/ curPos.jumpTo: " + curPos.getJumpTo() + " curPos.getValue: " + curPos.getValue());

			if (curPos.getJumpTo() > N)
				continue;

			if (cache[curPos.getJumpTo()][curPos.getCountOne()] >= curPos.getValue())
				continue;
			else
				cache[curPos.getJumpTo()][curPos.getCountOne()] = curPos.getValue();

			if (curPos.getCountOne() == 1) {
				q.add(new Pos(curPos.getJumpTo()+2, curPos.getValue() + arr[curPos.getJumpTo()+2], 0));

			} else {
				q.add(new Pos(curPos.getJumpTo()+1, curPos.getValue() + arr[curPos.getJumpTo()+1], 1));
				q.add(new Pos(curPos.getJumpTo()+2, curPos.getValue() + arr[curPos.getJumpTo()+2], 0));
			}
		}

		q.clear();
		System.out.println(Max(cache[N][0], cache[N][1]));
	}
	public static int Max(int parm1, int parm2) {
		return parm1 > parm2 ? parm1:parm2;
	}
}

class Pos {
	private int jumpTo, value, countOne;

	Pos (int jumpTo, int value, int countOne) {
		this.jumpTo = jumpTo;
		this.value = value;
		this.countOne = countOne;
	}

	public int getJumpTo() {
		return jumpTo;
	}

	public int getValue() {
		return value;
	}

	public int getCountOne() {
		return countOne;
	}
}
