import java.util.*;
public class Main {
	static Santa[] santas;
	static int[] scores;
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
		scores = new int[P+1];
		
		for(int i =0; i < P; i++) {
			p = sc.nextInt();
			r = sc.nextInt();
			c = sc.nextInt();
			
			santas[p] = new Santa(r,c);
		}
		
		while(Turn < M) {	
			int closedS = findCloseSanta();
			int dRoo = moveRoo(closedS);
			for(int i =1; i <= P; i++) {
				conflict(i, dRoo, C);
			}
			int[] dirs = moveSanta();
			for(int i = 1; i <= P; i++) {
				int reversedD = (dirs[i] + 4) % 8;
				conflict(i, reversedD, D);
			}
			scoreAfterTurn();
			//System.out.println(roo);
			//for(int i =1; i <= P; i++) {
			//	System.out.println(santas[i]);
			//}
			//System.out.println(Arrays.toString(scores));
			//System.out.println();
			Turn++;
		}
		System.out.println(Arrays.toString(scores).replaceAll("[\\[\\],]", ""));

	}
	
	static void scoreAfterTurn() {
		for(int i =1; i <= P; i++) {
			if(santas[i].out) continue;
			scores[i]++;
		}
	}
	
	static void conflict(int id, int dir, int V) {
		if(dir < 0) return;
		Santa santa = santas[id];
		if(santa.r == roo.r && santa.c == roo.c) {
			scores[id] += V;
			moveOneSanta(id, dir, V);
			int other = meet(id);
			if(other < 0) return;
			interaction(id, other, dir);
		}
	}
	
	static void interaction(int p1, int p2, int d) {
		Santa santa1 = santas[p1];
		Santa santa2 = santas[p2];

		santa2.r += dy[d];
		santa2.c += dx[d];
		santas[p2] = santa2;
		while(!out(santa2.r, santa2.c) && meet(p2) >= 0) {
			int other = meet(p2);
			santa2 = santas[other];
			santa2.r += dy[d];
			santa2.c += dx[d];
			santas[other] = santa2;
		}
		if(out(santa2.r, santa2.c)) {
			santa2.out = true;
		}
	}
	
	static int meet(int id) {
		Santa santa = santas[id];
		for(int i =1; i <= P; i++) {
			if(id == i) continue;
			if(santa.r == santas[i].r && santa.c == santas[i].c) {
				return i;
			}
		}
		return -1;
	}
	
	static void moveOneSanta(int id, int d, int cycle) {
		Santa santa = santas[id];
		for(int i = 0; i < cycle; i++) {
			santa.r += dy[d];
			santa.c += dx[d];
		}
		
		if(out(santa.r, santa.c)) {
			santa.out = true;
		}
		santa.panic = Turn + 2;
		santas[id] = santa;
	}
	
	
	static int[] moveSanta() {
		Set<String> set = new HashSet<>();
		for(int i =1; i <= P; i++) {
			Santa santa =santas[i];
			set.add(santa.r + "," + santa.c);
		}
		int[] dirs = new int[P+1];
		for(int i =1; i <= P; i++) {
			Santa santa = santas[i];
			if(santa.out) continue;
			if(santa.panic > Turn) continue;
			
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
				String s = new String(santa.r+ ","+ santa.c);
				set.remove(s);
				santa.r += dy[d];
				santa.c += dx[d];
				santas[i] = santa;
				s = new String(santa.r+ ","+ santa.c);
				set.add(s);
			}
			dirs[i] = d;
		}
		return dirs;
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
	
	static int moveRoo(int target) {
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
		if(d < 0) return d;
		roo.r += dy[d];
		roo.c += dx[d];
		return d;
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