import java.util.*;
public class Main {
	static Santa[] santas;
	static int N, M, P, C, D, Turn;
	static Roo roo;
	static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		P = sc.nextInt();
		C = sc.nextInt();
		D = sc.nextInt();
		
		int p, r, c;
		r = sc.nextInt();
		c = sc.nextInt();
		roo = new Roo(r,c);
		
		santas = new Santa[P+1];
		for(int i =0; i < P; i++) {
			p = sc.nextInt();
			r = sc.nextInt();
			c = sc.nextInt();
			
			santas[p] = new Santa(r,c);
		}
		
		int closedS = findCloseSanta();
		moveRoo(closedS);
		moveSanta();
		System.out.println(roo);
		for(int i =1; i <= P; i++) {
			System.out.println(santas[i]);
		}
	}
	
	static void moveSanta() {
		Set<String> set = new HashSet<>();
		for(int i =1; i <= P; i++) {
			Santa santa =santas[i];
			set.add(santa.r + "," + santa.c);
		}
		for(int i =1; i <= P; i++) {
			Santa santa = santas[i];
			if(santa.out) continue;
			if(santa.panic <= Turn) continue;
			
			int originDist = calDist(roo.r, roo.c, santa.r, santa.c);
			int d = -1;
			int minDist = Integer.MAX_VALUE;
			for(int j =0; j < 8; j+=2) {
				int ny = santa.r + dy[j];
				int nx = santa.c + dx[j];
				if(out(ny,nx)) continue;
				String s = new String(ny + "," + nx);
				if(set.contains(s)) continue;
				int nextDist = calDist(roo.r, roo.c, ny, nx);
				if(nextDist >= originDist) continue;
				
				if(minDist > nextDist) {
					minDist = nextDist;
					d = j;
				}
			}
			if(d >= 0) {
				santa.r += dy[d];
				santa.c += dx[d];
				santas[i] = santa;
			}
		}
	}
	
	static int findCloseSanta() {
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
			if(o1[2] != o2[2]) return o1[2] - o2[2];
			if(o1[0] != o2[0]) return o2[0] - o1[0];
			return o2[1] - o1[1];
			
		});
		
		for(int i =1; i <= P; i++) {
			Santa santa = santas[i];
			
			if(santa.out) continue;
			int dist = roo.calDist(santa);
			pq.offer(new int[] {santa.r, santa.c, dist, i});
		}
		if(pq.size() <= 0) return -1;
		int[] arr = pq.poll();
		return arr[3];
	}
	
	static void moveRoo(int target) {
		Santa santa = santas[target];
		
		int d = -1;
		int dist = Integer.MAX_VALUE;
		for(int i = 0; i < 8; i++) {
			int ny = roo.r + dy[i];
			int nx = roo.c + dx[i];
			if(out(ny,nx)) continue;
			int betD = calDist(santa.r, santa.c, ny, nx);
			if(dist > betD ) {
				dist = betD;
				d = i;
			}
		}
		if(d < 0) return;
		roo.r += dy[d];
		roo.c += dx[d];
		
	}
	
	static int calDist(int r1, int c1, int r2, int c2) {
		return (int) (Math.pow(r1 - r2, 2) + Math.pow(c1 - c2, 2)); 
	}
	
	
	static boolean out(int y, int x) {
		return y < 1 || N < y || x < 1 || N < x;
	}
}

class Unit implements Comparable<Unit>{
	int r, c;
	
	public int calDist(Unit other) {
		return (int) (Math.pow(this.r - other.r, 2) + Math.pow(this.c - other.c, 2)); 
	}
	
	@Override
	public int compareTo(Unit other) {
		if (this.r != other.r) {
			return other.r - this.r;
		}
		return other.c - this.c;
	}
	
	@Override
	public String toString() {
		return this.r + " " + this.c;
	}
}
class Santa extends Unit{
	boolean out;
	int panic;
	
	public Santa(int r, int c) {
		this.r = r;
		this.c = c;
		this.out = false;
		this.panic = 0;
	}
}

class Roo extends Unit{
	
	public Roo(int r, int c) {
		this.r =r;
		this.c = c;
	}
}