public class Tree {
    private Integer _root;
    private Tree[] _subtrees;

    public void __init__(int root, Tree[] subtrees) {
        this._root = root;
        if (subtrees != null) {
            this._subtrees = subtrees;
        } else {
            this._subtrees = new Tree[0];
        }
    }

    public boolean is_empty() {
        return this._root == null;
    }

    // ... rest of Tree implementation in java
}