import java.util.*;
public class Main {
	static int L, N, Q;
	static int[][] board;
	static int[][] knights;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	static int[] live;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		L = sc.nextInt();
		N = sc.nextInt();
		Q = sc.nextInt();
		
		board = new int[L+1][L+1];
		
		for(int i =1; i <= L; i++) {
			for(int j =1; j <= L; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		
		knights = new int[N+1][5];
		live = new int[N+1];
		
		for(int i =1; i <= N; i++) {
			int r = sc.nextInt();
			int c= sc.nextInt();
			int h = sc.nextInt();
			int w = sc.nextInt();
			int k = sc.nextInt();
			live[i] = k;
			knights[i] = new int[] {r,c,h,w,k};
		}
		
		for(int i =0; i < Q; i++) {
			int id = sc.nextInt();
			int d = sc.nextInt();
			Set<Integer> set = bfs(id, d);
			
			if(set.size() == 1 && set.contains(-1)) continue;
			
			knights[id][0] += dy[d];
			knights[id][1] += dx[d];
			
			for(int idx : set) {
				knights[idx][0] += dy[d];
				knights[idx][1] += dx[d];
			}
			
			delete(set);
			

		}

		int ans = 0;
		for(int i =1; i <= N; i++) {
			if(knights[i][4] > 0) {
				ans += (live[i] - knights[i][4]);
			}
		}
		System.out.println(ans);
		
	}
	
	static void delete(Set<Integer> list) {
		for(int idx : list) {
			int[] knight = knights[idx];
			int r = knight[0];
			int c = knight[1];
			int h = knight[2];
			int w = knight[3];
			
			int num = 0;
			
			for(int y = r; y <r + h; y++) {
				for(int x = c; x < c + w; x++) {
					if (board[y][x] == 1) num++;
				}
			}
			knight[4] -= num;
		}
	}
	
	static Set<Integer> bfs(int id, int d){
		int[][] map = new int[L+1][L+1];
		for(int i = 1; i <= N; i++) {
			int[] knight = knights[i];
			int r = knight[0];
			int c = knight[1];
			int h = knight[2];
			int w = knight[3];
			int k = knight[4];
			if(k <= 0) continue;
			for(int y = r; y <r + h; y++) {
				for(int x = c; x < c + w; x++) {
					map[y][x] = i;
				}
			}
		}
		
		Set<Integer> result = new HashSet<>();
		
		Deque<int[]> q = new ArrayDeque<>();
		List<int[]> l = getCan(id, d);
		for(int i =0; i < l.size(); i++) {
			q.offer(l.get(i));
		}
		while(!q.isEmpty()) {
			int[] arr = q.poll();
			
			int y = arr[0];
			int x= arr[1];
			if(out(y,x) || board[y][x] == 2) {
				result.clear();
				result.add(-1);
				return result;
			};
			
			if(result.contains(map[y][x])) continue;

			if(map[y][x] > 0) {
				int idx = map[y][x];
				result.add(idx);
				List<int[]> nextL = getCan(idx, d);
				for(int i =0; i < nextL.size(); i++) {
					q.offer(nextL.get(i));
				}
			}
		}
		return result;
	}
		
	static boolean out(int y, int x) {
		return y < 1 || L < y || x < 1 || L < x;
	}
	
	
	static List<int[]> getCan(int id, int d){
		int[] knight = knights[id];
		int r = knight[0];
		int c = knight[1];
		int h = knight[2];
		int w = knight[3];
		int k = knight[4];
		
		List<int[]> result = new ArrayList<>();
		
		if(d == 0) {
			for(int i = 0; i < w; i++) {
				result.add(new int[] {r-1, c+i});
			}
		}else if(d==1) {
			for(int i =0; i < h; i++) {
				result.add(new int[] {r+i, c+w});
			}
		} else if(d==2) {
			for(int i =0; i < w; i++) {
				result.add(new int[] {r+h, c+i});
			}
		} else if(d==3) {
			for(int i =0; i < h; i++) {
				result.add(new int[] {r+i, c-1});
			}
		}
		return result;
	}
}