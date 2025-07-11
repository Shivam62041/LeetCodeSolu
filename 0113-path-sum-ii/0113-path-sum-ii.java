
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans=new ArrayList();
       List<Integer> li=new ArrayList();
       path(root,targetSum,ans,li);
       return ans;
    }
    static void path(TreeNode root,int sum,List<List<Integer>> ans,List<Integer> li){
   
        if(root==null){
            return;
        }
      li.add(root.val);

      if(root.left==null && root.right==null){
           sum-=root.val;
            if(sum==0){
            ans.add(new ArrayList<>(li));
            }
      }
     
     
      path(root.left,sum-root.val,ans,li);
      path(root.right,sum-root.val,ans,li);
      li.remove(li.size()-1);
    }
}