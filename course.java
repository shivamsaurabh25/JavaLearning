import java.util.ArrayList;
import java.util.Collection;
class course{
    public static void main(String[] args) {
        ArrayList<String> co = new ArrayList<>();
        co.add("BCA");
        co.add("BBA");
        co.add("MCA");
        co.add("MBA");
        for(int i=0;i<co.size();i++){
            System.out.println(co.get(i));
        }
        for(String st:co){
            System.out.println(st);
        }
        co.clear();
    }
}