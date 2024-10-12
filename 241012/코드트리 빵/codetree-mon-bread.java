import java.util.*;

public class Main {
	static int[][] board;
	static boolean[][] banned;

	static int N, M;
	static int[] dy = {-1, 0, 0, 1};
	static int[] dx = {0, -1, 1, 0};
	static Player[] players;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		players = new Player[M];
		board = new int[N][N];
		banned = new boolean[N][N];
		
		int[][] targets = new int[M][2];
		
		for(int i =0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		for(int i = 0; i < M; i++) {
			int y = sc.nextInt();
			int x = sc.nextInt();
			targets[i] = new int[] {y,x};
		}
		
		int time = 0;
		while(true) {
			// 1. move
			int cnt = Math.min(time, M);
			for(int i = 0; i < cnt; i++) {
				Player p = players[i];
				if(p.isStop()) continue;
				int d = findDir(p.y, p.x, p.ty, p.tx);
				if(d >= 0) {
					p.y += dy[d];
					p.x += dx[d];
				}
			}
			
			// 2. ban 
			int num = 0;
			for(int i = 0; i < cnt; i++) {
				Player p = players[i];
				if(p.isStop()) {
					banned[p.y][p.x] = true; 
					num++;
				};
			}
			
			if(num == M) break;
			
			//3 find camp
			if(time < M) {
				int ty = targets[time][0];
				int tx = targets[time][1];
				ty -= 1;
				tx -= 1;
				Move camp = findCamp(ty, tx);
				banned[camp.y][camp.x]= true;
				players[time] = new Player(camp.y, camp.x, ty, tx);
			}		
			time++;
		}
		time++;
		System.out.println(time);
	}
	
	static int findDir(int y, int x, int ty, int tx) {
		if(y == ty && x == tx) return -1;
		int d = -1;
		boolean[][] visit = new boolean[N][N];
		
		visit[y][x] = true;
		
		Deque<Move> q = new ArrayDeque<>();
		
		
		for(int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(out(ny, nx)) continue;
			if(banned[ny][nx]) continue;
			q.offer(new Move(ny, nx, i));
			visit[ny][nx] = true;
		}
		
		while(!q.isEmpty()) {
			Move t = q.poll();
			if(t.y == ty && t.x == tx) return t.d;
			for(int i = 0; i < 4; i++) {
				int ny = t.y + dy[i];
				int nx = t.x + dx[i];
				
				if(out(ny,nx)) continue;
				if(banned[ny][nx]) continue;
				if(visit[ny][nx]) continue;
				visit[ny][nx] = true;
				q.offer(new Move(ny,nx, t.d));
			}
		}
		return -1;
	}
	
	static Move findCamp(int y, int x) {
		int[][] visit = new int[N][N];
		
		visit[y][x] = 1;
		
		Deque<Move> q = new ArrayDeque<>();
		
		q.offer(new Move(y,x,0));
		
		while(!q.isEmpty()) {
			Move m = q.poll();
			for(int i = 0; i < 4; i++) {
				int ny = m.y + dy[i];
				int nx = m.x + dx[i];
				
				if(out(ny,nx)) continue;
				if(banned[ny][nx]) continue;
				if(visit[ny][nx] > 0) continue;
				visit[ny][nx] = visit[m.y][m.x] + 1;
				q.offer(new Move(ny,nx, 0));
			}
		}
		List<Move> list = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			for(int j =0; j < N; j++) {
				if(banned[i][j]) continue;
				if(board[i][j] == 1) 
					list.add(new Move(i, j, visit[i][j]));
			}
		}
		Collections.sort(list);;
		return list.get(0);
	}
	
	public static boolean out(int y, int x) {
		return y < 0 || N <= y || x < 0 || N <= x;
	}
	
	static class Player{
		int y, x, ty, tx;
		
		public Player(int y, int x, int ty, int tx) {
			this.y = y;
			this.x = x;
			this.ty = ty;
			this.tx = tx;
		}
		
		public boolean isStop() {
			return y == ty && x == tx;
		}
	}
}

class Move implements Comparable<Move>{
	int y, x, d;
	
	public Move(int y, int x, int d) {
		this.y = y;
		this.x = x;
		this.d = d;
	}

	@Override
	public int compareTo(Move o) {
		if(this.d != o.d) {
			return this.d - o.d;
		}
		if(this.y != o.y)return this.y - o.y;
		return this.x - o.x;
	}
	
}