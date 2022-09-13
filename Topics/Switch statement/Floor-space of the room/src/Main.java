import java.util.Scanner;

class Main {

    static double pi = 3.14;
    static Scanner sc = new Scanner(System.in);

    public static void triangle() {
        double a = sc.nextInt();
        double b = sc.nextInt();
        double c = sc.nextInt();
        double p = (a + b + c) / 2;
        double area = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        System.out.println(area);
    }

    public static void circle() {
        int a = sc.nextInt();

        double area = pi * a * a;
        System.out.println(area);
    }

    public static void rectangle() {
        int a = sc.nextInt();
        int b = sc.nextInt();

        double area = b * a;
        System.out.println(area);
    }

    public static void main(String[] args) {
        // start coding here
        String room = sc.next();
        switch (room) {
            case "triangle":
                triangle();
                break;
            case "circle":
                circle();
                break;
            case "rectangle":
                rectangle();
                break;
            default:
                break;
        }

    }
}