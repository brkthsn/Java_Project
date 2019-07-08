package visitor.pattern;

abstract class TreeVis {

	public abstract int getResult();
	public abstract void visiNode(TreeNode node);
	public abstract void visitLeaf(TreeLeaf leaf);
}
