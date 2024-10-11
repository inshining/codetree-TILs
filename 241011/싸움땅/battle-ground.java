import java.util.*;

public class Main {
	static int N, M, K;
	static List[][] board;
	static Player[] players;
	
	static int[] scores = new int[30];
	
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		
		players = new Player[M];
		board = new List[N+1][N+1];
		
		for(int i = 0; i <= N; i++) {
			for(int j = 0; j<=N; j++) {
				board[i][j] = new ArrayList<Integer>();
			}
		}
		
		for(int i = 1; i <= N; i++) {
			for(int j =1; j <= N; j++) {
				board[i][j].add(sc.nextInt());
			}
		}
		
		for(int i = 0; i < M; i++) {
			int y = sc.nextInt();
			int x = sc.nextInt();
			int d = sc.nextInt();
			int s = sc.nextInt();
			
			players[i] = new Player(y,x,d,s);
		}
		
		for(int i =0; i < M; i++) {
			move(i);
			int other = isMeet(i);
			if(other >= 0) {
				//싸
				battle(i, other);
			} else {
				//총교
				changeGun(i);
			}
		}
		
//		for(int i = 0; i < M; i++) {
//			System.out.println(players[i]);
//		}
		//System.out.println(Arrays.toString(scores));
		for(int i = 0; i < M; i++) {
			System.out.print(scores[i] + " ");
		}
	}
	
	static void battle(int a, int b) {
		int at = players[a].getAttack();
		int bt = players[b].getAttack();
		
		int win = -1;
		int loser = -1;
		if(at != bt) {
			if(at > bt) {
				win = a;
				loser = b;
			} else {
				win = b;
				loser = a;
			}
		}else {
			int ac = players[a].power;
			int bc = players[b].power;
			if(ac > bc) {
				win = a;
				loser = b;
			}else {
				win = b;
				loser = a;
			}
		}
		
		// 점수
		int diff = players[win].getAttack() - players[loser].getAttack();
		scores[win] += diff;
		
		// 진사람 
		dropGunGround(loser);
		loserMove(loser);
		changeGun(loser);
		
		// winner
		changeGun(win);
	}
	
	static void loserMove(int id) {
		int r = players[id].r;
		int c = players[id].c;
		int d= players[id].d;
		
		for(int i = 0; i < 4; i++) {
			int nd = (d + i) % 4;
			int ny = r + dy[nd];
			int nx = c + dx[nd];
			
			if(out(ny,nx)) continue;
			int k = isMeet(ny,nx);
			if(k >= 0) continue;
			
			players[id].r = ny;
			players[id].c = nx;
			players[id].d = nd;
			break;
		}
	}
	
	static void dropGunGround(int id) {
		int r = players[id].r;
		int c= players[id].c;
		int preGun = players[id].dropGun();
		if(preGun >0) {
			board[r][c].add(preGun);
		}
	}
	
	static void changeGun(int id) {
		dropGunGround(id);
		
		int r = players[id].r;
		int c= players[id].c;
		
		if(board[r][c].size() > 0) {
			int k = (int) Collections.max(board[r][c]);
			for(int i =0; i < board[r][c].size(); i++) {
				if(k == (int) board[r][c].get(i)) board[r][c].remove(i);
			}
			players[id].gun = k;
		}
	}
	
	static int isMeet(int id) {
		for(int i = 0; i < M; i++) {
			if(i == id) continue;
			if(players[id].r == players[i].r && players[id].c == players[i].c) {
				return i;
			}
		}
		return -1;
	}
	
	
	static int isMeet(int r, int c) {
		for(int i = 0; i < M; i++) {
			if(r == players[i].r && c == players[i].c) {
				return i;
			}
		}
		return -1;
	}
	
	static void move(int id) {
		Player player = players[id];
		
		int r = player.r;
		int c = player.c;
		int d = player.d;
		
		int ny = r + dy[d];
		int nx = c + dx[d];
		
		if(out(ny, nx)){
			d = (d + 2) % 4;
			ny = r + dy[d];
			nx = c + dx[d];
		}
		
		player.r = ny;
		player.c = nx;
		player.d = d;
		
	}
	
	static boolean out(int y, int x) {
		return y < 1 || N < y || x < 1 || N < x;
	}
}

class Player{
	int r,c, power, gun, d;
	public Player(int r, int c, int d, int power) {
		this.r = r;
		this.c = c;
		this.d = d;
		this.power = power;
	}
	
	public int dropGun() {
		int v = this.gun;
		this.gun = 0;
		return v;
	}
	
	public void setGun(int g) {
		this.gun = g;
	}
	
	public int getAttack() {
		return this.power + this.gun;
	}
	
	@Override
	public String toString() {
		return "pos " + this.r + " " + this.c + " dir:" + this.d + " gun" + this.gun;
	}
}