package edu.akdenizeem.hwsolutions.homework01;

class Homework2 {
    private Homework2() {
    }

    public static void run() {

        DisplayRelationsApp.run();
        MidTest.run();
        SignumTest.run();
        PrintDiamondApp.FirstVariation.run();
        PrintDiamondApp.SecondVariation.run();
        DisplayDurationTest.run();
        PrintPrimeFactorsApp.run();
        BallFallGameApp.run();
        GoldbachApp.run();
    }

}

class SignumTest {
    public static void run() {
        java.util.Scanner kb = new java.util.Scanner(System.in);

        for (;;) {
            System.out.print("Bir sayı giriniz:");
            int a = Integer.parseInt(kb.nextLine());

            System.out.printf("signum(%d) = %d%n", a, NumberUtil.signum(a));

            if (a == 0)
                break;
        }

        System.out.println("Tekrar yapıyor musunuz?");
    }
}

class MidTest {
    public static void run() {
        java.util.Scanner kb = new java.util.Scanner(System.in);

        for (;;) {
            System.out.print("Birinci sayıyı giriniz:");
            int a = Integer.parseInt(kb.nextLine());

            System.out.print("İkinci sayıyı giriniz:");
            int b = Integer.parseInt(kb.nextLine());

            System.out.print("Üçüncü sayıyı giriniz:");
            int c = Integer.parseInt(kb.nextLine());

            System.out.printf("mid(%d, %d, %d) = %d%n", a, b, c, NumberUtil.mid(a, b, c));

            if (a == 0 && b == 0 && c == 0)
                break;
        }

        System.out.println("Tekrar yapıyor musunuz?");
    }
}

class NumberUtil {
    public static int mid(int a, int b, int c) {
        if (a <= b && b <= c || c <= b && b <= a)
            return b;

        if (b <= a && a <= c || c <= a && a <= b)
            return a;

        return c;
    }

    public static int signum(int val) {
        if (val > 0)
            return 1;

        if (val == 0)
            return 0;

        return -1;
    }
}

class DisplayRelationsApp {
    public static void run() {
        java.util.Scanner kb = new java.util.Scanner(System.in);

        System.out.print("Birinci sayıyı giriniz:");
        int a = Integer.parseInt(kb.nextLine());

        System.out.print("İkinci sayıyı giriniz:");
        int b = Integer.parseInt(kb.nextLine());

        System.out.print("Üçüncü sayıyı giriniz:");
        int c = Integer.parseInt(kb.nextLine());

        displayRelations(a, b, c);
    }

    public static void displayRelations(int a, int b, int c) {
        int min = Math.min(Math.min(a, b), c);
        int max = Math.max(Math.max(a, b), c);
        int mid = a + b + c - max - min;

        if (min < mid)
            System.out.printf("%d < %d ", min, mid);
        else
            System.out.printf("%d = %d ", min, mid);

        if (mid < max)
            System.out.printf("< %d%n", max);
        else
            System.out.printf("= %d%n", max);

    }

}

class GoldbachApp {
    public static void run() {
        java.util.Scanner kb = new java.util.Scanner(System.in);

        for (;;) {
            System.out.print("2'den büytük bir çift sayı giriniz:");
            int val = Integer.parseInt(kb.nextLine());

            if (val % 2 != 0)
                continue;

            if (val == 0)
                break;

            NumberUtil.printGoldbachPrimes(val);
        }
    }
}

class BallFall {
    public static void fillSpace(int begin, int end) // [begin, end)
    {
        for (int i = begin; i < end; ++i)
            System.out.print(' ');
    }

    public static void fillBall(int ballIndex, int end) {
        fillSpace(0, ballIndex);
        System.out.print('*');
        fillSpace(ballIndex + 1, end);
    }

    public static boolean updateRightFlag(boolean isRight, int ballIndex, int width) {
        if (ballIndex == 0)
            isRight = true;
        else if (ballIndex == width - 1)
            isRight = false;

        return isRight;
    }

    public static int updateBallIndex(boolean isRight, int ballIndex) {
        if (isRight)
            return ballIndex + 1;

        return ballIndex - 1;
    }

    public static void play(int width, int height) {
        int ballIndex = 0;
        boolean isRight = false;

        for (int i = 1; i <= height; ++i) {
            System.out.print('|');
            fillBall(ballIndex, width);
            if (width != 1) {
                isRight = updateRightFlag(isRight, ballIndex, width);
                ballIndex = updateBallIndex(isRight, ballIndex);
            }
            System.out.println('|');
        }
    }
}

class BallFallGameApp {
    public static void run() {
        java.util.Scanner kb = new java.util.Scanner(System.in);

        for (;;) {
            System.out.print("Width?");
            int width = Integer.parseInt(kb.nextLine());

            if (width == 0)
                break;

            System.out.print("Height?");
            int height = Integer.parseInt(kb.nextLine());

            BallFall.play(width, height);
        }
    }
}

class PrintPrimeFactorsApp {

    public static void run() {
        java.util.Scanner kb = new java.util.Scanner(System.in);

        for (;;) {
            System.out.print("Bir sayı giriniz:");
            int n = Integer.parseInt(kb.nextLine());

            NumberUtil.printPrimeFactors(n);

            if (n == 0)
                break;

        }
    }
}

class NumberUtil {
    public static void printPrimeFactors(int n) {
        if (n == 0)
            return;

        n = Math.abs(n);

        int i = 2;

        while (n != 1) {
            if (n % i == 0) {
                System.out.printf("%d ", i);
                n /= i;
            } else
                ++i;
        }

        System.out.println();
    }

    public static void printGoldbachPrimes(int val) {
        for (int a = 2; a < val; ++a) {
            int b = val - a;

            if (isPrime(a) && isPrime(b) && a <= b)
                System.out.printf("%d + %d = %d == %d%n", a, b, a + b, val);
        }
    }

    public static boolean isPrime(long val) {
        if (val <= 1)
            return false;
        if (val % 2 == 0)
            return val == 2;
        if (val % 3 == 0)
            return val == 3;
        if (val % 5 == 0)
            return val == 5;
        if (val % 7 == 0)
            return val == 7;
        for (long j = 11; j * j <= val; j += 2)
            if (val % j == 0)
                return false;
        return true;
    }
}

class DisplayDurationTest {
    public static void displayDuration(long totalSeconds) {
        long hours = totalSeconds / 60 / 60;
        long minutes = totalSeconds / 60 % 60;
        long seconds = totalSeconds % 60;

        if (hours != 0)
            System.out.printf("%d saat ", hours);

        if (minutes != 0)
            System.out.printf("%d dakika ", minutes);

        if (seconds != 0)
            System.out.printf("%d saniye", seconds);

        System.out.println();
    }

    public static void run() {
        java.util.Scanner kb = new java.util.Scanner(System.in);

        for (;;) {
            System.out.print("Saniye değeri giriniz:");
            long totalSeconds = Long.parseLong(kb.nextLine());

            displayDuration(totalSeconds);
            if (totalSeconds == 0)
                break;

            System.out.println("------------------------");
        }
    }
}

class PrintDiamondApp {
    class FirstVariation {
        public static void printDiamond(int n) {
            for (int i = 0; i < 2 * n; ++i) {
                if (i <= n) {
                    for (int k = 0; k < n - i; ++k)
                        System.out.print(' ');
                    for (int k = 0; k < 2 * i - 1; ++k)
                        System.out.print('*');
                } else {
                    for (int k = 0; k < i % n; ++k)
                        System.out.print(' ');

                    for (int k = 0; k < 2 * n - (i % n) * 2 - 1; ++k)
                        System.out.print('*');
                }

                System.out.println();
            }
        }

        public static void run() {
            java.util.Scanner kb = new java.util.Scanner(System.in);
            System.out.print("Bir sayı giriniz:");
            int n = Integer.parseInt(kb.nextLine());
            printDiamond(n);
        }
    }

    class SecondVariation {
        public static void printDiamond(int n) {
            for (int i = 0; i < n; ++i) {
                for (int k = 0; k < n - i; ++k)
                    System.out.print(' ');
                for (int k = 0; k < 2 * i - 1; ++k)
                    System.out.print('*');

                System.out.println();
            }

            for (int i = 0; i < n; ++i) {
                for (int k = 0; k < i; ++k)
                    System.out.print(' ');

                for (int k = 0; k < 2 * n - i * 2 - 1; ++k)
                    System.out.print('*');

                System.out.println();
            }
        }

        public static void run() {
            java.util.Scanner kb = new java.util.Scanner(System.in);
            System.out.print("Bir sayı giriniz:");
            int n = Integer.parseInt(kb.nextLine());
            printDiamond(n);
        }
    }

}
