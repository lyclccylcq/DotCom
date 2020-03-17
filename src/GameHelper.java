import java.io.*;
import java.util.*;

public class GameHelper {
    private static final String alphabet ="abcdefg";
    private int gridLength=7;
    private int gridSize=49;
    private int[] grid=new int[gridSize];
    private int comCount=0;

    public String getUserInput(String prompt){
        String inputline=null;
        System.out.println(prompt+" ");
        try {
            BufferedReader is=new BufferedReader(new InputStreamReader(System.in));
            inputline=is.readLine();
            if (inputline.length()==0)
            return null;
        }catch (IOException e){
            System.out.println("IOException:"+ e);
        }
        return inputline.toLowerCase();
    }

    public ArrayList<String>placeDotCom(int ComSize){
        ArrayList<String>alphaCells=new ArrayList<String>();
        String [] alphacoords=new String[ComSize];
        String temp=null;
        int[] coords=new int[ComSize];
        int attempts=0;
        boolean success=false;
        int location=0;
        
        comCount++;
        int incr=1;
        if ((comCount%2)==1){
            incr=gridLength;
        }
        while(!success&attempts++<200){
            location=(int)(Math.random()*gridSize);
            int x=0;
            success=true;
            while(success&&x<ComSize){
                if (grid[location]==0){
                    coords[x++]=location;
                    location+=incr;
                    if (location>=gridSize){
                        success=false;
                    }
                    if (x>0&&(location%gridLength==0)){
                        success=false;
                    }
                }else{
                    success=false;
                }
            }
        }
        int x=0;
        int row=0;
        int colum=0;
        while(x<ComSize){
            grid[coords[x]]=1;
            row=(int)(coords[x]/gridLength);
            colum=coords[x]%gridLength;
            temp=String.valueOf(alphabet.charAt(colum));
            
            alphaCells.add(temp.concat(Integer.toString(row)));
            x++;
        }
        return alphaCells;
    }

}
