import java.util.Scanner;

public class DLL {

    public static Scanner sc = new Scanner(System.in);

    class Node {
        int data;
        Node next, prev;

        Node() {
            System.out.print("ENTER DATA: ");
            data = sc.nextInt();
            this.next = null;
            this.prev = null;
        }
    }

    Node head = null;

    void insertAtHead() {
        Node newNode = new Node();
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    void insertAtLast() {
        Node newNode = new Node();
        if (head == null) {
            head = newNode;
        } else {
            Node last = head;
            while (last.next != null)
                last = last.next;
            newNode.prev = last;
            last.next = newNode;
        }
    }

    void insertBefVal(int key) {
        Node newNode = new Node();
        if (head == null) {
            System.out.println("CANNOT FIND KEY TO ADD BEFORE!!");
        } else {
            if (head.data == key) {
                head.prev = newNode;
                newNode.next = head;
                head = newNode;
            } else {
                Node temp = head;
                while (temp.data != key && temp.next != null) {
                    temp = temp.next;
                }
                if (temp.data == key) {
                    System.out.println("KEY FOUND: " + temp.data);
                    newNode.prev = temp.prev;
                    temp.prev.next = newNode;
                    temp.prev = newNode;
                    newNode.next = temp;
                } else {
                    System.out.println("KEY NOT FOUND!!");
                }
            }
        }
    }

    void insertSorted() {
        Node newNode = new Node();
        if (head == null) {
            head = newNode;
            newNode.prev = null;
            newNode.next = null;
        } else {
            if (newNode.data <= head.data) {
                System.out.println("head.data= " + head.data);
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            } else {
                Node temp = head;
                while (temp.data < newNode.data && temp.next != null) {
                    temp = temp.next;
                }
                System.out.println("temp.data= " + temp.data);
                if (temp.data > newNode.data) {
                    newNode.next = temp;
                    newNode.prev = temp.prev;
                    temp.prev.next = newNode;
                    temp.prev = newNode;
                } else {
                    temp.next = newNode;
                    newNode.prev = temp;
                    newNode.next = null;
                }
            }
        }
    }

    int deleteFirst() {
        int del = -1;
        if (head == null) {
            System.out.println("DLL EMPTY!!");
        } else {
            if (head.next == null) {
                del = head.data;
                head = null;
            } else {
                del = head.data;
                head = head.next;
                head.prev = null;
            }
        }
        return del;
    }

    int deleteLast() {
        int del = -1;
        if (head == null)
            System.out.println("DLL EMPTY!!");
        else {
            if (head.next == null) {
                del = head.data;
                head = null;
            } else {
                Node last = head;
                while (last.next != null)
                    last = last.next;
                del = last.data;
                last.prev.next = null;
                last.prev = null;
            }
        }
        return del;
    }

    int deleteSpeVal(int key) {
        int del = -1;
        if (head == null) {
            System.out.println("null");
        } else {
            if (head.data == key && head.next == null) {
                del = head.data;
                head = null;
            } else if (head.data == key) {
                del = head.data;
                head.next.prev = null;
                head.next = null;
            } else {
                Node temp = head;
                while (temp.data != key && temp.next != null)
                    temp = temp.next;
                if (temp.next == null && temp.data == key) {
                    del = temp.data;
                    temp.prev.next = null;
                    temp.prev = null;
                } else if (temp.data == key) {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                    temp.prev = null;
                    temp.next = null;
                } else {
                    System.err.println("KEY NOT FOUND!!");
                }
            }
        }
        return del;
    }

    void displayDLL() {
        if (head == null)
            System.out.println("null");
        else {
            Node temp = head;
            do {
                System.out.print(temp.data + "-->");
                temp = temp.next;
            } while (temp != null);
            System.out.println("null");
        }
    }

    void middleDLL() {
        if (head == null) {
            System.out.println("DLL EMPTY!!");
        } else {
            int count = 0;
            Node temp = head;
            do {
                count++;
                temp = temp.next;
            } while (temp != null);
            if (count % 2 == 0) {
                System.out.println("EVEN NO.OF NODES");
                Node slow = head, fast = head.next;
                while (fast.next != null && slow.next != null) {
                    fast = fast.next.next;
                    slow = slow.next;
                }
                System.out.println("MIDDLE TERM OF DLL IS: " + slow.data + " & " + slow.next.data);
            } else {
                System.out.println("ODD NO.OF NODES");
                Node slow = head;
                Node fast = head;
                while (fast.next != null && slow.next != null) {
                    fast = fast.next.next;
                    slow = slow.next;
                }
                System.out.println("MIDDLE TERM OF DLL IS: " + slow.data);
            }
        }
    }

    int maxNode() {
        int max = 0;
        if (head == null) {
            System.out.println("null");
        } else {
            Node temp = head;
            do {
                if (temp.data >= max) {
                    max = temp.data;
                }
                temp = temp.next;
            } while (temp != null);
        }
        return max;
    }

    void displayDLLRev() {
        Node last = head;
        while (last.next != null)
            last = last.next;
        do {
            System.out.print(last.data + "-->");
            last = last.prev;
        } while (last != null);
        System.out.println("head");
    }

    void displayOddVal() {
        Node temp = head;
        if (head == null) {
            System.out.println("DLL NULL");
        } else {
            do {
                if (temp.data % 2 != 0)
                    System.out.print(temp.data + "-->");
                temp = temp.next;
            } while (temp != null);
            System.out.println("null");
        }
    }
}

class DLLrun {
    public static void main(String[] args) {
        int choice, key;

        Scanner sc = new Scanner(System.in);

        DLL obj = new DLL();

        outer: while (true) {
            System.out.println(
                    "1.INSERT AT HEAD\n2.INSERT AT LAST\n3.INSERT BEFORE VALUE\n4.INSERET SORTED\n5.DELETE FIRST\n6.DELETE AT LAST\n7.DELETE SPECIFIC VALUE\n8.MIDDLE TERM\n9.MAX NODE OF DLL\n10.DISPLAY ODD TERMS\n50.DISPLAY DLL\n60.DISPLAY ULTA\n100.EXIT");
            System.out.print("ENTER CHICE: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    obj.insertAtHead();
                    break;
                case 2:
                    obj.insertAtLast();
                    break;
                case 3:
                    System.out.print("ENTER THE KEY TO ENTER BEFORE VALUE: ");
                    key = sc.nextInt();
                    obj.insertBefVal(key);
                    break;
                case 4:
                    obj.insertSorted();
                    break;
                case 5:
                    System.out.println(obj.deleteFirst());
                    break;
                case 6:
                    System.out.println(obj.deleteLast());
                    break;
                case 7:
                    System.out.println("ENTER THE NODE TO DELETE: ");
                    key = sc.nextInt();
                    System.out.println("DELETED: " + obj.deleteSpeVal(key));
                    break;
                case 8:
                    obj.middleDLL();
                    break;
                case 9:
                    System.out.println("MAX OF DLL IS: " + obj.maxNode());
                    break;
                case 10:
                    obj.displayOddVal();
                    break;
                case 50:
                    obj.displayDLL();
                    break;
                case 60:
                    obj.displayDLLRev();
                    break;
                case 100:
                    break outer;
                default:
                    break;
            }
        }
    }
}