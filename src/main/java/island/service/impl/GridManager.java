package island.service.impl;

import island.domain.Grid;

public interface GridManager {
    Grid initIsland();
    int generateIsland(int[][] grid);
    int removeIsland(int[][] grid);
}
