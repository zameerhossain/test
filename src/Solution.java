import java.util.*;

public class Solution{
    private ArrayList<Adjecent> adjecents;
    private Map<String, Integer> isVisited= new HashMap<>();

    private String startNode;

    public Solution(ArrayList<Adjecent> adjecents) {
        this.adjecents = adjecents;
        setIsVisited(adjecents);
    }
    private void setIsVisited(ArrayList<Adjecent> adjecents){
        adjecents.forEach(
                adjecent ->{
                    isVisited.put(adjecent.getNode(),0);
                    if(adjecent.getParent()=="None"){
                        startNode=adjecent.getNode();
                    }

                }
        );
    }
    List<Set<String>> allPath=new ArrayList<Set<String>>();


    List<String> endNode=new ArrayList<>(
            List.of(
                    "C",
                    "F","E"));




    public void possiblePath(){

        Set<String> path=new HashSet<>();



       findAdjecent(startNode,path);

        System.out.println(isVisited);
        System.out.println(allPath);


    }
    public Set<String> pathfinder(Set<String> path, Adjecent adjecent){
        Set<String> path1=new HashSet<>();
        path1.addAll(path);
        findAdjecent(adjecent.getNode(),path1);
        return path;
    }
    public void findAdjecent(String node, Set<String> path) {
        boolean isOne=false;
        if(isVisited.get(node)==1){

        }
        else{
            path.add(node);
            System.out.println("node :"+node+"--path :"+path+"--allpath :"+allPath);

            for (Adjecent adjecent:adjecents) {
                if(adjecent.getParent()==node){
                    if(adjecent.getBranch()=="Y"||adjecent.getBranch()=="N"){

                      path= pathfinder(path,adjecent);
                      System.out.println("node"+node+"pathfinder "+ path);


//                        path1.addAll(path);
//                        path1.add(adjecent.getNode());
//                        allPath.add(path1);
//                        findAdjecent(adjecent.getNode(),path1);

                    }
                    else if(adjecent.getBranch()=="None"){

//                        for(int i=0;i<allPath.size();i++){
//                            allPath.get(i).add(adjecent.getNode());
//                        }


//

                        for (Set<String> i:allPath) {

                            i.add(adjecent.getNode());

                        }
                        for(int i=0;i<allPath.size();i++){
                            findAdjecent(adjecent.getNode(), allPath.get(i));
                        }
                        isVisited.put(adjecent.getNode(), 1);

                    }

                }

            }
            if(endNode.contains(node)){
                Adjecent a=findadclass(node);
            if(a.getBranch()!="None"){
                allPath.add(path);

            }

            }
            System.out.println("lopp outside"+node +path);
            isVisited.put(node,1);

        }

    }

    public Adjecent findadclass(String node){
        for (Adjecent adjecent:adjecents
             ) {
            if(adjecent.getNode()==node){
                return adjecent;
            }
        }
        return null;
    }

    public int vistedPath(List<List<String>> allPath){
        int pathCount=0;
        for (List<String> path:allPath) {
            int length=path.size();
            int nodeCount=0;

            for(String node:path){
                if(isVisited.get(node)==1){
                  nodeCount++;
                }
            }
            if(length==nodeCount){
                pathCount++;
            }
        }
        return pathCount;

    }


}

