class DictionaryBST {
    private Node root;

    public DictionaryBST() {
        this.root = null;
    }

    // Insert a new keyword and meaning into the BST
    public void insert(String key, String value) {
        root = insertRecursive(root, key, value);
    }

    private Node insertRecursive(Node node, String key, String value) {
        if (node == null) {
            return new Node(key, value);
        }
        if (key.compareTo(node.key) < 0) {
            node.left = insertRecursive(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = insertRecursive(node.right, key, value);
        } else {
            // If the keyword already exists, update its meaning
            node.value = value;
        }
        return node;
    }

    // Search for a keyword in the BST
    public Node search(String key) {
        return searchRecursive(root, key);
    }

    private Node searchRecursive(Node node, String key) {
        if (node == null || node.key.equals(key)) {
            return node;
        }
        if (key.compareTo(node.key) < 0) {
            return searchRecursive(node.left, key);
        } else {
            return searchRecursive(node.right, key);
        }
    }

    // Update the meaning of an existing keyword
    public void update(String key, String newValue) {
        Node node = search(key);
        if (node != null) {
            node.value = newValue;
        } else {
            System.out.println("Keyword '" + key + "' not found.");
        }
    }

    // Display all keywords in ascending order
    public void displayAscending() {
        System.out.println("Dictionary in Ascending Order:");
        inorderTraversal(root);
    }

    private void inorderTraversal(Node node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.println(node.key + ": " + node.value);
            inorderTraversal(node.right);
        }
    }

    // Display all keywords in descending order
    public void displayDescending() {
        System.out.println("Dictionary in Descending Order:");
        descendingTraversal(root);
    }

    private void descendingTraversal(Node node) {
        if (node != null) {
            descendingTraversal(node.right);
            System.out.println(node.key + ": " + node.value);
            descendingTraversal(node.left);
        }
    }

    // Delete a keyword from the BST
    public void delete(String key) {
        root = deleteRecursive(root, key);
    }

    private Node deleteRecursive(Node node, String key) {
        if (node == null) {
            return node;
        }
        if (key.compareTo(node.key) < 0) {
            node.left = deleteRecursive(node.left, key);
        } else if (key.compareTo(node.key) > 0) {
            node.right = deleteRecursive(node.right, key);
        } else {
            // Node with one or no child
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;

            // Node with two children: find the inorder successor (smallest in the right subtree)
            Node successor = minValueNode(node.right);
            node.key = successor.key;
            node.value = successor.value;
            node.right = deleteRecursive(node.right, successor.key);
        }
        return node;
    }

    private Node minValueNode(Node node) {
        Node current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }
}
