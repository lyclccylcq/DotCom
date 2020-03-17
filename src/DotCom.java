import java.util.*;
public class DotCom {
    private ArrayList<String> locationCells;
    private String name;

    public void setLocationCells(ArrayList<String> loc){
        locationCells=loc;
    }
    public void setName(String n){//setname方法
        name=n;
    }
    public String checkYourself(String userInput){
        String result="miss";
        int index=locationCells.indexOf(userInput);
        if (index>=0){
            locationCells.remove(index);//如果被猜中了，就删除被猜中的元素
            if (locationCells.isEmpty()){//如果部署位置已经被清空，则击沉
                result="kill";
                System.out.println("Ouch!You sunk"+name+":(");
            }else{
                result="hit";
            }
        }
        return result;
    }

}
