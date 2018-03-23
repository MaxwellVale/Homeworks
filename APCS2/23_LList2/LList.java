//Daniel Gelfand and Maxwell Vale
//APCS2 pd2
//HW#23 -- Give and Take
//2018-02-23
/*****************************************************
* class LList
* Implements a linked list of LLNodes, each containing String data
*****************************************************/

public class LList implements List //your List interface must be in same dir
{

  //instance vars
  private LLNode _head;
  private int _size;

  // constructor -- initializes instance vars
  public LList( )
  {
    _head = null; //at birth, a list has no elements
    _size = 0;
  }


  //--------------v  List interface methods  v--------------

  public boolean add( String newVal )
  {
    LLNode tmp = new LLNode( newVal, _head );
    _head = tmp;
    _size++;
    return true;
  }

  public void add(int i, String s){

    if ( i < 0 || i >= size() )
    throw new IndexOutOfBoundsException();

    if(i==0){
      add(s);
    }
    else{
      LLNode walk = _head;
      for(int j = 0; j < i-1; j++){
        walk = walk.getNext();
      }
      LLNode desired = new LLNode(s,walk.getNext());
      walk.setNext(desired);
    }
    _size++;
  }

  public String remove(int i){

    if ( i < 0 || i >= size() )
    throw new IndexOutOfBoundsException();

    LLNode temp = _head;
    //if head node needs to be removed
    if(i==0){
      _head = temp.getNext();
      return temp.getCargo();

    }
    //go to node at index i-1
    for(int j = 0; j < i - 1; j++){
      temp = temp.getNext();
    }
    String retVal = temp.getNext().getCargo();
    //Jump past node to be removed and set to pointer to the next node
    LLNode next = temp.getNext().getNext();
    temp.setNext(next);
    _size--;
    return retVal;
  }

  public String get( int index )
  {
    if ( index < 0 || index >= size() )
    throw new IndexOutOfBoundsException();

    String retVal;
    LLNode tmp = _head; //create alias to head

    //walk to desired node
    for( int i=0; i < index; i++ )
    tmp = tmp.getNext();

    //check target node's cargo hold
    retVal = tmp.getCargo();
    return retVal;
  }


  public String set( int index, String newVal )
  {

    if ( index < 0 || index >= size() )
    throw new IndexOutOfBoundsException();

    LLNode tmp = _head; //create alias to head

    //walk to desired node
    for( int i=0; i < index; i++ )
    tmp = tmp.getNext();

    //store target node's cargo
    String oldVal = tmp.getCargo();

    //modify target node's cargo
    tmp.setCargo( newVal );

    return oldVal;
  }


  //return number of nodes in list
  public int size() { return _size; }

  //--------------^  List interface methods  ^--------------


  // override inherited toString
  public String toString()
  {
    String retStr = "HEAD->";
    LLNode tmp = _head; //init tr
    while( tmp != null ) {
      retStr += tmp.getCargo() + "->";
      tmp = tmp.getNext();
    }
    retStr += "NULL";
    return retStr;
  }


  //main method for testing
  public static void main( String[] args )
  {
    LList james = new LList();

    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("beat");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("a");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("need");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("I");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    System.out.println( "2nd item is: " + james.get(1) );

    james.set( 1, "got" );
    System.out.println( "...and now 2nd item is: " + james.set(1,"got") );

    System.out.println( james );
    james.add(3,"FIRE");
    james.add(0,"You");
    james.add(1,"and");
    System.out.println(james);

    System.out.println();

    System.out.println("Removing : " + james.remove(0));
    System.out.println(james);
    System.out.println("Removing : " + james.remove(5));
    System.out.println(james);
    System.out.println("Removing : " + james.remove(1));
    System.out.println(james);






  }

}//end class LList
