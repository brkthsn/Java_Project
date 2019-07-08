package visitor.pattern;

class SumInLeavesVisitor extends TreeVis {
    private int result = 0;

    public int getResult() {
        return result;
    }

    public void visitNode(TreeNode node) {
        // do nothing
    }

    public void visitLeaf(TreeLeaf leaf) {
        result += leaf.getValue();
    }

	@Override
	public void visiNode(TreeNode node) {
		// TODO Auto-generated method stub
		
	}
}