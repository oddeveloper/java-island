package island;

import island.domain.Command;
import island.service.FileService;
import island.domain.Grid;
import island.service.GridService;

import java.io.IOException;
import java.util.Scanner;

public class Application {
    private static Grid grid;
    private static GridService gridService;
    private static FileService fileService;

    public static void main(String args[]) throws IOException {
        System.out.println("원하는 메뉴를 선택하세요.");
        System.out.println("0: 시스템 종료");
        System.out.println("1: 격자 초기화");
        System.out.println("2: 점 생성하기");
        System.out.println("3: 점 지우기");
        System.out.println("4: 격자 파일 쓰기");
        System.out.println("5: 격자 파일 읽기");

        while (true) {
            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();
            Command command = Command.getCommand(input);

            gridService = new GridService();
            fileService = new FileService();

            switch (command) {
                case INITIALIZE:
                    System.out.println("격자 초기화하기");
                    grid = gridService.initIsland();
                    System.out.println(grid.getGridX() + " x " + grid.getGridY() + "격자가 초기화되었습니다.");
                    break;
                case GENERATE:
                    System.out.println("점 생성하기");
                    int generateCount = gridService.generateIsland(grid.getGrid());
                    System.out.println(generateCount + "개의 점을 격자에서 생성하였습니다.");
                    break;
                case REMOVE:
                    System.out.println("점 지우기");
                    int removeCount = gridService.removeIsland(grid.getGrid());
                    System.out.println(removeCount + "개의 점을 격자에서 제거하였습니다.");
                    break;
                case FILE_WRITE:
                    System.out.println("격자 파일 쓰기");
                    fileService.writerIsland(grid.getGrid());
                    System.out.println("격자 파일이 생성되었습니다.");
                    break;
                case FILE_READ:
                    System.out.println("격자 파일 읽기");
                    fileService.readerIsland();
                    break;
                case PROGRAM_EXIT:
                    System.out.println("프로그램이 종료되었습니다.");
                    return;
            }
        }
    }
}
