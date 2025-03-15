class Spreadsheet {
    private int[][] grid;
    private int rows;
    private static int COLUMNS = 26;

    public Spreadsheet(int rows) {
        this.rows = rows;
        grid = new int[rows][COLUMNS];
    }

    public void setCell(String cell, int value) {
        int col = cell.charAt(0) - 'A';
        int row = Integer.parseInt(cell.substring(1)) - 1; // Corrected 1-based to 0-based
        grid[row][col] = value;
    }

    public void resetCell(String cell) {
        int col = cell.charAt(0) - 'A';
        int row = Integer.parseInt(cell.substring(1)) - 1; // Corrected 1-based to 0-based
        grid[row][col] = 0;
    }

    public int getValue(String formula) {
        if (formula == null || formula.length() < 2 || formula.charAt(0) != '=') {
            return 0;
        }

        int sum = 0;
        int lastPlus = 1;

        for (int i = 1; i < formula.length(); i++) {
            if (formula.charAt(i) == '+') {
                String part = formula.substring(lastPlus, i);
                if (Character.isDigit(part.charAt(0))) {
                    sum += Integer.parseInt(part);
                } else {
                    int col = part.charAt(0) - 'A';
                    int row = Integer.parseInt(part.substring(1)) - 1;
                    sum += grid[row][col];
                }
                lastPlus = i + 1;
            }
        }

        String lastPart = formula.substring(lastPlus);
        if (Character.isDigit(lastPart.charAt(0))) {
            sum += Integer.parseInt(lastPart);
        } else {
            int col = lastPart.charAt(0) - 'A';
            int row = Integer.parseInt(lastPart.substring(1)) - 1;
            sum += grid[row][col];
        }

        return sum;
    }
}