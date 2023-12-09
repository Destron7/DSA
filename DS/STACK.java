import java.util.Scanner;

public class STACK {

    final static int size = 5;

    public final static int[] matrix = new int[size];

    public static Scanner sc = new Scanner(System.in);

    public static int top = -1;

    public static void push() {

        if (top >= size - 1) {
            System.out.println("STACK OVERFLOW!!");
        } else {
            top++;
            System.out.print("ENTER ELEMENT: ");
            int element = sc.nextInt();
            matrix[top] = element;
        }
    }

    public static void display() {
        if (top == -1) {
            System.out.println("STACK EMPTY!!");
        } else {
            System.out.println();
            for (int i = top; i >= 0; i--) {
                System.out.println("|" + matrix[i] + "|");
            }
        }
    }

    public static int pop() {
        int del = 0;
        if (top == -1) {
            System.out.println("STACK EMPTY!!");
        } else if (top == 0) {
            del = matrix[top];
            top = -1;
        } else {
            del = matrix[top];
            top--;
        }
        return del;
    }

    public static void peek() {
        if (top >= 0) {
            System.out.println("PEEK ELEMENT: " + matrix[top]);
        } else
            System.out.println("STACK EMPTY!!");
    }

    public static void main(String[] args) {
        outer: while (true) {
            System.out.println("1.PUSH\n2.POP\n3.DISPLAY\n4.PEEK\n10.EXIT");
            switch (sc.nextInt()) {
                case 1:
                    push();
                    break;
                case 2:
                    System.out.println("DELETED ELEMENTS: " + pop());
                    break;
                case 3:
                    display();
                    break;
                case 4:
                    peek();
                    break;
                case 10:
                    break outer;
                default:
                    break;
            }
        }
    }
}