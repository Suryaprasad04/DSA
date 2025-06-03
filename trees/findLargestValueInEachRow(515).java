class Solution {
    public List<Integer> largestValues(TreeNode root) {
         List<Integer>list=new ArrayList<>();
        if(root==null){
            return list;
        }
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
      
        while(!q.isEmpty()){
            int size=q.size();
           
            int max=Integer.MIN_VALUE;
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                 if(node.val>max){
                    max=node.val;
                }
                if(node.left!=null){
                    q.offer(node.left);
                }
                if(node.right!=null){
                    q.offer(node.right);
                }
               
            }
            list.add(max);
        }
        return list;
    }
}
