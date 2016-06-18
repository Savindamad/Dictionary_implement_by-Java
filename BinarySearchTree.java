public class BinarySearchTree {
	public writeDic writedic;
	public static  Node root;
	public BinarySearchTree(){
		this.root = null;
	}
	
	public String findDef(double id){
		Node current = root;
		while(current!=null){
			if(current.data==id){
				return (current.definition);
			}else if(current.data>id){
				current = current.left;
			}else{
				current = current.right;
			}
		}
		return "null";
	}
		public String[] findSimilar(double id){
			Node current = root;
			while(current!=null){
				if(current.data==id){
					return (current.similar);
				}
				else if(current.data>id){
					current = current.left;
			}
				else{
					current = current.right;
				}
			}
			return null;
		}

	public boolean delete(double id){
		Node parent = root;
		Node current = root;
		boolean isLeftChild = false;
		while(current.data!=id){
			parent = current;
			if(current.data>id){
				isLeftChild = true;
				current = current.left;
			}else{
				isLeftChild = false;
				current = current.right;
			}
			if(current ==null){
				return false;
			}
		}

		if(current.left==null && current.right==null){
			if(current==root){
				root = null;
			}
			if(isLeftChild ==true){
				parent.left = null;
			}
			else{
				parent.right = null;
			}
		}
		//Case 2 : if node to be deleted has only one child
		else if(current.right==null){
			if(current==root){
				root = current.left;
			}
			else if(isLeftChild){
				parent.left = current.left;
			}
			else{
				parent.right = current.left;
			}
		}
		else if(current.left==null){
			if(current==root){
				root = current.right;
			}else if(isLeftChild){
				parent.left = current.right;
			}else{
				parent.right = current.right;
			}
		}
		else if(current.left!=null && current.right!=null){
			
			//now we have found the minimum element in the right sub tree
			Node successor	 = getSuccessor(current);
			if(current==root){
				root = successor;
			}
			else if(isLeftChild){
				parent.left = successor;
			}
			else{
				parent.right = successor;
			}			
			successor.left = current.left;
		}		
		return true;		
	}
	
	public Node getSuccessor(Node deleleNode){
		Node successsor =null;
		Node successsorParent =null;
		Node current = deleleNode.right;
		while(current!=null){
			successsorParent = successsor;
			successsor = current;
			current = current.left;
		}
		if(successsor!=deleleNode.right){
			successsorParent.left = successsor.right;
			successsor.right = deleleNode.right;
		}
		return successsor;
	}
	public boolean insert(double id,String name, String def, String similar[], int arrysize){
		Node newNode = new Node(id,name,def,similar,arrysize);
		if(root==null){
			root = newNode;
			return true;
		}
		Node current = root;
		Node parent = null;
		while(true){
			parent = current;
			if(id<current.data){				
				current = current.left;
				if(current==null){
					parent.left = newNode;
					return true;
				}
			}
			else if(id>current.data){
				current = current.right;
				if(current==null){
					parent.right = newNode;
					return true;
				}
			}
			else{
				return false;
			}
		}
	}
	public void writeData(){
		writedic = new writeDic("input.txt");
		preorder(writedic,root);
		writedic.closeFile();
	}
	public static void preorder(writeDic writedic, Node rt) {  
    	if(rt !=  null) {
    		String simMean = "";
    		for(int i = 0; i<rt.size; i++){
    			simMean += rt.similar[i]+" "; 
    		}
			String line = rt.name + "," + rt.definition + "," + simMean;
			writedic.writedata(line);
			preorder(writedic, rt.left);  
			preorder(writedic, rt.right);  
    	}  
  	}
}

class Node{
	double data;
	String name;
	String definition;
	String similar[];
	int size;
	Node left;
	Node right;	
	public Node(double hashValue,String name,String definition, String similar[],int size){
		
		this.similar =  new String[size];
		this.size = size;
		this.data = hashValue;
		this.name = name;
		this.definition = definition;
		this.similar = similar;

		left = null;
		right = null;
	}
}