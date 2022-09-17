import java.util.*;

class Adjecent{
    private String parent;
    private String branch;
    private String node;

    public Adjecent(String parent, String branch,String node) {
        this.parent = parent;
        this.branch = branch;
        this.node = node;
    }

    public String getParent() {
        return parent;
    }
    public String getNode() {
        return node;
    }
        public String getBranch() {
        return branch;
    }
}


public class Main{
    static int total;
    public static void main(String[] args) {

//        Scanner s=new Scanner(System.in);
//        total=s.nextInt();
//        for (int i=0;i<total-1;i++){
//            System.out.println("Give parent name");
//            System.out.println("Give branch name");
//        }
        ArrayList<Adjecent> adjecentList=new ArrayList<Adjecent>();


        Adjecent A=new Adjecent("None","None", "A");
        Adjecent B=new Adjecent("A","Y","B");
        Adjecent C=new Adjecent("A","N","C");
        Adjecent D=new Adjecent("A","None","D");
        Adjecent E=new Adjecent("B","Y","E");
        Adjecent F=new Adjecent("D","None","F");
        Adjecent G=new Adjecent("F","Y","G");
        Adjecent H=new Adjecent("F","N","H");

        adjecentList.add(A);

        adjecentList.add(B);
        adjecentList.add(C);
        adjecentList.add(D);
        adjecentList.add(E);
        adjecentList.add(F);


        adjecentList.forEach(
                adjecent -> {
                    System.out.println("Parent :"+adjecent.getParent()+
                                    "---Branch :"+ adjecent.getBranch()
                            );
                }
        );
        Solution solution=new Solution(adjecentList);
        solution.possiblePath();
    }
}
