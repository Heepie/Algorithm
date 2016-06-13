import java.util.Scanner;
import java.util.Stack;

public class Main {
	static Scanner sc = new Scanner (System.in);
	static int[][] board = null;
	static int[][] cache = null;

	public static void main(String[] args) {
		Stack<Pos> stack = new Stack<Pos>();
		int N, M, isCache, min=Integer.MAX_VALUE;
		Pos p;

		N = sc.nextInt();
		M = sc.nextInt();
		sc.nextLine();
		init(N, M);

		stack.push(new Pos(0,0,0));

		while (!stack.isEmpty()) {
			p = stack.pop();

			//Exception Condition
			if (p.getX() >= N || p.getX() < 0 || p.getY() >= M || p.getY() < 0)
				continue;

			//End Condition
			if (p.getX() == N-1 && p.getY() == M-1) {
				if (min > p.getNumOfWall())
					min = p.getNumOfWall();
			}

			isCache = cache[p.getY()][p.getX()];
			//Exist cache
			if (isCache != -1) {
				if (isCache <= p.getNumOfWall()+board[p.getY()][p.getX()])
					continue;
				else
					cache[p.getY()][p.getX()] = p.getNumOfWall()+board[p.getY()][p.getX()];
			}
			// No exist cache
			cache[p.getY()][p.getX()] = p.getNumOfWall()+board[p.getY()][p.getX()];

			stack.push(new Pos(p.getX()+1, p.getY(), cache[p.getY()][p.getX()]));
			stack.push(new Pos(p.getX()-1, p.getY(), cache[p.getY()][p.getX()]));
			stack.push(new Pos(p.getX(), p.getY()+1, cache[p.getY()][p.getX()]));
			stack.push(new Pos(p.getX(), p.getY()-1, cache[p.getY()][p.getX()]));
		}

		System.out.println(min);
	}

	static void init(int N, int M) {
		int i, j;
		String input;
		board = new int [M][N];
		cache = new int [M][N];

		for (i=0; i<M; i++) {
			input = sc.nextLine();
			for (j=0; j<N; j++) {
				board[i][j] = input.charAt(j)-48;
				cache[i][j] = -1;
			}
		}
	}
}

class Pos {
	private int x, y, numOfWall;

	Pos (int x, int y, int numOfWall) {
		this.x = x;
		this.y = y;
		this.numOfWall = numOfWall;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getNumOfWall() {
		return numOfWall;
	}
}
