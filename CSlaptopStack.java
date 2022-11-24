//  Devin Rollins
//  drollins1108@gmail.com
//  CSC 3280 section 2
//  *** HONOR CODE***
//  I will practice academic and personal integrity and excellence of character and expect the same from others.

public class CSlaptopStack {
    private int[] stack;
    private int maxSize;
    private int top = -1;

    public CSlaptopStack() {
    }

    public CSlaptopStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }
    
    //Here, we will have the stack methods that we have come to know and love
    public boolean isFull(){
        return (top == maxSize-1);
    }
    
    public boolean isEmpty(){
        return (top == -1);
    }
    
    public void push(int laptopNum){
        if (isFull()) {
            System.out.println("Too many laptops. ");
        } else{
            top++;
            stack[top] = laptopNum;
        }
    }
    
    public int pop(){
        int temp = top;
        if (isEmpty()) {
            return -1;
        } else{
            temp = stack[top];
            top--;
            return temp;
        } 
    }
    
    public void printStack(){
        for (int i = 0; i < top; i++) {
            System.out.println(stack[i] + ", ");  
        }
        System.out.println("");
    }
    
    public int peek(){
        if (isEmpty()) 
            return -1;
        else
            return stack[top];
    }

    public int[] getStack() {
        return stack;
    }

    public void setStack(int[] stack) {
        this.stack = stack;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }
}
