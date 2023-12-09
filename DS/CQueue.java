import java.util.Scanner;

public class CQueue {

  Scanner sc = new Scanner(System.in);

  int Q[];
  static int Front, Rear;
  int size;

  CQueue(int size) {
    this.size = size;
    Q = new int[size];
    Front = Rear = -1;
  }

  void Enqueue() {
    if (Front == (Rear + 1) % size) {
      System.out.println("OVERFLOW!!");
    } else {
      if (Front == -1) {
        Front = 0;
      }
      Rear = (Rear + 1) % size;
      Q[Rear] = sc.nextInt();
    }
  }

  int Dequeue() {
    if (Front == -1) {
      System.out.println("EMPTY!!");
      return -1;
    } else {
      int y = Q[Front];

      if (Front == Rear ) {
        Front = -1;
        Rear = -1;
      } else {
        Front = (Front + 1) % size;
      }
      return y;
    }
  }

  void displayCQueue() {
    if (Front == -1) {
      System.out.println("EMPTY!!");
    } else {
      for (int i = Front; i != Rear; i = (i + 1) % size) {
        System.out.println(Q[i] + " | ");
      }
      System.err.println(" " + Q[Rear]);
    }
  }
}

class CQueueRun {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    System.out.print("ENTER SIZE: ");
    int size = sc.nextInt();
    CQueue obj = new CQueue(size);

    outer: while (true) {
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
          obj.displayCQueue();
          break;
        default:
          System.out.println("ENTER VALID CHOICE!!");
          break;
      }
    }
  }
}