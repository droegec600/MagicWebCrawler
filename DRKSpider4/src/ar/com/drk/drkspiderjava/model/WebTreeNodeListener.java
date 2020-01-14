package ar.com.drk.drkspiderjava.model;

public interface WebTreeNodeListener {

	public void nodeAdded(WebTreeNode source, Object[] path, 
			int[] childIndices, 
			WebTreeNode[] children);
}
