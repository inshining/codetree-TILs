import java.util.*;
public class Main {
    static int K, R, C;
	static int[][] board; 
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	
	static Map<Integer, Integer> map = new HashMap<>();
	static int idx = 1;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		board = new int[R][C];
		K = sc.nextInt();
		int answer = 0;
		for(int i =0; i <K; i++) {
			int c = sc.nextInt();
			int d = sc.nextInt();
			c--;
			int score = go(c, d);
			//print();
			//System.out.println(score);
			answer += score;
			//System.out.println(map);
			//System.out.println();
		}

//		int cycle = 3;
//		int d = 2;
//		if(cycle < 0) {
//			cycle = Math.abs(cycle) % 4;
//			for(int i =0; i < cycle; i++) {
//				d -= 1;
//				d = d % 4;
//			}
//		}
		
		System.out.println(answer);
		
	}
	
	static void print() {
		for(int i =0; i < R; i++) {
			System.out.println(Arrays.toString(board[i]));
		}
	}
		
	static boolean isLeft(int y, int x) {
		return (isEmpty(y, x-1) && isEmpty(y+1, x-1));
	}
	
	static boolean isRight(int y, int x) {
		return (isEmpty(y, x+1) && isEmpty(y+1, x+1));
	}
	
	static int go(int c, int d) {
		int y = -2;
		int x = c;
		
		int cycle = 0;
		
		while (true) {
			if(isEmpty(y+1, x)) {
				y += 1;
			} else if(isLeft(y,x)) {
				y += 1;
				x -= 1;
				
				cycle -= 1;
			} else if(isRight(y,x)) {
				y +=1; 
				x += 1;
				
				cycle += 1;
			} else {
				break;
			}
		}
		if(cycle < 0) {
			cycle = Math.abs(cycle) % 4;
			for(int i =0; i < cycle; i++) {
				d -= 1;
				d %= 4;
				if (d < 0) d += 4;
			}
		} else {
			for(int i =0; i < cycle; i++) {
				d += 1;
				d %= 4;
			}
		}
		int num = draw(y,x);
		map.put(idx, d);
		idx++;
		if (num <5) {
			clearUp();
			return 0;
		}
		int score = bfs(y,x);
		score++;
		return score;
	}
	
	static void clearUp() {
		board = new int[R][C];
		map.clear();
		idx = 1;
	}
	
	static int draw(int y, int x) {
		int num = 0;
		if(isRange(y,x)) {
			board[y][x] = idx;
			num++;
		}
		for(int i = 0; i <4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(isRange(ny, nx)) {
				board[ny][nx] = idx;
				num++;
			}
		}
		return num;
	}
	
	static boolean out(int y, int x) {
		return R <= y || C <= x || x < 0;
	}
	
	static boolean isEmpty(int r, int c) {
		if(isRange(r,c) && board[r][c] != 0) return false;
		for(int i =0; i < 4; i++) {
			int ny = r + dy[i];
			int nx = c + dx[i];
			if(out(ny, nx)) {
				return false;
			}
			if(isRange(ny, nx) && board[ny][nx] != 0) return false;
		}
		return true;
	}
	
	static boolean isRange(int y, int x) {
		return 0 <= y && y < R && 0 <= x && x < C;

	}
	
	static int bfs(int r, int c) {
		boolean[] visit = new boolean[idx+1];
		int start = board[r][c];
		visit[start]= true;
		
		Deque<int[]> q = new ArrayDeque<>();
		q.offer(new int[]{r,c});
		int ans = r +1;
		while(!q.isEmpty()) {
			int[] line = q.poll();
			int y = line[0];
			int x = line[1];
			
			ans = Math.max(ans, y+1);
			
			int d= map.get(board[y][x]);
			
			y += dy[d];
			x += dx[d];
			
			for(int i =0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				if(!isRange(ny,nx)) continue;
				int nextIdx = board[ny][nx];
				if(nextIdx == 0) continue;
				if(visit[nextIdx]) continue;
				
				visit[nextIdx] = true;
				int[] cen = getCenter(ny,nx);
				q.offer(cen);	
			}
		}
		return ans;
				
	}
	
	static int[] getCenter(int y, int x) {
		if (board[y][x] == 0) return new int[] {0,0};
		for(int i =0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			int match = 0;
			if(board[ny][nx] == 0) continue;
			if(board[ny][nx] == board[y][x]) return new int[] {ny, nx};
		}
		return new int[] {0,0};
	}
}