class Node {
    String key;        // Keyword
    String value;      // Meaning
    Node left, right;  // Pointers to left and right children

    public Node(String key, String value) {
        this.key = key;
        this.value = value;
        this.left = null;
        this.right = null;
    }
}
