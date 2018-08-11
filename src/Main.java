import java.io.InputStream;
import java.util.Scanner;

public class Main {
    static final Point START = new Point(0, 0);
    static int minPath = Integer.MAX_VALUE;

    public static int rangeAll(Point[] points, int n) {
        if (n == points.length) {
            int sum = points[0].getLength(START);
            for (int i = 1; i < points.length; i++) {
                sum += points[i - 1].getLength(points[i]);
            }
            sum += points[points.length - 1].getLength(START);
            minPath = Math.min(minPath, sum);
            return minPath;
        }
        for (int i = n; i < points.length; i++) {
            swap(points, n, i);
            rangeAll(points, n + 1);
            swap(points, n, i);
        }
        return minPath;
    }

    public static void swap(Point[] points, int i, int j) {
        if (i == j) {
            return;
        }
        Point temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }

    public static void main(String[] args) {
        InputParser parser = new InputParser(System.in);
        parser.parse();
        System.out.println(rangeAll(parser.getPoints(), 0));
    }
}
class Point{
    int px;
    int py;

    public Point(int px,int py){
        this.px = px;
        this.py = py;
    }

    public int getLength(Point point){
        return Math.abs(px - point.px) + Math.abs(py - point.py);
    }
}
class InputParser {
    private Scanner scanner;
    private Point[] points;
    private int num;

    public InputParser(InputStream inputStream){
        scanner = new Scanner(inputStream);
    }

    public Point[] getPoints(){
        return points;
    }

    public int getNum(){
        return num;
    }


    public void parse(){
        num = Integer.parseInt(scanner.nextLine().trim());
        points = new Point[num];
        for (int i = 0; i < num; i++) {
            String[] locations = scanner.nextLine().trim().split(",");
            points[i] = new Point(Integer.parseInt(locations[0]), Integer.parseInt(locations[1]));
        }
    }
}