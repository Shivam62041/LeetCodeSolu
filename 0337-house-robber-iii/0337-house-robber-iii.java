class Solution {
    Map<TreeNode,Integer> map=new HashMap<>();
    public int rob(TreeNode root) {
        return solve(root);
    }

    public int solve(TreeNode root){
        if(root==null)return 0;

        if(map.containsKey(root))return map.get(root);

        //TAKE
        int opt1=root.val;
        if(root.left!=null){
            opt1+=solve(root.left.left);
            opt1+=solve(root.left.right);
        }
        if(root.right!=null){
            opt1+=solve(root.right.left);
            opt1+=solve(root.right.right);
        }

        //SKIP
        int opt2= solve(root.left)+solve(root.right);
        int ans= Math.max(opt1,opt2); 
        map.put(root,ans);
        return ans;
    }
}