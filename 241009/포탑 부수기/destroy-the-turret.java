import java.util.*;
public class Main {
	public static int[][] history, board;
	public static int N, M, K;
	static boolean check;
	static int[] dy = {0, 1, 0, -1};
	static int[] dx = {1, 0, -1, 0};
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		
		board = new int[N+1][M+1];
		history = new int[N+1][M+1];
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= M; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		
		for(int i =0; i <= N; i++) {
			System.out.println(Arrays.toString(board[i]));
		}
		
		// Attacker selection
		List<Tower> list = new ArrayList<>();
		for(int y =1; y <= N; y++) {
			for(int x = 1; x <= M; x++) {
				if(board[y][x] <= 0) continue;
				Tower t = new Tower(board[y][x], y, x, history[y][x]);
				list.add(t);
			}
		}
//		if(list.size() <= 1) break;
		Collections.sort(list);
		Tower attack = list.get(0);
		board[attack.y][attack.x] += N+M;
		attack.power += N+M;
		
		Tower defender = list.get(list.size()-1);
		for(int i = list.size() -1; i >= 0; i--) {
			defender = list.get(i);
			if(defender.y != attack.y || defender.x != attack.x) break;
		}
		
		List<Pair> route = searchRoute(attack.y, attack.x, defender.y, defender.x);
		
		System.out.println(route);
		
		System.out.println(defender);

	}
	
	static List<Pair> searchRoute(int r, int c, int ty, int tx) {
		int[][] visit = new int[N+1][M+1];
		Deque<Pair> q = new ArrayDeque<>();
		
		q.offer(new Pair(r,c));
		visit[r][c] =1;
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			
			int y = p.y;
			int x= p.x;
			
			if(y == ty && x == tx) {
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
				if(board[ny][nx] == 0) continue;
				if(visit[ny][nx] > 0) continue;
				visit[ny][nx] = visit[y][x] + 1;
				q.offer(new Pair(ny,nx));
			}
			print(visit);
			System.out.println();
		}
		if(visit[ty][tx] == 0) return new ArrayList<>();
		
		List<Pair> route = new ArrayList<>();
		q = new ArrayDeque<>();
		q.offer(new Pair(ty,tx));
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			int y=p.y;
			int x= p.x;
			for(int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				if(out(ny,nx)) {
					Pair nextP = over(ny,nx);
					ny = nextP.y;
					nx = nextP.x;
				}
				if(board[ny][nx] == 0) continue;
				if(visit[ny][nx] == visit[y][x] -1) {
					if(visit[ny][nx] == 1) break;
					Pair nP = new Pair(ny,nx);
					route.add(nP);
					q.offer(nP);
				}
			}
		}
		return route;
		
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