import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}

class Codec {
    public String serialize(TreeNode root) {
        if (root == null) {
            return "null";
        }
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            if (temp == null) {
                sb.append("null,");
                continue;
            }
            sb.append(temp.val + ",");
            q.add(temp.left);
            q.add(temp.right);

        }
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if (data.equals("null")) {
            return null;
        }
        String[] values = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        for(int i=1;i<values.length;){
            TreeNode parent = q.poll();
            if (!values[i].equals("null")){
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                q.add(left);
            }
            i++;
            if(i<values.length && !values[i].equals("null")){
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                q.add(right);
            }
            i++;
        }
        return root;
    }
}

class Solution {

    public static void main(String[] args) {
        Codec ser = new Codec();
        Codec deser = new Codec();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        String ans = ser.serialize(root);
        System.out.println("Serialize: " + ans);

        deser.deserialize(ans);
        // TreeNode newRoot = deser.deserialize(ans);
        // Compare(root, newRoot)
    }
}