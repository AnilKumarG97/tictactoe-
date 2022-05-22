import java.util.*;
class tictactoe
{
static ArrayList<Integer> player1pos=new ArrayList<Integer>();
static ArrayList<Integer> player2pos=new ArrayList<Integer>();
void display(char[][] board)
	{
for (char row[] :board)
    {
for (char x:row)
	{
	System.out.print(x);
    }
     System.out.println();
       }
          }
void userpos(int pos,char board[][], String p)
	{
	char c=' ';
	if (p.equals("player 1"))
	{
		c='X';
		player1pos.add(pos);

	}
	else if (p.equals("player 2"))
	{
		c='O';
		player2pos.add(pos);
	}
		  switch (pos)
          {
          case 1:
			  board [0][0] = c;
			  break;
          case 2:
			  board [0][2] = c;
			  break;
		  case 3:
			  board [0][4] = c;
			  break;
		case 4:
			  board [2][0] = c;
			  break;
          case 5:
			  board [2][2] = c;
			  break;
		  case 6:
			  board [2][4] = c;
			  break;
			case 7:
			  board [4][0] = c;
			  break;
          case 8:
			  board [4][2] = c;
			  break;
		  case 9:
			  board [4][4] = c;
    			  break;
  
          default:
			  
          System.out.println("Wrong Input");		
          }
	}
void winningCond()
	{
	// for row
	List topRow = Arrays.asList(1,2,3);
	List midRow = Arrays.asList(4,5,6);
	List botRow = Arrays.asList(7,8,9);

	//for column
    List rightcol = Arrays.asList(1,4,7);
	List midcol = Arrays.asList(2,5,8);
	List leftcol = Arrays.asList(3,6,9);

	// for diaglon
	  List dig1 = Arrays.asList(1,5,9);
	   List dig2 = Arrays.asList(3,5,7);

	   ArrayList<List> wincond = new ArrayList<List>();
      wincond.add(topRow);
	  wincond.add(midRow);
	  wincond.add(botRow);
	  wincond.add(rightcol);
	  wincond.add(leftcol);
	  wincond.add(dig1);
	  wincond.add(dig2);

	  for (List x:wincond)
	  {
		  if (player1pos.containsAll(x))
		  {
			  System.out.println("Player 1 won the match!!!");
			   System.exit(0);
		  }
		 else if (player2pos.containsAll(x))
		  {
			  System.out.println("Player 2 won  the match!!!");
			  System.exit(0);
		  }
		  else if ((player1pos.size() + player2pos.size())==9)
		  {
			  System.out.println("match is Draw!!!");
			  System.exit(0);
		  }
	   }
	}
}




class TictactoePlayer
{
	public static void main(String[] args)
	{
Scanner p1=new Scanner(System.in);
Scanner p2=new Scanner(System.in);
		tictactoe t= new tictactoe();
char board[][] = {{' ','|',' ','|',' '},
	              {'-','+','-','+','-'},
				  {' ','|',' ','|',' '},
                  {'-','+','-','+','-'},
				  {' ','|',' ','|',' '},
				  } ;
     t.display(board);

//player 1
while (true)
{
System.out.println("player 1 turn");
             int p1pos=p1.nextInt();
while (tictactoe.player1pos.contains(p1pos) || tictactoe.player2pos.contains(p1pos))
             {
           System.out.println("ALready the postion is occpuied pleace enter another value");
         p1pos=p1.nextInt();
             }
        t.userpos(p1pos,board,"player 1");
		  t.display(board);
		  t.winningCond();


		  //player 2 code
System.out.println(" player 2 turn");
             int p2pos=p2.nextInt();
        while (tictactoe.player1pos.contains(p2pos) || tictactoe.player2pos.contains(p2pos))
            {
           System.out.println("ALready the postion is occpuied pleace enter another value");
            p2pos=p2.nextInt();
             }
		t.userpos(p2pos,board,"player 2");
		  t.display(board);
		  t.winningCond();
}
}
}