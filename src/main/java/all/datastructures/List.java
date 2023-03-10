package all.datastructures;
import java.util.Scanner;
import java.util.logging.Logger;

class List{
    private static final Logger LOGGER =  Logger.getLogger("InfoLogging");
    Node head;
    int size = 0;

    public void insert(int index, int data){
        Node node = new Node(data);
        Node current = this.head;
        Node previous = current;
        int count = 0;
        if (index == 0){
            current = node;
            if(this.head!=null)
                current.next = this.head;
            this.head = current;
        }
        else{
            while(current.next != null){
                if(count!=index){
                    previous = current;
                    current = current.next;
                    count++;
                }
            }
            previous.next = node;
            node.next = current;
        }
        size++;
    }

    public void insert(int data){
        Node node = new Node(data);
        if (this.head == null){
            this.head = node;
        }
        else{
            Node current = this.head;
            while(current.next != null){
                current = current.next;
            }
            current.next = node;
        }
        size++;
    }
    public void remove(){
        Node current = this.head;
        Node previous = null;
        while(current.next!=null){
            previous = current;
            current = current.next;
        }
        previous.next = null;
        size--;
    }

    public void remove(int index){
        Node current = this.head;
        Node previous = current;
        int count = 0;
        if(index == 0){
            this.head = current.next;
        }else{
            while(current.next != null){
                if(count != index){
                    previous = current;
                    current = current.next;
                    count++;
                }
                else{
                    break;
                }
            }
            previous.next = current.next;
        }
        
    }
    public void removeValue(int data){
        Node current = this.head;
        Node previous = current;
        if(this.head.data == data){
            this.head = current.next;
        }
        else{
            while(current.data!=data){
                if(current.next!=null){
                    previous = current;
                    current = current.next;
                }   
            }
            previous.next = current.next;
        }
    }

    public void display(){
        if(size == 0){
            LOGGER.info("List empty");
        }
        else{
            Node current = this.head;
            if(current != null){
                StringBuilder s = new StringBuilder("");
                while(current!=null){
                    s.append(""+current.data+" ");
                    current = current.next;
                }
                String str = ""+s;
                LOGGER.info(str);
            }
        }
        
    }

    public void accessList(){
        Scanner sc = new Scanner(System.in);
        int n = 0;
        do{
            LOGGER.info("1.Add 2.Remove 3.display 4.exit");
            int m = sc.nextInt();
            if(m == 1){
                LOGGER.info("1.insert last 2.insert at index");
                int z = sc.nextInt();
                if(z == 1){
                    LOGGER.info("Enter a Element to insert: ");
                    int data = sc.nextInt();
                    insert(data);
                }
                else if(z == 2){
                    LOGGER.info("Enter a index to insert: ");
                    int index = sc.nextInt();
                    LOGGER.info("Enter a Element to insert: ");
                    int data = sc.nextInt();
                    insert(index, data);
                }
            }
            else if(m == 2){
                LOGGER.info("1.Remove last 2.Remove index 3.RemoveElement");
                int z = sc.nextInt();
                if(z == 1){
                    remove();
                }
                else if(z == 2){
                    LOGGER.info("Enter a index to remove: ");
                    int data = sc.nextInt();
                    remove(data);
                }
                else if(z == 3){
                    LOGGER.info("Enter a element to remove: ");
                    int data = sc.nextInt();
                    removeValue(data);
                }
                
            }
            else if(m == 3){
                display();
            }
            else if(m == 4){
                n = 1;
            }
        }while(n == 0);
    }
}