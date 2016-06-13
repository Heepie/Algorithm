import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Pos> q = new LinkedList<Pos>();

		Pos curPos;
		int[] arr, cache;
		int N, max =  -1;

		N = sc.nextInt();
		arr = new int[N+1];
		cache = new int[N+1];

		for (int i=1; i<=N; i++) {
			cache[i] = -1;
			arr[i] = sc.nextInt();
		}

		q.add(new Pos(1, arr[1], 1));
		q.add(new Pos(2, arr[2], 1));

		while(!q.isEmpty()) {
			curPos = q.poll();
//			System.out.println("Log/ curPos.jumpTo: " + curPos.getJumpTo() + " curPos.getValue: " + curPos.getValue());

			if (curPos.getJumpTo() > N)
				continue;

			if (curPos.getJumpTo() == N && max < curPos.getValue())
				max = curPos.getValue();

			if (curPos.getCountOne() != 2 && curPos.getJumpTo()+1 <= N) {
				//cache[curPos.getJumpTo()+1] = curPos.getValue() + arr[curPos.getJumpTo()+1];
				q.add(new Pos(curPos.getJumpTo()+1, curPos.getValue() + arr[curPos.getJumpTo()+1], curPos.getCountOne()+1));
			}

			if (curPos.getJumpTo()+2 <= N) {
				//cache[curPos.getJumpTo()+2] = curPos.getValue() + arr[curPos.getJumpTo()+2];
				q.add(new Pos(curPos.getJumpTo()+2, curPos.getValue() + arr[curPos.getJumpTo()+2], 1));
			}
		}

		q.clear();
		System.out.println(max);
	}
}

class Pos {
	int jumpTo, value, countOne;
	
	Pos (int jumpTo, int value, int countOne) {
		this.jumpTo = jumpTo;
		this.value = value;
		this.countOne = countOne;
	}

	public int getJumpTo() {
		return jumpTo;
	}

	public void setJumpTo(int jumpTo) {
		this.jumpTo = jumpTo;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getCountOne() {
		return countOne;
	}

	public void setCountOne(int countOne) {
		this.countOne = countOne;
	}
}
