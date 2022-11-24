//  Devin Rollins
//  drollins1108@gmail.com
//  CSC 3280 section 2
//  *** HONOR CODE***
//  I will practice academic and personal integrity and excellence of character and expect the same from others.

public class CSqueue {
    private CSstudent front;    //AKA head
    private CSstudent back;     //AKA tail

    public CSqueue() {
    }

    public CSqueue(CSstudent front, CSstudent back) {
        this.front = front;
        this.back = back;
    }
    
    public int countNodes(){
        CSstudent helper = front;
        int counter = 0;
        while(helper != null){
            counter++;
            helper = helper.getNext();
        }
        return counter;
    }
   
    
    public boolean isEmpty(){
        return front == null;
    }

    public CSstudent getFront() {
        return front;
    }

    public void setFront(CSstudent front) {
        this.front = front;
    }

    public CSstudent getBack() {
        return back;
    }

    public void setBack(CSstudent back) {
        this.back = back;
    }
    
    public void enqueue(CSstudent person){
        if (back == null) {
            front = back = person;
        } else{        
            back.setNext(person);
            back = back.getNext();
        }
    }
    
	public CSstudent dequeue() {
		CSstudent temp = front;
		front = dequeue(front);
		if (front == null)
			back = null;
		return temp;
	}
	//
	// CSstudent | dequeue(CSstudent)
	//
	private CSstudent dequeue(CSstudent front) {
		front = front.getNext();
		return front;
	}
    
    
    public void clear(){
        front = null;
        back = null;
    }
    
}
