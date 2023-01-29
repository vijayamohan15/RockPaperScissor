package org.example;
import java.io.*;
import java.util.*;
public class RPSgame{
    static int player1 =0;
    static int player2 =0;
    static String name="";
    static int score=0;
    public static void main(String args[]) throws IOException {
      //  HashMap<String,Integer> map=new HashMap<>();
        BufferedReader br=new BufferedReader(new FileReader("C:\\Users\\arjun\\projects\\demo\\src\\rps.txt"));
        String st,p="";
        while((st=br.readLine())!=null) {
            p+=st;
        }
        String[] test=p.split(" ");
        Scanner sc=new Scanner(System.in);
        String choice[]={"Rock", "Paper", "Scissors"};
        boolean f=true;
        while(f){

            System.out.print("Player1: ");
            String userString=sc.next();
            int userChoice=userString.equals(choice[0])?0:(userString.equals(choice[1])?1:2);
            int compChoice=getComp();
            getDecision(compChoice, userChoice);
            System.out.println("Player2: "+choice[compChoice]);
            System.out.println("Player1: "+ player1 +" Player2: "+ player2);
            System.out.println("Do you want to quiet?(yes or no)");
            String s=sc.next();
            if(s.equals("yes"))
                f=false;
            else
                continue;
        }
        getResult();
        if(Integer.parseInt(test[1])<score) {
            BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\arjun\\projects\\demo\\src\\rps.txt"));
            writer.write(name + " " + score);
            writer.flush();
        }
        //map.put(name,score);
    }
    public static int getComp(){
        Random obj=new Random();
        int move=obj.nextInt(3);
        return move;
    }
    public static void getDecision(int choice1, int choice2){
        if(choice1==choice2)
            System.out.print("There was a draw ");
        else{
            switch(choice1){
                case 0: if(choice2==2)
                    player2 +=10;
                else
                    player1 +=10;
                    break;

                case 1: if(choice2==0)
                    player2 +=10;
                else
                    player1 +=10;
                    break;

                case 2: if(choice2==1)
                    player2 +=10;
                else
                    player1 +=10;
                    break;
            }}
    }

    public static void getResult(){
        if(player1 > player2){
           name="Player1";
           score=player1;
            System.out.println("Player1 Wins");
            System.out.println(player1);

        }
        else if(player2 > player1){
            name="Player2";
            score=player2;
            System.out.println("Player2 wins");
            System.out.println(player2);
        }
        else
            System.out.println("The match was draw");
    }
}
