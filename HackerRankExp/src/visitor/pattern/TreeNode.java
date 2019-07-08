package visitor.pattern;

import java.util.ArrayList;

public class TreeNode  extends Tree{

	private ArrayList<Tree> children= new ArrayList<Tree>();
	public TreeNode(int value, Color color, int depth) {
		
		super(value, color, depth);
		// TODO Auto-generated constructor stub
	}
   
	public void accept(TreeVis visitor) {
		visitor.visiNode(this);
		for (Tree child:children) {
			child.accept(visitor);
		}
	}
	
	public void addChild(Tree child) {
		children.add(child);
		System.out.println("t1");
		}
}
