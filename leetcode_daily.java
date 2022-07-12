// class Solution {

//     public class pair{
//         TreeNode node;
//         int num;
//         pair(TreeNode node, int num){
//             this.node=node;
//             this.num=num;
//         }
//     }
//     public int widthOfBinaryTree(TreeNode root) {
//         List<List<Integer>> ans=new ArrayList<>();
        
//         Queue<pair> list=new LinkedList<>();
//         list.add(new pair(root,0));
        
//         while(list.size()!=0){
//             int first=0;
//             int last=0;
//             int size=list.size();
//             int min=list.peek().num;
//             for(int i=0;i<size;i++){
//                 pair rpair=list.peek();
//                 int curr_id=rpair.num-min;
//                 TreeNode node=rpair.node;


//                 list.poll();

//                 if(i==0) first=curr_id;
//                 if(i==size-1) last=curr_id;


//                 if(node.left!=null) list.offer(new pair(node.left, curr_id*2+1));
//                 if(node.right!=null) list.offer(new pair(node.right,curr_id*2+2));


//             }

//             ans=Math.max(ans,last-first+1);
//         }

        
//         return ans;

//     }
// }


// // contest weekly 300
// class Solution {
//     public String decodeMessage(String key, String message) {
//       StringBuilder ans=new StringBuilder();

//       HashMap<Character,Character> map=new HashMap<>();

//       key=key.replaceAll(" ","");
//       char ch='a';
//       for(int i=0;i<key.length();i++){
//         if(!map.containsKey(key.charAt(i))){
//             map.put(key.charAt(i),ch++);
//         }
//       }


//       for(int i=0;i<message.length();i++){
//         if(map.containsKey(message.charAt(i))){
//             // normal append;
//             ans.append(map.get(message.charAt(i)));
//         }else {
//             // loop for space ;

//             ans.append(message.charAt(i));
//         }
//       }

//       return ans.toString();  
//     }
// }
// //  question 2
// class Solution {
//     public int[][] spiralMatrix(int m, int n, ListNode head) {
        
//         // 4 cases

//         int case=1;
//         int [][]mat=new int[m][n];
//         for(int a[]:mat){
//             Array.fill(a,-1);
//         }
//         int sr=0;
//         int sc=0;
//         int er=m-1;
//         int ec=n-1;
//         ListNode node=head;
//         while(node!=null){
//           // case 1
//             if(case%4==1){
//               int ele=ec-sc+1;
//               int i=sc;
//               while(i<=ec){
//                  mat[sr][i++]=node.val;
//                  node=node.next;
//               }
//               sr++; 
//               case++;   
//             }else if(case%4==2){
//                int ele=er-sr+1;
//                int i=sr;
//                while(i<=er){
//                 mat[i++][ec]=node.val;
//                 node=node.next;
//                }
//                ec--;
//               case++;
//             }else if(case%4==3){
//                int i=ec;
//                while(i>=sc){
//                  mat[er][i]=node.val;
//                  node=node.next;
//                }
//                er--;
//                case++;

//             }else if(case%4==0){
//                 int i=er;

//                 while(i>=sr){
//                     mat[i][sc]=node.val;
//                     node=node.next;
//                 }
//              sc++;  
//              case++;
//             }
//         }


//         return mat;
//     }
// }

// // leetcode 687

// // class Solution {
// //     public class pair{
// //         TreeNode node;
// //         int maxp;
// //         int maxAll;
        
// //         pair(){}
// //         pair(TreeNod node,int maxp, int maxAll){
// //             this.node=node;
// //             this.maxp=maxp;
// //             this.maxAll;

// //         }
// //     }
// //     public pair findNodes(TreeNode node){
// //         if(node==null) return new pair();
        
// //         if(node.left==null && node.right==null){
// //             return new pair(node,1,1);
// //         }

// //         pair left=findNodes(node.left,maxn);
// //         pair right=findNodes(node.right,maxn);
        
// //         pair myp=new pair();

// //         myp.node=node;

// //         if(left.node.val==node.val && right.node.val==node.val){
// //             myp.maxp=left.maxp+right.maxp+1;
// //         }else if(left.node.val==node.val ){
// //             myp.maxp=left.maxp+1;
// //         }else if(right.node.val==node.val){
// //             myp.maxp=right.maxp+1;
// //         }

// //         myp.maxAll=Math.max(Math.max(left.maxp,right.maxp),myp.maxp);

// //         return myp;

// //     }
// //     public int longestUnivaluePath(TreeNode root) {
// //          int maxsnodes=0;
        
// //          pair ans==findNodes(root);
        
        
// //         return ans.maxAll-1;
        
// //     }
// // }


// // 

// class Solution {
//     public class pair{
//         int val=-1001;
//         int len=0;
//         int max=-1;
//     }
//     public pair findmaxp(TreeNode node){
//         if(node==null) return new pair();

//         pair left=findmaxp(node.left);
//         pair right=findmaxp(node.right);

//         int l=0;
//         int mmax=Math.max(left.max, right.max);

//         if(left.node.val==node.val && right.node.val==node.val){
//            maxx=Math.max(maxx,left.len+right.len+1);
//            l=Math.max(left.len,right.len)+1;  
//         }else if(left.node.val==node.val ){
//              l=left.len+1;
//              maxx=Math(maxx,left.max+1);
//         }else if(right.node.val==node.val){
//              l=right.len+1;
//              maxx=Math.max(maxx,l);
//         }else{
//             maxx=Math.max(1,maxx);
//             l=1;
//         }


//         pair my=new pair();
//         my.val=node.val;
//         my.len=l;
//         my.max=maxx;


//         return my;
//     }
//     public int longestUnivaluePath(TreeNode root) {
//         if(root==null) return 0;

//         pair p=findmaxp(root);

//         return p.max-1;
//     }
// }



// // Cameras

// class Solution {
//     // 0-> covered -1-> need camera 1-> i have camera
//     public int findCameras(TreeNode node,int cam){
//         if(node==null) return 0;


//         int left=findCameras(node.left, cam);
//         int right=findCameras(node.right,cam);

//         if(left==-1 || right ==-1){
//             cam++;
//             return 1;
//         }else if(left==1 || right==1){
//              return 0;
//         }

//         return -1;
//     }
//     public int minCameraCover(TreeNode root) {
//         if(root==null) return 0;
//         int cam=0;
//         int val=findCameras(root,cam);

//         return cam;
//     }
// }


// // 297. Serialize and Deserialize Binary Tree

// public class Codec {

//     // Encodes a tree to a single string.
//     public void makeserialize(TreeNode node,StringBuilder st){
//         if(node==null) {
//             st.append("#"+" ");
//             return ;
//         }
        
//         st.append(node.val+" ");

//         makeserialize(node.left,st);
//         makeserialize(node.right,st);

         
        
//     }
    
//     public String serialize(TreeNode root) {
//         StringBuilder st=new StringBuilder();
        
//         makeserialize(root,st);
//         System.out.print(st);
//         return st.toString();
        
//     }
//     public TreeNode findTree(String []arr,int []idx){
//         if(idx[0]>arr.length) return null;

//         if(arr[idx[0]]=='#'){
//             idx[0]++;
//             return null;
//         }

//         TreeNode  node=new TreeNode(Integer.parseInt(arr[idx[0]++]));
//         node.left=findTree(arr,idx)
//         node.right=findTree(arr,idx);

//         return node;
//     }
//     // Decodes your encoded data to tree.
//     public TreeNode deserialize(String st) {
//         if(st.length()==0) return null;

//         String arr[]=st.split(" ");
//         int idx[]=new int[1];
//         TreeNode node =findTree(arr,idx);
//         return null;
//     }
// }




// // geeks for geeks -> serialise deserislise 


// public class Codec {

//     // Encodes a tree to a single string.
//     public void makeSer(TreeNode node,String st){
//         LinkedList<TreeNode> list=new LinkedList<>();

//         list.add(node);
        
//         while(list.size()!=0){
//             int size=list.size();
//             while(size-->0){
//                 TreeNode rnode=list.removeFirst();
                
//                 if(rnode.val==-1001){
//                     st.append("#"+" ");
//                     continue;
//                 }
                
//                 st.append(node.val+" ");
//                 if(node.left!=null){
//                    list.addLast(node.left);
//                 }else{
//                    list.addLast(new TreeNode(-1001));
//                 }
                
//                 if(node.right!=null){
//                    list.addLast(node.right);
//                 }else{
//                    list.addLast(new TreeNode(-1001));
//                 }
                  

//             }
//         }
//     }
   

//     public String serialize(TreeNode root) {
//         StringBuilder st=new StringBuilder();

//         makeSer(root,st);

//         return st.toString();
        
//     }

//     // Decodes your encoded data to tree.
//     public TreeNode deserialize(String st) {

//         LinkedList<TreeNode> root=new LinkedList<>();
//         String []arr=st.split(" ");

//         TreeNode root=new TreeNode(Integer.parseInt(arr[0]));
//         list.add(root);
//         int i=1;

//         while(i<arr.length){   
//            TreeNode rnode = list.removeFirst();
            
//            if(rnode==null) continue;

//            if(i<n && arr[i]!='#'){
//              TreeNode node=new TreeNode(Integer.parseInt(arr[i]));
//              list.add(node);
//              rnode.left=node;
//            }
//             i++;
//            if(i<n && arr[i]!='#'){
//              TreeNode node=new TreeNode(Integer.parseInt(arr[i]));
//              list.add(node);
//              rnode.right=node;
//            }
//            i++
//         }

//         return root;
//     }
// }

// // populate next Right Pointer 

// class Solution {
//     public Node connect(Node root) {
        
//         Node black=root;

//         while(black!=null && black.left!=null){
//             Node temp=black;
//             while(temp!=null){
//                 if(temp.left!=null){
//                     temp.left.next=temp.right;
//                 }
//                 if(temp.next!=null){
//                     temp.right.next=temp.next.left;
//                 }
//                 temp=temp.next;
//             }

//             black=black.left;
//         }

//         return root;
//     }
// }


// // leetcode 951 flip Equivalent Binary Tree
// class Solution {
//     public boolean findflip(TreeNode root1,TreeNode root2){
//         if(root1==null || root2==null) return root2=root1;

//          // return if not same value 
//         if(root1.val!=root2.val) return false;

//         int flag=false;

//         // find if flip present 

//         if(root1.left!=null && root2.right!=null && root1.left.val==root2.right.val) flag==true;
//         if(root1.right!=null && root2.left!=null && root1.right.val==root2.left.val ) flag==true;


//         boolean left=findflip(root1.left, flag?root2.right:root2.left);
//         boolean right=findflip(root1.right,flag?root2.left:root2.right);

//         return left && right;       
//     }
//     public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        
//         boolean flag=findflip(root1,root2);

//         return flag;

//     }
// }

// // leetcode 971 Flip Binary Tree to Match Preorder Traversal

// class Solution {
//     public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
//         List<Integer> ans=new ArrayList<>();
//         Queue<Integer> que=new ArrayDeque<>();
//         for(int i:voyage){
//             que.offer(i);
//         }

//         boolean fag=  InvalidFlip(root,que,ans);
      
//        return ans;

//     }
//     public void flip(TreeNode node){
//         TreeNode tmp=node.left;
//         node.left=node.right;
//         node.right=tmp;
//     }
//     public boolean InvalidFlip(TreeNode node, Queue<Integer> que,List<Integer> ans){
//         if(node==null) return true;

//         if(node.val!=que.peek()) return false;
//         que.poll();

//         if(!InvalidFlip(node.left,que,ans)){
//             ans.add(node.val);
//             flip(node);
//             if(!InvalidFlip(node.left,que,ans)) return false;
//         }
//         if(!InvalidFlip(node.right,que,ans)){
//             ans.add(node.val);
//             flip(node);
//             if(!InvalidFlip(node.right,que,ans)) return false;
//         }


//         return true;
//     }
// }

// // Cousins in Binary Tree

// class Solution {
//     public boolean isCousins(TreeNode root, int x, int y) {
//         if(root.val==x && root.val==y) return false;

//         boolean xf=false;
//         boolean yf=false;

//         LinkedList<TreeNode> que=new LinkedList<>();
//         que.add(root);
        
//         while(que.size()!=0){
//             int size=que.size();

//             while(size-->0){
//                 TreeNode rnode=que.removeFirst();

//                 // check for siblings 

//                 if(rnode.left!=null && rnode.right!=null){
//                     if(rnode.left==x && rnode.right==y) return false;
//                 }

//                 // now check for found

//                 if(rnode.left!=null){
//                     xf= xf|| rnode.val=x;
//                     yf=yf || rnode.val=y;

//                     que.addLast(rnode.left);
//                 }

//                 if(rnode.right!=null){
//                     xf= xf|| rnode.val=x;
//                     yf=yf || rnode.val=y;

//                     que.addLast(rnode.right); 
//                 }
//             }

//             if(xf && xy) return true;
//             if(xf || xf) return false;
//         }

//         return false;

//     }
// }
// // univalued

// class Solution {
//     public int isUni(TreeNode node,boolean [] flag){
//         if(node==null) return -1;

//        int left=isUni(node.left,flag);
//        int right=isUni(node.right,flag);

//        if(left!=-1 && left!=node.val){
//         flag[0]=false;
        
//        }
//        if(right!=-1 && right!=node.val){
//         flag[0]=false;
        
//        }

//        return node.val;

//     }
//     public boolean isUnivalTree(TreeNode root) {
//         boolean flag[]=new boolean[1]{true};
//         boolean flag=isUni(root,flag);

//         return flag[0];
//     }
// }

// public class Tree_leetcode {
//     public static void main(String[] args) throws Exception {
//         System.out.println("Hello, World!");
//     }
// }

class Solution {
    public boolean find(TreeNode node){
        if(node.val==0) return false;
        if(node.val==1) return true;
    }
    public boolean helper(TreeNode node){
        if(node.left==null && node.right==null){
            if(node.val==0) return false;
            if(node.val==1) return true;
            // boolean lf=find(node.left);
            // boolean rt=find(node.right);
            


            // if(node==2) return (lt || rt);
            // if(node==3) return (lt && rt);
        }


        boolean left=helper(node.left);
        boolean right=helper(node.right);


        if(node.val==2) return (left || right);
        if(node.val==3) return (left && right);





    }
    public boolean evaluateTree(TreeNode root) {
        boolean flag=helper(root);

        return flag;
    }
}

// 2nd question 

class Solution {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);

        Set<Integer> set=new HashSet<>();

        for(int i=0;i<buses.length;i++){
            int c=0;

            while(j<passengers.length && passengers[j]<buses[i] && c<capacity){
                if(!set.contains(passengers[j]-1)){
                    ans=passengers[j]-1;
                }
                set.add(passengers[j]);
                j++;
                c++;
            }

            if(c<capacity && !set.contains(buses[i])){
                ans=buses[i];
            }
        }

        return ans;
    }
}




// 3rd question 
class Solution {
    public long minSumSquareDiff(int[] num1, int[] num2, int k1, int k2) {
        PriorityQueue<int[]> diff=new PiorityQueue<>((a,b)->{
            return b[0]-a[0];
        });

        for(int i=0;i<nums2.length;i++){
            diff.add(new int[]{Math.abs(num1[i]-num2[i])});
        }

        int k=k1+k2;
        int sumDiff=0;
        while(!diff.isEmpty()){
            int val=0;
            if(k-->0){
                val=diff.poll()-1;
            }else{
                val=diff.poll()
            }

            sumDiff+=val*val;
        }


        return sumDiff;


    }
}

// question 1 

class Solution {
    public int fillCups(int[] a) {
        if(a[0]==0 && a[1]==0 && a[2]==0) return 0;
        PriorityQueue<Integer> que=new PriorityQueue<>((a,b)->{
            return b-a;
        });

        que.add(a[0]);
        que.add(a[1]);
        que.add(a[2]);
          int ans=0;
        while(!que.isEmpty()){
            int mv1=que.poll();
            que.poll();
            if(que.isEmpty()) ans+=mv1;

            int mv2=que.poll();
            
           if(mv1!=0) que.add(mv1-1);
           if(mv2!=0) que.add(mv2-1);

            ans++;
        }

        ans+=que.poll();


        return ans;
    }
}

// 3rd question 

class Solution {
    public boolean canChange(String start, String target) {
        
    }
} 
