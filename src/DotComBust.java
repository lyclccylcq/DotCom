import java.util.*;

public class DotComBust {
    private GameHelper helper=new GameHelper();
    private  ArrayList<DotCom> dotComsList=new ArrayList<DotCom>();
    private int numOfGuesses=0;

    private void setUpGame(){
        //创建dot并把地址赋给list
        DotCom one= new DotCom();
        one.setName("Pets.com");
        DotCom two= new DotCom();
        two.setName("eToys,com");
        DotCom three= new DotCom();
        three.setName("Go2.com");
        dotComsList.add(one);
        dotComsList.add(two);
        dotComsList.add(three);

        System.out.println("Your task is to sink three dot coms.");
        System.out.println("Pets.com,eToys.com,Go2.com");
        System.out.println("Try to sink them all in the fewest number of guesses");

        for (DotCom dotComToSet:dotComsList){
            ArrayList<String>newLocation = helper.placeDotCom(3);
            dotComToSet.setLocationCells(newLocation);
        }
    }

    private void startPlaying(){
        while (!dotComsList.isEmpty()){
            String userGuess =helper.getUserInput("Enter a guess");
            checkUserGuess(userGuess);
        }
        finishGame();
    }

    private void checkUserGuess(String userGuess){
        numOfGuesses++;
        String result ="miss";
        for (DotCom dotComToTest:dotComsList){
            result=dotComToTest.checkYourself(userGuess);
            if (result.equals("hit")){
                break;
            }
            if(result.equals("kill")){
                dotComsList.remove(dotComToTest);
                break;
            }
        }
        System.out.println(result);
    }

    private void finishGame(){
        System.out.println("All Dot Coms are dead!Your stock is now worthless.");
        if (numOfGuesses<=18){
            System.out.println("It only take you "+numOfGuesses+"guesses.");
            System.out.println("You got out before your options sank.");
        }else{
            System.out.println("Took you enough. "+numOfGuesses+"guesses.");
            System.out.println("Fish are dancing with your options");
        }
    }//打印玩家成绩

    public static void main(String[] args){
        DotComBust game =new DotComBust();//创建游戏对象
        game.setUpGame();//启动游戏对象
        game.startPlaying();//启动循环
    }
}
