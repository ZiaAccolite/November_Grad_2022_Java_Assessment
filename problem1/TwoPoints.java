public class TwoPoints {
    public static void main(String[] args) {
        for (int i = 1; i <= 12; i++) {
            for (int j = 1; j <= 12; j++) {
                //trying out all possible values of x and y.
                System.out.println(computePointOfInterception(i, j));

            }
        }

    }

    public static int computePointOfInterception(int x, int y) {
        //a loop executes until both attain same value
        while (x != y) {
            //the first three are special cases when we arrive to 12 or 11
            if (x == 11)
                x = 1;
            if (x == 12)
                x = 2;
            if (y == 12)
                y = 1;
            //for all other cases we may increment x by 2 and y by 1
            else {
                x += 2;
                y += 1;
            }

        }
        return x;
    }
}