import java.awt.Point;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Point[] point = {
		new Point (1, 0),				// →
		new Point (0, 1),				// ↓
		new Point (-1, 0),			// ←
		new Point (0, -1)				// ↑
	};

	static int INF = 987654321;

	static Map<Integer, char[][]> mapBoard = new HashMap<Integer, char[][]>();
	static int N, M, newX, newY;
	static Pos curPos;
	static Queue<Pos> w = new LinkedList<Pos>();
	static int[][][] cache;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		char[][] board;
		boolean isPossible = false;
		Queue<Pos> q = new LinkedList<Pos>();
		Pos target = null, curPos=null;

		N = sc.nextInt();		M = sc.nextInt();		sc.nextLine();
//		board = new char[N][M];
		mapBoard.put(0, new char[N][M]);
//		vecBoard.add(new char[N][M]);
		cache = new int[2][N][M];

	         String s = sc.nextLine();
	         for(int j=0; j<M; j++){
	        	 cache[0][i][j] = cache[1][i][j] = INF;

	        	 mapBoard.get(0)[i][j] = s.charAt(j);
//	        	 board[i][j] = s.charAt(j);
	        	 if (mapBoard.get(0)[i][j] == 'D')
	        		 target = new Pos(i, j, -1);
				else if (mapBoard.get(0)[i][j] == 'S') {
					mapBoard.get(0)[i][j] = '.';
					cache[0][i][j] = 0;
					q.add(new Pos(i, j, 0));
				}
				else if (mapBoard.get(0)[i][j] == '*') {
					cache[1][i][j] = 1;
					w.add(new Pos(i, j, 0));
				}
	         }
	      }

//		for (int i=0; i<N; i++) {
//			for (int j=0; j<M; j++) {
//				System.out.print(mapBoard.get(0)[i][j] + " ");
//			}
//			System.out.println();
//		}

		while (!q.isEmpty() && target != null) {
			curPos = q.poll();
//			System.out.println("Log/X: " + curPos.getX() + " Y: " + curPos.getY());
			if (curPos.getX() == target.getX() && curPos.getY() == target.getY()) {
				isPossible = true;
				break;
			}

			if (!setBoard(curPos))
				continue;

			for (int k=0; k<point.length; k++) {
				newX = curPos.getX() + point[k].x;
				newY = curPos.getY() + point[k].y;

				if (newX < N && newX >= 0 && newY < N && newY >= 0 && (mapBoard.get(curPos.getCount())[newX][newY] == '.' || mapBoard.get(curPos.getCount())[newX][newY] == 'D') && curPos.getCount()+1 < cache[0][newX][newY]) {
					cache[0][newX][newY] = curPos.getCount()+1;
					q.offer((new Pos(newX, newY, curPos.getCount()+1)));
				}
			}
			mapBoard.get(curPos.getCount())[curPos.getX()][curPos.getY()] = '.';
		}

		if (isPossible)
			System.out.println(curPos.getCount());
		else
			System.out.println("KAKTUS");
	}

	static boolean setBoard(Pos curSPos) {
		int count = curSPos.getCount();
		if (!mapBoard.containsKey(count)) {
			mapBoard.put(count, new char[N][M]);

			for (int i=0; i<N; i++) {
				for (int j=0; j<M; j++) {
					if (mapBoard.get(count-1)[i][j] == 'S')
						mapBoard.get(count)[i][j] = '.';
					else
						mapBoard.get(count)[i][j] = mapBoard.get(count-1)[i][j];
				}
			}

			while(!w.isEmpty()) {
				if (count <= w.peek().getCount())
					break;
				curPos = w.poll();
				for (int k=0; k<point.length; k++) {
					newX = curPos.getX() + point[k].x;
					newY = curPos.getY() + point[k].y;

					if (newX < N && newX >= 0 && newY < N && newY >= 0 && mapBoard.get(count)[newX][newY] == '.' && cache[1][newX][newY] == INF) {
						cache[1][newX][newY] = 1;
						mapBoard.get(count)[newX][newY] = '*';
						w.offer(new Pos(newX, newY, curPos.getCount()+1));
					}
				}
			}
		}



		if (mapBoard.get(count)[curSPos.getX()][curSPos.getY()] == '*')
			return false;
		else {
			mapBoard.get(count)[curSPos.getX()][curSPos.getY()] = 'S';
//			System.out.println(count +": X");
//			for (int i=0; i<N; i++) {
//				for (int j=0; j<M; j++) {
//					System.out.print(mapBoard.get(count)[i][j] + " ");
//				}
//				System.out.println();
//			}
		}
		return true;

	}
}

class Pos {
	int x, y, count;

	Pos (int x, int y, int count) {
		this.x = x;
		this.y = y;
		this.count = count;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getCount() {
		return count;
	}
}
