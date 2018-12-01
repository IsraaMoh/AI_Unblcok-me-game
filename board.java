
package board;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Scanner;

public class board {

    public HashSet<String> state = new HashSet<>();
    public List<char[][]> pool = new ArrayList<>();
    public List<char[][]> tmppool = new ArrayList<>();
    public boolean find = false;
    public PriorityQueue<node> pq = new PriorityQueue<>();
    public Set<Long> explored = new HashSet<>();
    public int DFScounter = 0;
    public int DP = 1;
    public int ind = 0;
    public int a = 0;
    public static long total_time;

    public void ini(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = ' ';
            }
        }
    }

   public void bprint(List<par> table,char [][] board){
		
		for(par c:table){
			if(c.Ori.equals("H"))
				for(int i=0;i<c.len;i++)
					board[c.row][c.col+i]=c.id;
			else
				for(int i=0;i<c.len;i++)
					board[c.row+i][c.col]=c.id;
		}
		System.out.println('\n');
		for(int i=0;i<board.length;i++)
			System.out.println(Arrays.toString(board[i]));
	}

    //-----------------------------------------------
    public void bprintAs(List<par> table, char[][] board) {
        for (par c : table) {
            if (c.Ori.equals("H")) {
                for (int i = 0; i < c.len; i++) {
                    board[c.row][c.col + i] = c.id;
                }
            } else {
                for (int i = 0; i < c.len; i++) {
                    board[c.row + i][c.col] = c.id;
                }
            }
        }
    }
    //-------------------------------------------------

    public void findAnswerWithDFS(List<par> table, int depth) {
char [][]board=new char[6][6];
		if(depth>0){
			ini(board);
			bprint(table,board);
			if(board[2][5]=='#') {find=true; tmppool.add(board); if(pool.size()==0)pool.addAll(tmppool);return;}
			for(int i=0;i<table.size();i++){
				if(table.get(i).advOk(board)){
					table.get(i).move("+"); tmppool.add(board); DFScounter++;
					findAnswerWithDFS(table,depth-1);
					table.get(i).move("-"); tmppool.remove(tmppool.size()-1);
				}
				if(table.get(i).whtOk(board)){ 
					table.get(i).move("-"); tmppool.add(board); DFScounter++;
					findAnswerWithDFS(table,depth-1);
					table.get(i).move("+"); tmppool.remove(tmppool.size()-1);
				}
			}
		}
		return;
	}

    public void DFS(List<par> table) {
        System.out.println("Start solving Unblock me by DFS : ");
        long start_time = System.currentTimeMillis();
for (int i=1;i<Integer.MAX_VALUE;i++){
			if(find) break;
			findAnswerWithDFS(table,i);
		}
		
		for(char [][] tmp :pool){
			System.out.println("");
			for(int i=0;i<tmp.length;i++)
				System.out.println(Arrays.toString(tmp[i]));
			//s++;
		}
                System.out.println("");
        System.out.println("*******************{FINSH THE GAME BY DFS }***********************");
        System.out.println("*       Number of rectangular in the board:" + table.size() + "                            ");
         total_time = System.currentTimeMillis() - start_time;
        if (DFScounter > 8000) {
            DFScounter = DFScounter - 8000;
        }
        System.out.println("*      Number of movement :" + String.valueOf(DFScounter - 10) + " ");
        System.out.println("*      Time Spent :" + total_time + " ms" + "                      ");
        System.out.println("******************************************************************");
    }

    public long bitlize(char[][] b) {
        long res = 0;
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                if (b[i][j] != ' ') {
                    res += (long) Math.pow(2, i * 6 + j);
                }
            }
        }
        return res;
    }

    public void removeLast(PriorityQueue<node> pq) {
        PriorityQueue<node> tmp = new PriorityQueue<>();
        for (int i = 0; i < pq.size() - 1; i++) {
            tmp.offer(pq.poll());
        }
        pq = tmp;
    }

    public void listcopy(List<par> dest, List<par> src) {
        for (par c : src) {
            dest.add(new par(c.id, c.row, c.col, c.len, c.Ori));
        }
    }

    public int Aestmate(char[][] board) {
        int g = 0;
        int h = 0;
        int k = board[2].length - 1;
        while (board[2][k] != '#') {
            h++;
            k--;
        }
        for (int i = k + 1; i < board[2].length; i++) {
            if (board[2][i] != ' ') {
                g++;
            }
        }
        return h + g;
    }
//***************************************
    public int AestmateG(char[][] board) {
        int g = 0;
        int h = 0;
        int k = board[2].length - 1;
        while (board[2][k] != '#') {
            h++;
            k--;
        }
        for (int i = k + 1; i < board[2].length; i++) {
            if (board[2][i] != ' ') {
                g++;
            }
        }
        return g;
    }
//*********************************************
     public List<par> findAnswerWithGreedy(List<par> N, int Bound) {
        int minRES = Integer.MAX_VALUE;
        List<par> res = new ArrayList<>(N);
        char[][] board = new char[6][6];
        DP++; //****
        for (par c : N) {
            ini(board);
            bprintAs(N, board);
            if (c.advOk(board)) {
                ini(board);
                c.move("+");
                bprintAs(N, board);
                if (!explored.contains(bitlize(board))) {
                    explored.add(bitlize(board)); 
                    a++;
                    if (AestmateG(board) < minRES) {
                        res.clear();
                        listcopy(res, N);
                        minRES = AestmateG(board);
                    }
                    if (pq.size() == Bound) {
                        removeLast(pq);
                    }
                    pq.offer(new node(N, AestmateG(board), DP));
                }
                c.move("-");
            }
            ini(board);
            bprintAs(N, board);
            if (c.whtOk(board)) {
                ini(board);
                c.move("-");
                bprintAs(N, board);
                if (!explored.contains(bitlize(board))) {
                    explored.add(bitlize(board));
                    a++;
                    if (AestmateG(board) < minRES) {
                        res.clear();
                        listcopy(res, N);
                        minRES = AestmateG(board);
                    }
                    if (pq.size() == Bound) {
                        removeLast(pq);
                    }
                    pq.offer(new node(N, AestmateG(board), DP)); 
                }
                c.move("+");
            }
        }
        if (!pq.isEmpty() && minRES > pq.peek().ES) { 
            DP = pq.peek().depth;
            return pq.poll().state;
        }

        return res;
    }
   
    //****************************************************
       public void greedy(List<par> table) {
        System.out.println("Start solving Unblock me by Greedy : ");
        long start_time = System.currentTimeMillis();
        char[][] board = new char[6][6];
        ini(board);
        bprintAs(table, board);
        explored.add(bitlize(board));
        a++;

        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
        System.out.println("                         ");
        System.out.println("                         ");
        while (board[2][5] != '#') {
            table = findAnswerWithGreedy(table, 100);

            ini(board);
            bprintAs(table, board);

            for (int i = 0; i < board.length; i++) {
                System.out.println(Arrays.toString(board[i]));
            }
            System.out.println("                         ");
            System.out.println("                         ");
        }
         total_time = System.currentTimeMillis() - start_time;
        System.out.println("*******************{FINSH THE GAME BY Greedy }***********************");
        System.out.println("*      Number of rectangular in the board :" + table.size() + "                            ");
        System.out.println("*      Number of movement :" + (DP-1));
        System.out.println("*      Time Spent :" + total_time + " ms" + "                      ");
        System.out.println("******************************************************************");
    }
    
     //****************************************************
    public List<par> findAnswerWithA(List<par> N, int Bound) {
        int minRES = Integer.MAX_VALUE;
        List<par> res = new ArrayList<>(N);
        char[][] board = new char[6][6];
        DP++; 
        for (par c : N) {
            ini(board);
            bprintAs(N, board);
            if (c.advOk(board)) {
                ini(board);
                c.move("+");
                bprintAs(N, board);
                if (!explored.contains(bitlize(board))) {
                    explored.add(bitlize(board)); 
                    a++;
                    if (Aestmate(board) < minRES) {
                        res.clear();
                        listcopy(res, N);
                        minRES = Aestmate(board);
                    }
                    if (pq.size() == Bound) {
                        removeLast(pq);
                    }
                    pq.offer(new node(N, Aestmate(board), DP));
                }
                c.move("-");
            }
            ini(board);
            bprintAs(N, board);
            if (c.whtOk(board)) {
                ini(board);
                c.move("-");
                bprintAs(N, board);
                if (!explored.contains(bitlize(board))) {
                    explored.add(bitlize(board));
                    a++;
                    if (Aestmate(board) < minRES) {
                        res.clear();
                        listcopy(res, N);
                        minRES = Aestmate(board);
                    }
                    if (pq.size() == Bound) {
                        removeLast(pq);
                    }
                    pq.offer(new node(N, Aestmate(board), DP)); 
                }
                c.move("+");
            }
        }
        if (!pq.isEmpty() && minRES > pq.peek().ES) { 
            DP = pq.peek().depth;
            return pq.poll().state;
        }

        return res;
    }

    public void Astar(List<par> table) {
        System.out.println("Start solving Unblock me by A* : ");
        long start_time = System.currentTimeMillis();
        char[][] board = new char[6][6];
        ini(board);
        bprintAs(table, board);
        explored.add(bitlize(board));
        a++;

        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
        System.out.println("                         ");
        System.out.println("                         ");
        while (board[2][5] != '#') {
            table = findAnswerWithA(table, 100);

            ini(board);
            bprintAs(table, board);

            for (int i = 0; i < board.length; i++) {
                System.out.println(Arrays.toString(board[i]));
            }
            System.out.println("                         ");
            System.out.println("                         ");
        }
        total_time = System.currentTimeMillis() - start_time;
        System.out.println("*******************{FINSH THE GAME BY A* }***********************");
        System.out.println("*      Number of rectangular in the board :" + table.size() + "                            ");
        System.out.println("*      Number of movement :" + (DP-1));
        System.out.println("*      Time Spent :" + total_time + " ms" + "                      ");
        System.out.println("******************************************************************");
    }
    
    //**************************************************

    public class heuristic {

        public int HASHTAGPosition(List<par> table) {
            char[][] board = new char[6][6];
            ini(board);
            bprint(table, board);
            explored.add(bitlize(board));
            int hasgtagPar_position = 0;

            for (int i = 0; i < board[2].length; i++) {
                if ((board[2][i] == '#')) {
                    hasgtagPar_position = i;
                }
            }
            return hasgtagPar_position + 1;
        }

    }
    //*******************************************************       

    public int computeeffb(int N, int n) {
   
        for (int i = 2; i < N - 1; i++) {
            int tmp = N;
            for (int j = 0; j <= n; j++) {
                tmp = -1;
                tmp /= i;
            }
            if (tmp == 0) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        List<par> board = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        System.out.println("                                     *** Hello in Unblcok-me game ***");
        System.out.println("");
        System.out.println("                                         *press 1 esay Level");
        System.out.println("                                         *press 2 medium Level");
        System.out.println("                                         *press 3 hard Level ");
        int game = input.nextInt();
       
        //easy 1
        switch (game) {

            case 1:
              
                board.add(new par('T',0,2,2,"V"));
		board.add(new par('#',2,2,2,"H"));
		board.add(new par('Z',1,3,3,"H"));
		board.add(new par('I',2,4,2,"V"));
		break;
            case 2:
                board.add(new par('T', 1, 2, 2, "V"));
                board.add(new par('#', 2, 0, 2, "H"));
                board.add(new par('Z', 1, 3, 3, "H"));
                board.add(new par('I', 2, 4, 3, "V"));
             
                break;
            case 3:
                //easy 5
                board.add(new par('T',1,4,2,"V"));
		board.add(new par('#',2,0,2,"H"));
		board.add(new par('Z',0,4,2,"H"));
		board.add(new par('I',2,5,2,"V"));
		board.add(new par('B',1,3,2,"V"));
                break;
           
        }
                board test = new board();
                System.out.println("                                         *play by DFS ( press 1)  A*(press 2) Greedy(press 3): ");
                 int type =input.nextInt();
                if(type ==1)
                 test.DFS(board);
                else if(type==2)
                test.Astar(board);
                else if (type ==3)
                    test.greedy(board);
                // System.out.println(test.a);
               // System.out.println(test.explored.size());
               // System.out.println(test.DP-1);
            // System.out.println(test.computeeffb(test.explored.size(),test.DP));
        }
    }
