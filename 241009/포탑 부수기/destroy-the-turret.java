import java.util.*;

public class Main {
	public static int[][] history, board;
	public static int N, M, K;
	static boolean check;
	static int[] dy = {0, 1, 0, -1};
	static int[] dx = {1, 0, -1, 0};
	static boolean[][] isActive;
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		
		board = new int[N+1][M+1];
		history = new int[N+1][M+1];
		isActive = new boolean[N+1][M+1];

		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= M; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		
		for(int turn = 1; turn <= K; turn++) {
			// Attacker selection
			init();
			List<Tower> list = new ArrayList<>();
			for(int y =1; y <= N; y++) {
				for(int x = 1; x <= M; x++) {
					if(board[y][x] <= 0) continue;
					Tower t = new Tower(board[y][x], y, x, history[y][x]);
					list.add(t);
				}
			}
			Collections.sort(list);
			Tower attack = list.get(0);
			board[attack.y][attack.x] += N+M;
			attack.power += N+M;
			history[attack.y][attack.x] = turn;
			
			Tower defender = list.get(list.size()-1);
			for(int i = list.size() -1; i >= 0; i--) {
				defender = list.get(i);
				if(defender.y != attack.y || defender.x != attack.x) break;
			}
			
			boolean isLaser = laserAttack(attack.y, attack.x, defender.y, defender.x);
			if(!isLaser) {
				bomb(attack.y, attack.x, defender.y, defender.x);
			}
			
			// heal
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j  <= M; j++) {
					if(board[i][j] <= 0) continue;
					if(i == attack.y && j == attack.x) continue;
					if(isActive[i][j]) continue;
					board[i][j] += 1;
				}
			}
//			print(board);

		}
		
		int ans = 0;
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= M; j++) {
				ans = Math.max(ans, board[i][j]);
			}
		}
		System.out.println(ans);
	}
	
	static void bomb(int r, int c, int ty, int tx) {
		int[] dy2 = {-1, -1, 0, 1, 1, 1, 0, -1};
		int[] dx2 = {0, 1, 1, 1, 0, -1, -1, -1};
		int power = board[r][c];
		board[ty][tx] -= power;
		isActive[ty][tx] = true;
		
		for(int i = 0; i < 8; i++) {
			int ny = ty + dy2[i];
			int nx = tx + dx2[i];
			if(out(ny,nx)) {
				Pair nextP = over(ny,nx);
				ny = nextP.y;
				nx = nextP.x;
			}
			if(board[ny][nx] <= 0) continue;
			if(ny == r && nx == c) continue;
			board[ny][nx] -= (power / 2);
			if(board[ny][nx] <= 0) board[ny][nx] = 0;
			isActive[ny][nx] = true;
		}
		
	}
	
	static boolean laserAttack(int r, int c, int ty, int tx) {
		boolean[][] visit = new boolean[N+1][M+1];
		int[][] backY = new int[N+1][M+1];
		int[][] backX = new int[N+1][M+1];
		
		Deque<Pair> q = new ArrayDeque<>();
		
		q.offer(new Pair(r,c));
		visit[r][c] = true;
		boolean isPossible = false;
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			
			int y = p.y;
			int x= p.x;
			
			if(y == ty && x == tx) {
				isPossible = true;
				break;
			}
			
			for(int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];

				if(out(ny,nx)) {
					Pair nextP = over(ny,nx);
					ny = nextP.y;
					nx = nextP.x;
				}
				if(board[ny][nx] <= 0) continue;
				if(visit[ny][nx]) continue;
				visit[ny][nx] = true;
				backY[ny][nx] = y;
				backX[ny][nx] = x;
				
				q.offer(new Pair(ny,nx));
			}
		}
		
		if(isPossible) {
			board[ty][tx] -= board[r][c];
			if(board[ty][tx] <= 0) board[ty][tx] = 0;
			isActive[ty][tx] = true;
			
			int ey = backY[ty][tx];
			int ex = backX[ty][tx];
			
			while (!(ey == r && ex == c)) {
				board[ey][ex] -= (board[r][c] / 2);
				if(board[ey][ex] <= 0) board[ey][ex] = 0;
				isActive[ey][ex] = true;
				
				int nextY = backY[ey][ex];
				int nextX = backX[ey][ex];
				ey = nextY;
				ex = nextX;
				
			}
		}
		return isPossible;
		
	}
	
	static void print(int[][] doubleArr) {
		for(int i =1; i<= N; i++) {
			for(int j =1; j <= M; j++) {
				System.out.print(doubleArr[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	static boolean out(int y, int x) {
		return y < 1 || N < y || x < 1 || M < x;
	}
	
	static Pair over(int ny, int nx) {
		if(ny > N) {
			ny -= N;
		} else if(ny < 1) {
			ny = N;
		}
		
		if(nx > M) {
			nx -= M;
		} else if(nx <1) {
			nx = M;
		}
		return new Pair(ny,nx);
	}
	
	static void init() {
		for(int i = 0; i <= N; i++) {
			for(int j = 0; j <= M; j++) {
				isActive[i][j] = false;
			}
		}
	}
}


class Tower implements Comparable<Tower>{
	int power, y, x, story;
	
	public Tower(int power, int y, int x, int story) {
		this.power = power;
		this.y = y;
		this.x = x;
		this.story = story;
	}
	
	@Override
	public int compareTo(Tower o) {
		if(this.power != o.power) return Integer.compare(this.power, o.power);
		if(this.story != o.story) return Integer.compare(o.story, story);
		if((this.y + this.x) != (o.y + o.x)) return Integer.compare(o.y + o.x, this.y + this.x);
		return Integer.compare(o.x, this.x);
	}
	
	@Override
	public String toString() {
		return "power: "+this.power + " y:" + this.y + " x:" + this.x;
	}
	
}

class Pair{
	int y,x;
	public Pair(int y, int x) {
		this.y = y;
		this.x = x;
	}
	
	@Override
	public String toString() {
		return "y:" + this.y + " x:" + this.x;
	}
}