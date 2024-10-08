import java.util.*;

public class Main {
	static int K, M;
	static int[] wall;
	static int[][] board;
	static int N = 5;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	static int wIdx = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		K = sc.nextInt();
		M = sc.nextInt();
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
			if(o1[3] != o2[3]) {
				return o2[3] - o1[3]; 
			}
			if(o1[2] != o2[2]) {
				return o1[2] - o2[2];
			}
			if(o1[1] != o2[1]) {
				return o1[1] - o2[1];
			}
			return o1[0] - o2[0];
		});
		
		board = new int[N][N];
		for(int i =0; i < N; i++) {
			for(int j =0; j < N; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		wall = new int[M];
		for(int i =0; i < M; i++) {
			wall[i] = sc.nextInt();
		}
		
		for(int turn = 0; turn < K; turn++) {
			for(int i =1; i < N - 1; i++) {
				for(int j =1; j < N - 1; j++) {
					for(int k  =1; k < 4; k++) {
						int v = rotate(i,j,k);
						pq.offer(new int[] {i, j, k, v});
					}
				}
			}
			
			int[] l = pq.poll();
			execRotate(l[0], l[1], l[2]);
			int ans = 0;
			List<int[]> element = go(board);
			ans += calScore(element);
			while(!element.isEmpty()) {
				deleteBoard(element);
				fill();
				element = go(board);
				ans += calScore(element);
			}
			//print();
			if(ans <= 0) break;
            System.out.print(ans + " ");

			pq.clear();
		}
	}
	
	public static void print() {
		for(int i =0; i < N; i++) {
			System.out.println(Arrays.toString(board[i]));
		}
	}
	
	static void fill() {
		for(int x = 0; x < N; x++) {
			for(int y = N-1; y >= 0; y--) {
				if(board[y][x] == 0) board[y][x] = wall[wIdx++];
			}
		}
	}
	
	public static void deleteBoard(List<int[]> l) {
		boolean[][] visit = new boolean[N][N];
		for(int i =0; i< l.size(); i++) {
			int[] arr = l.get(i);
			int r = arr[0];
			int c = arr[1];
			
			int v= board[r][c];
			board[r][c] = 0;
			visit[r][c] = true;
			Deque<int[]> q = new ArrayDeque<>();
			q.offer(new int[] {r,c});
			
			while(!q.isEmpty()) {
				int[] line = q.poll();
				int y = line[0];
				int x = line[1];
				
				for(int k =0; k < 4; k++) {
					int ny = y + dy[k];
					int nx = x + dx[k];
					
					if(out(ny, nx)) continue;
					
					if(visit[ny][nx]) continue;
					if(v == board[ny][nx]) {
						visit[ny][nx] = true;
						q.offer(new int[] {ny,nx});
						board[ny][nx] = 0;
					}
				}
			}
		}
	}
	
	public static int rotate(int y, int x, int cycle) {
		int sy = y - 1;
		int sx = x - 1;
		int ey = y +1;
		int ex = x + 1;
		int[][] temp = copyBoard();
		int[][] t1 = new int[3][3];
		
		for(int i = sy; i <= ey; i++) {
			for(int j = sx; j <= ex; j++) {
				t1[i-sy][j-sx] = temp[i][j];
			}
		}
		
		int[][] t2; 
		
		for(int k = 0; k < cycle; k++) {
			t2 = new int[3][3];
			for(int i =0; i < 3; i++) {
				for(int j =0; j < 3; j++) {
					t2[j][2-i] = t1[i][j];
				}
			}
			t1 = t2;
		}
		for(int i = sy; i <= ey; i++) {
			for(int j = sx; j <= ex; j++) {
				temp[i][j] = t1[i-sy][j-sx];
			}
		}	
		List<int[]> l = go(temp);
		int result = calScore(l);
		return result;
	}
	
	static int calScore(List<int[]> l) {
		int result = 0;
		for(int i =0; i < l.size(); i++) {
			int[] arr = l.get(i);
			result += arr[2];
		}
		return result;
	}
	
	static void execRotate(int y, int x, int cycle) {
		int sy = y - 1;
		int sx = x - 1;
		int ey = y +1;
		int ex = x + 1;
		int[][] t1 = new int[3][3];
		
		for(int i = sy; i <= ey; i++) {
			for(int j = sx; j <= ex; j++) {
				t1[i-sy][j-sx] = board[i][j];
			}
		}
		
		int[][] t2; 
		
		for(int k = 0; k < cycle; k++) {
			t2 = new int[3][3];
			for(int i =0; i < 3; i++) {
				for(int j =0; j < 3; j++) {
					t2[j][2-i] = t1[i][j];
				}
			}
			t1 = t2;
		}
		for(int i = sy; i <= ey; i++) {
			for(int j = sx; j <= ex; j++) {
				board[i][j] = t1[i-sy][j-sx];
			}
		}	
	}
	
	public static int[][] copyBoard() {
		int[][] copy = new int[N][N];
		for(int i =0; i < N;i++) {
			for(int j =0; j < N; j++) {
				copy[i][j] = board[i][j];
			}
		}
		return copy;
	}
	
	static List<int[]> go(int[][] map) {
		List<int[]> result = new ArrayList<>();
		boolean[][] visit = new boolean[N][N];
		
		for(int i =0; i < N; i++) {
			for(int j =0; j < N; j++) {
				if(visit[i][j]) continue;
				
				int num = 1;
				int v= map[i][j];
				visit[i][j] = true;
				Deque<int[]> q = new ArrayDeque<>();
				q.offer(new int[] {i,j});
				
				while(!q.isEmpty()) {
					int[] line = q.poll();
					int y = line[0];
					int x = line[1];
					
					for(int k =0; k < 4; k++) {
						int ny = y + dy[k];
						int nx = x + dx[k];
						
						if(out(ny, nx)) continue;
						
						if(visit[ny][nx]) continue;
						if(v == map[ny][nx]) {
							visit[ny][nx] = true;
							num++;
							q.offer(new int[] {ny,nx});
						}
					}
				}
				if (num >= 3) {
					result.add(new int[] {i, j, num});
				}
			}
		}
		return result;
	}
	
	static boolean out(int y, int x) {
		return y < 0 || N <= y || x < 0 || N <= x;
	}
}