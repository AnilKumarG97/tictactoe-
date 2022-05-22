import java.util.*;
class tictactoe
{



static ArrayList<Integer> playerpos=new ArrayList<Integer>();
static ArrayList<Integer> cpupos=new ArrayList<Integer>();

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
	if (p.equals("player"))
	{
		c='X';
		playerpos.add(pos);

	}
	else if (p.equals("cpu"))
	{
		c='O';
		cpupos.add(pos);
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
		  if (playerpos.containsAll(x))
		  {
			  System.out.println("Player won the match!!!");
			   System.exit(0);
		  }
		 else if (cpupos.containsAll(x))
		  {
			  System.out.println("Player cpu the match!!!");
			  System.exit(0);
		  }
		  else if ((playerpos.size() + cpupos.size())==9)
		  {
			  System.out.println("match is Draw!!!");
			  System.exit(0);
		  }
	   }
	}
}




class tikgame
{
	public static void main(String[] args)
	{
Scanner sc=new Scanner(System.in);
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

System.out.println("Enetr the postion between 1-9");
             int ppos=sc.nextInt();
while (tictactoe.playerpos.contains(ppos) || tictactoe.cpupos.contains(ppos))
{
           System.out.println("ALready the postion is occpuied pleace enter another value");
         ppos=sc.nextInt();

}
        t.userpos(ppos,board,"player");
		  t.display(board);
		  t.winningCond();


		  //cpu code
Random rand=new Random();
             int cpos=rand.nextInt(9)+1;//(0+1=1) untill 1-9
        while (tictactoe.playerpos.contains(cpos) || tictactoe.cpupos.contains(cpos))
{
           System.out.println("ALready the postion is occpuied pleace enter another value");
            cpos=rand.nextInt(9)+1;
}
		t.userpos(cpos,board,"cpu");
		  t.display(board);
		  t.winningCond();

}

	}

}