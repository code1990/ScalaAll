import java.io.File;

public class Test {

    public static final String  pathName = "D:\\IdeaProjects\\ScalaAll\\src\\main\\scala\\";
    public static void main(String[] args) {
        for (int i = 0; i <=111 ; i++) {
            String flag = "";
            if(i <= 9){
                flag = "d00"+i;
            } else if(i <=99 && i >=10){
                flag = "d0"+i;
            } else {
                flag = "d"+i;
            }
            File file = new File(pathName+flag);
            if(!file.exists()){
                file.mkdir();
            }

        }
        System.out.println("end");
    }
}
