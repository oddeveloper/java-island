package island.service;

import island.domain.Grid;
import island.service.impl.GridManager;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GridService implements GridManager {
    private static final int MIN_GRID = 2;
    private static final int MAX_GRID = 10000;
    private static final int UNASSIGNED_DOT = 0;
    private static final int ASSIGNED_DOT = 1;
    private static Grid grid;

    @Override
    public Grid initIsland() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("m x n 격자 생성을 위해 m값을 입력해주세요. (1 < m < 10001)");
            int m = scanner.nextInt();

            System.out.println("n값을 입력해주세요. (1 < n < 10001)");
            int n = scanner.nextInt();

            if (m < MIN_GRID || m > MAX_GRID) {
                throw new IllegalArgumentException("초기 입력값은 2이상, 10000이하입니다.");
            } else if (n < MIN_GRID || n > MAX_GRID) {
                throw new IllegalArgumentException("초기 입력값은 2이상, 10000이하입니다.");
            } else {
                grid = new Grid(m, n, new int[m][n]);
                return grid;
            }
        } catch (InputMismatchException exception) {
            throw new InputMismatchException("입력값은 정수만 가능합니다.");
        }
    }

    @Override
    public int generateIsland(int[][] island) {
        int verticalCount = grid.getGridX();
        int horizontalCount = grid.getGridY();
        int gridDotCount = getGridDotCount(island);
        int assignedDotCount = getAssignedDotCount(island);
        int currentAssignableDotCount = getCurrentAssignableDotCount(gridDotCount, assignedDotCount);

        System.out.println("격자의 좌표에 삽입할 점의 갯수를 입력해주세요. ");
        Scanner scanner = new Scanner(System.in);
        int dotCount = scanner.nextInt();

        if (dotCount > currentAssignableDotCount) {
            throw new IllegalArgumentException("할당된 영역보다 더 많은 점을 삽입할 수 없습니다.");
        }

        dotCount += assignedDotCount;
        int assignedCount = 0;

        for (int i=0; i<verticalCount; i++) {
            for (int j=0; j<horizontalCount; j++) {
                if (dotCount > assignedCount) {
                    island[i][j] = ASSIGNED_DOT;
                    assignedCount++;
                }
            }
        }

        return dotCount;
    }

    @Override
    public int removeIsland(int[][] island) {
        int verticalCount = grid.getGridX();
        int horizontalCount = grid.getGridY();
        int assignedDotCount = getAssignedDotCount(island);

        System.out.println("격자의 좌표에 삭제할 점의 갯수를 입력해주세요. ");
        Scanner scanner = new Scanner(System.in);
        int removeDotCount = scanner.nextInt();

        if (assignedDotCount == 0) {
            throw new IllegalArgumentException("삭제할 수 있는 점이 없습니다.");
        }

        if (removeDotCount > assignedDotCount) {
            throw new IllegalArgumentException("할당된 영역보다 더 많은 점을 삭제할 수 없습니다.");
        }

        int dotCount = assignedDotCount - removeDotCount;
        int reAssignedDotCount = 0;

        for (int i=0; i<verticalCount; i++) {
            for (int j=0; j<horizontalCount; j++) {
                if (dotCount > reAssignedDotCount) {
                    island[i][j] = ASSIGNED_DOT;
                    reAssignedDotCount++;
                } else {
                    island[i][j] = UNASSIGNED_DOT;
                }
            }
        }

        return removeDotCount;
    }

    private static int getGridDotCount(int[][] area) {
        return (int) Arrays.stream(area).
                flatMapToInt(i -> Arrays.stream(i)).
                count();
    }

    private static int getAssignedDotCount(int[][] area) {
        return (int) Arrays.stream(area).
                flatMapToInt(i -> Arrays.stream(i)).
                filter(i -> i == ASSIGNED_DOT).count();
    }

    private static int getCurrentAssignableDotCount(int gridDotCount, int assignedDotCount) {
        return gridDotCount - assignedDotCount;
    }
}
