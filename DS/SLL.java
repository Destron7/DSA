import java.util.Scanner;

public class SLL {

  public Scanner sc = new Scanner(System.in);

  class Node {
    int data;
    Node next;

    Node() {
      System.out.print("ENTER DATA: ");
      data = sc.nextInt();
      next = null;
    }
  }

  Node head;

  void insertAtHead() {
    Node newNode = new Node();
    if (head == null) {
      head = newNode;
    } else {
      newNode.next = head;
      head = newNode;
    }
  }

  void insertAtLast() {
    Node newnNode = new Node();
    if (head == null) {
      head = newnNode;
    } else {
      Node temp = head;
      while (temp.next != null) {
        temp = temp.next;
      }
      temp.next = newnNode;
    }
  }

  void insertBeforeValue(int key) {
    Node newNode = new Node();
    if (head == null) {
      head = newNode;
    } else if (head.next == null) {
      if (head.data == key) {
        newNode.next = head;
        head = newNode;
      } else {
        head.next = newNode;
      }
    } else {
      Node temp = head;
      while (temp.next != null && temp.next.data != key) {
        temp = temp.next;
      }
      newNode.next = temp.next;
      temp.next = newNode;
    }
  }

  void insertSorted() {
    Node newNode = new Node();
    if (head == null) {
      head = newNode;
    } else if (head.next == null) {
      if (head.data > newNode.data) {
        newNode.next = head;
        head = newNode;
      } else {
        head.next = newNode;
      }
    } else {
      Node temp = head;
      while (temp.next != null && temp.next.data < newNode.data) {
        temp = temp.next;
      }
      newNode.next = temp.next;
      temp.next = newNode;
    }
  }

  void displaySLL() {
    Node temp = head;
    while (temp != null) {
      System.out.print(temp.data + "-->");
      temp = temp.next;
    }
    System.out.println("null");
  }

  int deleteSpecNode(int key) {
    int y;
    if (head == null) {
      System.out.println("SLL EMPTY");
      return -1;
    } else if (head.next == null) {
      if (head.data == key) {
        y = head.data;
        head = null;
        return y;
      } else {
        return -1;
      }
    } else {
      Node temp = head;
      while (temp.next != null && temp.next.data != key) {
        temp = temp.next;
      }
      Node del = temp.next;
      temp.next = temp.next.next;
      return del.data;
    }
  }

  int deleteAtHead() {
    int y;
    if (head == null) {
      System.out.println("SLL EMPTY");
      return -1;
    } else if (head.next == null) {
      y = head.data;
      head = null;
      return y;
    } else {
      Node del;
      del = head;
      head = head.next;
      return del.data;
    }
  }

  int countNode() {
    int count = 0;
    if (head == null) {
      return count;
    } else {
      Node temp = head;
      while (temp != null) {
        count++;
        temp = temp.next;
      }
      return count;
    }
  }

  int findIndexOf(int key) {
    int count = 0;
    if (head == null) {
      System.out.println("ELEMENT DOESN'T EXIST");
      return -1;
    } else if (head.next == null) {
      if (head.data == key) {
        count = 1;
        return count;
      }
      return count;
    } else {
      int flag = 0;
      Node temp = head;
      while (temp.next == null) {
        count++;
        if (temp.data == key) {
          flag = 1;
          break;
        }
        temp = temp.next;
      }
      if (flag == 1) {
        return count;
      } else {
        System.out.println("ELEMENT NOT FOUND!!");
        return -1;
      }
    }
  }

  void displayOddPos() {
    if (head == null) {
      System.out.println("SLL EMPTY!!");
    } else {
      Node temp = head;
      int count = 1;
      while (temp != null) {
        if (count % 2 != 0)
          System.out.print(temp.data + "-->");
        count++;
        temp = temp.next;
      }
      System.out.println("null");
    }
  }
}

class ImplementingQueue {

  Scanner sc = new Scanner(System.in);

  class Node {
    int data;
    Node next;

    Node() {
      System.out.print("ENTER DATA: ");
      data = sc.nextInt();
      next = null;
    }
  }

  Node head;

  void insertAtLast() {
    Node newNode = new Node();
    if (head == null) {
      head = newNode;
    } else {
      Node temp = head;
      while (temp.next != null) {
        temp = temp.next;
      }
      temp.next = newNode;
    }
  }

  void deleteAtHead() {
    if (head == null) {
      System.out.println("QUEUE EMPTY");
    } else {
      head = head.next;
    }
  }

  void displayQueue() {
    Node temp = head;
    while (temp != null) {
      System.out.print(temp.data + "-->");
      temp = temp.next;
    }
    System.out.println("null");
  }
}

class runSLL {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    SLL obj = new SLL();
    outer: while (true) {
      System.out.println("1.INSERT AT HEAD");
      System.out.println("2.INSERT AT LAST");
      System.out.println("3.INSERT AT BEFORE VALUE");
      System.out.println("4.DISPLAY");
      System.out.println("5.INSERT IN SORTED MANNER");
      System.out.println("6.RETURN COUNT OF NODES");
      System.out.println("7.DELETE BY VALUE KEY");
      System.out.println("8.DELETE AT HEAD");
      System.out.println("9.GET INDEX");
      System.out.println("10:DISPLAY ODD DATA");
      System.out.println("100.EXIT");
      System.out.print("ENTER CHOICE: ");
      int choice = sc.nextInt();
      switch (choice) {
        case 1:
          obj.insertAtHead();
          break;
        case 2:
          obj.insertAtLast();
          break;
        case 3:
          System.out.print("ENTER THE KEY: ");
          int num = sc.nextInt();
          obj.insertBeforeValue(num);
          break;
        case 4:
          obj.displaySLL();
          break;
        case 5:
          obj.insertSorted();
          break;
        case 6:
          System.out.println(obj.countNode());
          break;
        case 7:
          System.out.print("ENTER THE KEY: ");
          int key = sc.nextInt();
          System.out.println("DELETED: " + obj.deleteSpecNode(key));
          break;
        case 8:
          System.out.println("DELTED NODE: " + obj.deleteAtHead());
          break;
        case 9:
          System.out.print("ENTER THE KEY: ");
          key = sc.nextInt();
          System.out.println("INDEX OF " + key + " IS " + obj.findIndexOf(key));
          break;
        case 10:
          obj.displayOddPos();
          break;
        case 100:
          break outer;
        default:
          break;
      }
    }

    // ImplementingQueue impobj=new ImplementingQueue();
    // impobj.insertAtLast();
    // impobj.insertAtLast();
    // impobj.insertAtLast();
    // impobj.insertAtLast();
    // impobj.displayQueue();
    // impobj.deleteAtHead();
    // impobj.deleteAtHead();
    // impobj.displayQueue();
  }
}