package island.domain;

public class Grid {
    private int gridX;
    private int gridY;
    private int[][] grid;

    public Grid(int x, int y, int[][] grid) {
        this.gridX = x;
        this.gridY = y;
        this.grid = grid;
    }

    public int getGridX() {
        return gridX;
    }

    public void setGridX(int gridX) {
        this.gridX = gridX;
    }

    public int getGridY() {
        return gridY;
    }

    public void setGridY(int gridY) {
        this.gridY = gridY;
    }

    public int[][] getGrid() {
        return grid;
    }

    public void setGrid(int[][] grid) {
        this.grid = grid;
    }
}
