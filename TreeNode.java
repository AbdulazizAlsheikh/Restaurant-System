



class TreeNode {
    int id;
    String name;
    LinkedList<TreeNode> children;
    LinkedList<Item> items;

    public TreeNode(int id, String name) {
        this.id = id;
        this.name = name;
        children = new LinkedList<>();
        items = new LinkedList<>();
    }
}
