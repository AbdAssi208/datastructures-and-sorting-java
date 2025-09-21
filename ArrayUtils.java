import java.util.Arrays;

public class ArrayUtils {
	/**
	 * dealing with lift/right its like going to the -/+ on X-axis
	 * so if the direction is right our move is to the + on X-axis
	 * if the direction is lift our move is to the - on X-axis
	 * so we set the move's sign to be as the direction 
	 */
	public static int sign(int move, char direction,int n){
		int new_move =((Math.abs(move) % n) + n) % n;
		if (((move > 0) & (direction == ('R'))) || ((move < 0 ) & (direction == 'L'))){
			return new_move;
		}
		else{
			return -new_move;
		}	
	}

	public static int[] shiftArrayCyclic(int[] array, int move, char direction) {
		
		if ((direction != 'R') & (direction != 'L')){
			return array;
		}
		else{
			int x = 0 ;
			int y;
		int pointer_p = 0 ;
		int pointer_v = array[0];
		int n = array.length; 
		int	move_times = sign(move,direction,n);

		for (int i = 0; i < n; i++){
			x = pointer_p+ move_times;
			y =((x % n) + n) % n;
			pointer_p = y;
			int temp = array[y];
			array[y] = pointer_v;
			pointer_v = temp;
		}

		}
		return array; 
	}
	
	public static int findShortestPath(int[][] m, int i, int j) {
		return recurseShortestPath(m, i, j, "");
	}

	private static int recurseShortestPath(int[][] m, int i, int j, String seen) {
		if (i == j) return 0;
		if (m[i][j] == 1) return 1;

		
		String key = "(" + i + "," + j + ")";
		if (seen.contains(key)) return -2;
		seen += key;

		int min;
            min = Integer.MAX_VALUE;
		boolean pathFound;
            pathFound = false;
		for (int row = 0; row < m.length; row++) {
			int cellToJ = m[row][j];
			if (cellToJ == 0) continue;
			
			int path = recurseShortestPath(m, i, row, seen);
			if (path >= 0 && path < min) {
				min = path;
				pathFound = true;
				if (min == 0) break;
			}
		}
		
		return pathFound ? min + 1 : -1;
	}
	
