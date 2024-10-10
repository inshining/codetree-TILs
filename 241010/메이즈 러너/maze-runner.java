import java.util.*;

public class Main {
	static int N, M, K;
	static int[][] board;
	static int[] score;
	static int[] exit;
	static boolean[] isExit;
	static int[][] pos;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, 1, -1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		
		score = new int[M];
		isExit = new boolean[M];
		
		board = new int[N+1][N+1];
		for(int i =1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		
		pos = new int[M][2];
		for(int i =0; i < M; i++) {
			int y = sc.nextInt();
			int x = sc.nextInt();
			pos[i][0] = y;
			pos[i][1] = x;
		}
		
		exit = new int[2];
		exit[0] = sc.nextInt();
		exit[1] = sc.nextInt();
		
		for(int turn = 0; turn < K; turn++) {
			int numExit = 0;
			for(int i =0; i< M; i++) {
				if(isExit[i]) numExit++;
				else move(i);
			}
			if(numExit == M) break;
			rotate();
//			System.out.println(Arrays.toString(score));
//			System.out.println(Arrays.toString(exit));

		}
//		print(pos);
//		print(board);
		int ans = 0;
		for(int i =0; i<M; i++) {
			ans += score[i];
		}
		System.out.println(ans);

		System.out.println(exit[0] + " " + exit[1]);

	}
	
	public static void rotate() {
		int[] arr = search();
		int sy = arr[0];
		int sx = arr[1];
		int size = arr[2];
		
		for(int i = 0; i < M; i++) {
			int y = pos[i][0];
			int x =pos[i][1];
			if(sy <= y && y < sy + size && sx <= x && x < sx + size) {
				board[y][x] = 10 + i;
			}
		}
		board[exit[0]][exit[1]] = -1;
		
		int[][] box = new int[size][size];
		for(int i = 0; i < size; i++) {
			for(int j =0; j < size; j++) {
				box[i][j] = board[sy+i][sx+j];
			}
		}
		
		int[][] temp = new int[size][size];
		
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				temp[j][size-1-i] = box[i][j];
			}
		}
		
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				if(1 <= temp[i][j] && temp[i][j] < 10) temp[i][j]--;
			}
		}
		
		for(int i = 0; i < size; i++) {
			for(int j =0; j < size; j++) {
				board[sy+i][sx+j] = temp[i][j];
			}
		}
		
		for(int i = 0; i < size; i++) {
			for(int j =0; j < size; j++) {
				if (board[sy+i][sx+j] >= 10) {
					int idx = board[sy+i][sx+j] - 10;
					pos[idx][0] = sy + i;
					pos[idx][1] = sx + j;
					board[sy+i][sx+j] = 0;
				} else if(board[sy+i][sx+j] == -1) {
					exit[0] = sy + i;
					exit[1] = sx + j;
					board[sy+i][sx+j] = 0;
				}
			}
		}				
	}
	
	static void print(int[][] doubleArr) {
		for(int i =0; i < doubleArr.length; i++) {
			System.out.println(Arrays.toString(doubleArr[i]));
		}
	}
	
	static int[] search() {
		// 회전 시킬 부분 찾을 때, 이차원 배열에 멤버 넘기(탈출 하지 못한 멤버만)
		int[][] map = new int[N+1][N+1];
		for(int i =0; i < M; i++) {
			if(isExit[i]) continue;
			int y = pos[i][0];
			int x = pos[i][1];
			map[y][x] = 1;
		}
		
		map[exit[0]][exit[1]] = 2;
		
		for(int size = 2; size <= N; size++) {
			for(int sy = 1; sy <= N - size + 1; sy++) {
				for(int sx = 1; sx <= N - size + 1; sx++) {
					int num = 0;
					boolean include = false;
					for(int i = 0; i < size; i++) {
						for(int j = 0; j < size; j++) {
							if(map[sy+i][sx+j] == 1 ) num++;
							if(map[sy+i][sx+j] == 2 ) include = true;
						}
					}
					if(num > 0 && include) return new int[] {sy,sx, size};
				}
			}
		}
		return new int[] {-1, -1, -1};	
	}
		
	static void move(int id) {
		int y = pos[id][0];
		int x = pos[id][1];
		int originDist = calDist(y,x, exit[0], exit[1]);
		int d = -1;
		int dist = Integer.MAX_VALUE;
		for(int i =0; i< 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(out(ny, nx)) continue;
			if(board[ny][nx] > 0) continue;
			
			int nextDist = calDist(ny, nx, exit[0], exit[1]);
			if(dist > nextDist) {
				dist = nextDist;
				d = i;
			}
		}
		
		if(d == -1 || dist > originDist) return;
		
		int ny = y + dy[d];
		int nx = x + dx[d];
		pos[id][0] = ny;
		pos[id][1] = nx;
		if(ny == exit[0] && nx == exit[1]) {
			isExit[id] = true;
		}
		score[id]++;
		// pos[id] = 
	}
	
	static int calDist(int x1, int y1, int x2, int y2) {
		return (int) (Math.abs(x1-x2) + Math.abs(y1-y2));
	}
	
	static boolean out(int y, int x) {
		return y < 1 || N < y || x < 1 || N < x;
	}
}