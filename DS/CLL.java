import java.util.Scanner;

public class CLL {
    public static Scanner sc = new Scanner(System.in);

    class Node {
        Node next;
        int data;

        Node() {
            System.out.print("ENTER DATA: ");
            data = sc.nextInt();
            next = null;
        }
    }

    Node head = null;

    void insertAtHead() {
        Node newNode = new Node();
        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            Node last = head;
            while (last.next != head)
                last = last.next;
            newNode.next = head;
            head = newNode;
            last.next = head;
        }
    }

    void insertAtLast() {
        Node newNode = new Node();
        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            Node last = head;
            while (last.next != head)
                last = last.next;
            newNode.next = head;
            last.next = newNode;
        }
    }

    void insertBeforeValue(int key) {
        Node newNode = new Node();
        if (head == null) {
            System.out.println("KEY NOT FOUND!!");
            System.out.println("HEAD IS NULL SO " + newNode.data + " IS ADDDE AT HEAD.");
            head = newNode;
            newNode.next = head;
        } else if (head.data == key) {
            newNode.next = head;
            Node last = head;
            while (last.next != head)
                last = last.next;
            head = newNode;
            last.next = head;
        } else {
            Node temp = head;
            while (temp.next.data != key && temp.next != head) {
                temp = temp.next;
            }
            if (temp.next.data == key) {
                newNode.next = temp.next;
                temp.next = newNode;
            } else {
                System.out.println("KEY NOT FOUND!!");
            }
        }
    }

    void insertSorted() {
        Node newNode = new Node();
        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else if (newNode.data <= head.data) {
            newNode.next = head;
            Node last = head;
            while (last.next != head)
                last = last.next;
            head = newNode;
            last.next = newNode;
        } else {
            Node temp = head;
            while (newNode.data > temp.data && temp.next != head) {
                temp = temp.next;
            }
            if (temp.next == head) {
                newNode.next = head;
                temp.next = newNode;
            } else {
                newNode.next = temp.next;
                temp.next = newNode;
            }
        }
    }

    int deleteAtHead() {
        if (head == null) {
            System.out.println("CLL EMPTY!!");
            return -1;
        } else if (head.next == head) {
            Node del = head;
            head = null;
            return del.data;
        } else {
            Node del = head;
            Node last = head;
            while (last.next != head)
                last = last.next;
            head = head.next;
            last.next = head;
            return del.data;
        }
    }

    int deleteAtLast() {
        if (head == null) {
            return -1;
        } else if (head.next == head) {
            int del = head.data;
            head = null;
            return del;
        } else {
            Node last = head;
            while (last.next.next != head) {
                last = last.next;
            }
            int del = last.next.data;
            last.next = last.next.next;
            return del;
        }
    }

    int deleteSpecificVal(int key) {
        if (head == null)
            return -1;
        else {
            if (head.data == key && head.next == head) {
                head = null;
            } else if (head.data == key) {
                Node last = head;
                while (last.next != head) {
                    last = last.next;
                }
                head = head.next;
                last.next = head;
            } else {
                Node temp = head;
                while (temp.next.data != key && temp.next != head) {
                    temp = temp.next;
                }
                if (temp.next.data == key) {
                    temp.next = temp.next.next;
                } else {
                    System.out.println("KEY NOT FOUND!!");
                    return -1;
                }
            }
        }
        return key;
    }

    void displayCLL() {
        Node temp = head;
        outer: do {
            if (head != null) {
                System.out.print(temp.data + "-->");
                temp = temp.next;
            } else
                break outer;
        } while (temp != head);
        System.out.println("null");
    }

    Node head2 = null;

    void createCLL2(int num) {
        if (num == 0) {
            return;
        } else {
            Node newNode = new Node();
            if (head2 == null) {
                head2 = newNode;
                newNode.next = head2;
            } else {
                Node last = head2;
                while (last.next != head2)
                    last = last.next;
                last.next = newNode;
                newNode.next = head2;
            }
        }
        num--;
        createCLL2(num);
    }

    void concateTwoCLL(int num) {
        createCLL2(num);
        if (head2 != null) {
            Node last1 = head;
            while (last1.next != head) {
                last1 = last1.next;
            }
            last1.next = head2;
            Node last2 = head2;
            while (last2.next != head2) {
                last2 = last2.next;
            }
            last2.next = head;
            displayCLL();
        } else {
            System.out.println("CLL 2 NOT AVAIALABLE");
            displayCLL();
        }
    }

    int middlePoint() {
        Node slow = head, fast = head;
        int count = 0;
        Node temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);
        if (count % 2 != 0) {
            temp = head;
            while (fast.next != head) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow.data;
        } else {
            System.out.println("EVEN NO.OF NODES");
            return count;
        }
    }

    void displayOdd() {
        if (head == null) {
            System.out.println("NULL");
        } else {
            int count = 0;
            Node temp = head;
            System.out.println("1.START FROM 1\n2.START FROM 0");
            System.out.print("ENTER CHOICE: ");
            int choice = sc.nextInt();
            while (temp.next != head) {
                count++;
                temp = temp.next;
            }
            switch (choice) {
                case 1:
                    if (count % 2 == 0) {
                        temp = head.next;
                        Node slow = head;
                        do {
                            System.out.print(slow.data + "-->");
                            slow = slow.next.next;
                            temp = temp.next.next;
                        } while (temp != head);
                        System.out.println("null");
                    } else {
                        temp = head;
                        do {
                            System.out.print(temp.data + "-->");
                            temp = temp.next.next;
                        } while (temp != head);
                        System.out.println("null");
                    }
                    break;
                case 2:
                    if (count % 2 == 0) {
                        temp = head.next;
                        do {
                            System.out.print(temp.data + "-->");
                            temp = temp.next.next;
                        } while (temp.next != head);
                        System.out.println("null");
                    }
                    break;
                default:
                    break;
            }
        }
    }

    void deleteEvenPos() {
        if (head == null) {
            System.out.println("DLL EMPTY!!");
        } else {
            if (head.next == head) {
                System.out.println("ONLY ONE PRESENT IN CLL!!");
            } else {
                Node temp = head;
                while (temp.next.next != head && temp.next != head) {
                    temp.next = temp.next.next;
                    temp = temp.next;
                }
            }
        }
    }

    void deleteOddPos() {
        if (head == null) {
            System.out.println("EMPTY");
        } else if (head.next == null) {
            head = null;
        } else {
            Node temphead = head;
            head = head.next;
            Node temp = head;
            while (temp.next != head && temp.next.next != temphead) {
                temp.next = temp.next.next;
                temp = temp.next;
            }
            temp.next = head;
        }
    }

    void reverseCLL() {
        if (head == null || head.next == head) {
            System.out.println("REV NOT POSSIBLE!!");
        } else {
            Node prev = head;
            while (prev.next != head)
                prev = prev.next;
            Node curr = head;
            Node nextNode = head.next;
            do {
                curr.next = prev;
                prev = curr;
                curr = nextNode;
                nextNode = nextNode.next;
            } while (curr != head);
        }
    }
}

class CLLrun {
    static Scanner sc = new Scanner(System.in);

    public static void main(String args[]) {
        CLL obj = new CLL();
        outer: while (true) {
            System.out.println(
                    "1.ENTER AT HEAD\n2.ENTER AT LAST\n3.INSERT BEFORE VALUE\n4.ENTER SORTED\n5.DELETE AT HEAD\n6.DELETE AT LAST\n7.DELETE SPECIFIC VALUE\n8.MIDDLE POINT OF CLL\n9.CONCATE TEO CLLs\n10.DISPLAY ODD\n11.DELETE EVEN NODES\n12.DELETE ODD POS\n50.DISPLAY CLL\n100.EXIT");
            System.out.print("ENTER THE CHOICE: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    obj.insertAtHead();
                    break;
                case 2:
                    obj.insertAtLast();
                    break;
                case 3:
                    System.out.print("ENTER THE KEY TO ENTER BEFORE VLAUE: ");
                    int key = sc.nextInt();
                    obj.insertBeforeValue(key);
                    break;
                case 4:
                    obj.insertSorted();
                    break;
                case 5:
                    System.out.println("DELETED: " + obj.deleteAtHead());
                    break;
                case 6:
                    System.out.println("DELETED: " + obj.deleteAtLast());
                    break;
                case 7:
                    System.out.print("ENTER THE KEY TO DELETE : ");
                    key = sc.nextInt();
                    obj.deleteSpecificVal(key);
                    break;
                case 8:
                    System.out.println("MIDDLE POINT OF CLL IS: " + obj.middlePoint());
                    break;
                case 9:
                    System.out.print("ENTER SECOND CLL TO CONCATE: ");
                    System.out.println("ENTER NO.OF NODES TO ENTER: ");
                    int num = sc.nextInt();
                    obj.concateTwoCLL(num);
                    break;
                case 10:
                    obj.displayOdd();
                    break;
                case 11:
                    obj.deleteEvenPos();
                    break;
                case 50:
                    obj.displayCLL();
                    break;
                case 100:
                    break outer;
                default:
                    break;
            }
        }
    }
}