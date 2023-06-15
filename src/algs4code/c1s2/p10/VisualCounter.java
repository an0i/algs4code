package algs4code.c1s2.p10;

import edu.princeton.cs.algs4.StdDraw;

public class VisualCounter {
    private int count;
    private int operation;
    private int maxOperation;
    private int maxCountAbs;
    public VisualCounter(int N, int max) {
        maxOperation = N;
        maxCountAbs = Math.abs(max);
        StdDraw.setXscale(0, maxOperation+1);
        StdDraw.setYscale(-maxCountAbs-1, maxCountAbs+1);
        StdDraw.setPenRadius(0.01);
        StdDraw.setPenColor(StdDraw.BLUE);
    }
    public void increase() {
        if (count<maxCountAbs && operation<maxOperation) {
            count++;
            operation++;
            StdDraw.point(operation, count);
        }
    }
    public void decrease() {
        if (count>-maxCountAbs && operation<maxOperation) {
            count--;
            operation++;
            StdDraw.point(operation, count);
        }
    }
    public static void main(String[] args) {
        VisualCounter vc = new VisualCounter(10, 3);
        vc.increase();
        vc.increase();
        vc.increase();
        vc.decrease();
        vc.decrease();
        vc.decrease();
        vc.decrease();
        vc.decrease();
        vc.increase();
        vc.increase();
    }
}
