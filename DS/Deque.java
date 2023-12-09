import java.util.Scanner;

public class Deque {
    Scanner sc = new Scanner(System.in);

    int[] Q;
    static int Front, Rear;
    int size;

    Deque(int size) {
        this.size = size;
        Q = new int[size];
        Front = -1;
        Rear = -1;
    }

    void insertAtRear() {
        if (Front == (Rear + 1) % size) {
            System.out.println("QUEUE OVERFLOW!!");
        } else {
            if (Front == -1) {
                Front = 0;
            }
            Rear = (Rear + 1) % size;
            System.out.print("ENTER ELEMENT: ");
            Q[Rear] = sc.nextInt();
        }
    }

    int deleteAtFront() {
        int y;
        if (Front == -1) {
            System.out.println("QUEUE EMPTY!!");
            return -1;
        } else {
            if (Front == Rear) {
                Front = -1;
                Rear = -1;
                return -1;
            } else {
                y = Q[Front];
                Front = (Front + 1) % size;
                return y;
            }
        }
    }

    void insertAtFront() {
        if (Front == (Rear + 1) % size) {
            System.out.println("SYSTEM OVERFLOW!!");
        } else {
            if (Front == -1) {
                Front = 0;
                Rear = 0;
            } else if (Front == 0) {
                Front = Q.length - 1;
            } else {
                Front = Front - 1;
            }
            System.out.print("ENTER AT FRONT " + Front + " : ");
            Q[Front] = sc.nextInt();
        }
    }

    int deleteAtRear() {
        int y;
        if (Front == -1) {
            System.out.println("QUEUE EMPTY!!");
            return Front;
        } else {
            if (Rear == 0) {
                y = Q[Rear];
                Rear = size - 1;
                return y;
            } else if (Rear == Front) {
                y = Q[Rear];
                Front = -1;
                Rear = -1;
                return y;
            } else {
                y = Q[Rear];
                Rear--;
                return y;
            }
        }
    }

    void displayDeque() {
        if (Front == -1) {
            System.out.println("DEQIE EMPTY!!");
        } else {
            for (int i = Front; i != Rear; i = (i + 1) % size) {
                System.out.print(Q[i] + " | ");
            }
            System.out.println(Q[Rear]);
        }
    }
}

class DequeRun {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("ENTER SIZE OF QUEUE: ");
        int size = sc.nextInt();
        Deque obj = new Deque(size);

        while (true) {
            System.out.println("1.ENQUEUE\n2.DEQUEUE");
            System.out.println("3.INSERT AT FRONT\n4.DELETE AT REAR");
            System.out.println("5.DISPLAY");
            System.out.print("ENTER CHOICE: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    obj.insertAtRear();
                    break;
                case 2:
                    System.out.println("ELEMENT DELETED: " + obj.deleteAtFront());
                    break;
                case 5:
                    obj.displayDeque();
                    break;
                case 3:
                    obj.insertAtFront();
                    break;
                case 4:
                    System.out.println("ELEMENT DELETED: " + obj.deleteAtRear());
                    break;
                default:
                    System.out.println("ENTER VALID CHOICE!!");
                    break;
            }
        }
    }
}