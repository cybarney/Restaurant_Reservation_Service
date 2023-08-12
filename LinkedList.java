public class LinkedList {
    Table first;
    int size;
    public LinkedList(){
        first = null;
        size = 0;
    }
    public void add(int numberOfGuests, String name){//Adds reservation to list
        Table newGuest = new Table(numberOfGuests, name);
        if(first == null){
            first = newGuest;
        }
        else{
            Table pointer = first;
            while(pointer.next != null)
                pointer = pointer.next;
            pointer.next = newGuest;
        }
        size++;
    }
    public Table removeFirst() {//Removes the first item in the list
    	Table pointer = first;
    	if(first!=null) {
    		first = first.next;
    		size--;
    	
    	return pointer;}
    		else {//If list is empty returns empty table.
    			return new Table.EmptyTable();
    		}
    	
    }
    
    public Table removeLast() {//Removes the last reservation on the list.
    	
    	if(first == null) {//If list empty returns empty table.
    		return new Table.EmptyTable();
    		}
    	else {
    		Table last = first;
    		Table pointer = first;
    		while(last.next!=null) {
    			pointer = last;
    			last = last.next;
    			
    		}
    		pointer.next=null;
    		size--;
    		return last;
    	}

    }

	public Table removeMiddle(String name) {//Removes the middle reservation.
	int temp2=0;	
		if(first == null) {
			return new Table.EmptyTable();
		}
		else {
			size--;
			Table mid = first;
			Table pointer = first;
			temp2=getPosition(name);
			for(int i=0;i<temp2;i++) {//Traverses through list to the position found by getPosition.
				pointer = mid;
				mid=mid.next;
			
			}
			pointer.next=mid.next;
			
			return mid;	
			
		}
	}
    public Table removeGuest(String guestName) {//Removes a guest reservation based upon their name
    	if(first==null||getPosition(guestName)==-1) {
    		return new Table.EmptyTable();
    	}
    	else {
    		int temp=getPosition(guestName);
    		Table pointer = first;
    		
    		for(int i=0;i<temp;i++) {//Uses get position to find how long the pointer must traverse in the list.
    			pointer=pointer.next;
    		}
    		
    		if(temp==0) {
    			return removeFirst();
    		}else if(pointer.next==null) {
    			return removeLast();
    		}
    			else {
    				return removeMiddle(guestName);
    				
    			}
    	}
    	
    
    }
    
    public int getNumberOfParties(int numGuests) {//Returns the number of parties with a specified number of guests.
    Table pointer = first;
    Table pointer2 = first;
    int numOfGuests=0;
    	while(pointer2.next!=null) {
    		pointer2=pointer;
    		if(pointer.guests==numGuests) { numOfGuests++;}
    		pointer=pointer.next;
    	}
    	return numOfGuests;
    }
    
    public String listReservations() {//Lists all the reservations in the list.
    Table pointer = first;	
    String reservations ="";	
    	if(first == null) {
    		return ("No reservations in queue at this time.\n");
    	}else {
    		reservations = reservations+pointer.toString();
    		while(pointer.next!=null) {
    			reservations = reservations + pointer.next.toString();
    			pointer= pointer.next;
    		}
    		reservations = reservations + ("Total reservations: "+size+".\n");
    		return reservations;
    	}
    	
    }
    
    public int getPosition(String name) {//Gets the position of a reservation if it is there.
	int position=0;	
	Table pointer = first;
	Table pointer2 = first;
	Boolean placeHold = false;
		if(first == null) {
			return -1;
		}else {
			while(pointer2.next!=null&&placeHold==false) {
				String temp = pointer.name;
				if(temp.equals(name)) {
					placeHold=true;
					
					
				}else {
				pointer2=pointer;
				pointer= pointer.next;			
				position++;}
			}
			if(placeHold == true) {
				return position;
			}
			else return -1;
	}
}



}
