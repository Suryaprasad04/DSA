class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer>list=new ArrayList<>();
        Set<Integer>set=new HashSet<>();

        for(List<Integer>x:edges){
            set.add(x.get(1));
        }
        for(int i=0;i<n;i++){
            if(!set.contains(i)){
                list.add(i);
            }
        }
          
        return list;
    }
}





class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] indegree=new int[n];
        List<Integer>list=new ArrayList<>();

        for(int i=0;i<edges.size();i++){
            indegree[edges.get(i).get(1)]++;
        }
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                list.add(i);
            }
        }
          
        return list;
    }
}
