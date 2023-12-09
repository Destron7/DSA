import java.util.Scanner;

public class Queue {

    Scanner sc = new Scanner(System.in);

    int Q[];
    static int Front, Rear;
    int size;

    public Queue(int size) {
        Q = new int[size];
        this.size = size;
        Front = -1;
        Rear = -1;
    }

    void Enqueue() {
        if (Front == (Rear + 1) % size) {
            System.out.println("QUEUE OVERFLOW!!");
        } else {
            if (Front == -1) {
                Front = 0;
            }
            Rear++;
            System.out.print("ENTER ELEMENT: ");
            int data = sc.nextInt();
            Q[Rear] = data;
        }
    }

    int Dequeue() {
        if (Front == -1) {
            System.out.println("EMPTY");
            return -1;
        } else {
            if (Front > Rear) {
                System.out.println("EMPTY");
                return -1;
            } else {
                int y = Q[Front];
                Front++;
                return y;
            }
        }
    }

    void displayQueue() {
        if (Front == -1) {
            System.out.println("EMPTY!!");
        } else {
            for (int i = Front; i <= Rear; i++) {
                System.out.print(Q[i] + " | ");
            }
            System.out.println();
        }
    }
}

class QueueRun {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("ENTER SIZE OF QUEUE: ");
        int size = sc.nextInt();
        Queue obj = new Queue(size);

        while (true) {
            System.out.println("1.ENQUEUE\n2.DEQUEUE\n3.DISPLAY");
            System.out.print("ENTER CHOICE: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    obj.Enqueue();
                    break;
                case 2:
                    System.out.println(obj.Dequeue());
                    break;
                case 3:
                    obj.displayQueue();
                    break;
                default:
                    System.out.println("ENTER VALID CHOICE!!");
                    break;
            }
        }
    }
}
