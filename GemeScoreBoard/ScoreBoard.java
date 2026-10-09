package GemeScoreBoard;

public class ScoreBoard {
    private int numEntries;
    private GameEntry[] board;

    public ScoreBoard(int capacity) {
        board = new GameEntry[capacity];
        numEntries = 0;
    }

    public void add(GameEntry e) {
        int newScore = e.getScore();
        
        if (numEntries == board.length && newScore <= board[numEntries - 1].getScore()) {
            return;
        }

        if (numEntries < board.length) {
            numEntries++;
        }
        
        int j = numEntries - 1;
        while (j > 0 && board[j - 1].getScore() < newScore) {
            board[j] = board[j - 1];
            j--;
        }
        board[j] = e;
    }

    public GameEntry remove(int i) {
        if (i < 0 || i >= numEntries) {
            return null;
        }
        
        GameEntry temp = board[i];
        
        for (int j = i; j < numEntries - 1; j++) {
            board[j] = board[j + 1];
        }
        
        board[numEntries - 1] = null;
        numEntries--;
        
        return temp;
    }

    public void print() {
        for (int i = 0; i < numEntries; i++) {
            System.out.println(board[i].toString());
        }
        System.out.println("---------------");
    }

    public static void main(String[] args) {
        ScoreBoard sb = new ScoreBoard(5);
        
        sb.add(new GameEntry("Mohammad", 150));
        sb.add(new GameEntry("Ali", 120));
        sb.add(new GameEntry("Reza", 200)); 
        
        sb.print();
        
        sb.remove(1); 
        
        sb.print();
        
        sb.add(new GameEntry("Sara", 180));
        
        sb.print();
    }
}
