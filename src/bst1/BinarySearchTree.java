package bst1;

public class BinarySearchTree<T extends Comparable<T>>
{
    private Node<T> root;

    public BinarySearchTree() { }

    public void insert(T data)
    {
        Node<T>[] nodes = traverseTo(data);

        if (nodes[1] != null) return;

        Node<T> newNode = new Node<T>(data);

        if (nodes[0] == null) { root = newNode; return; }

        if   (nodes[0].data().greaterThan(data)) nodes[0].setLeft (newNode); 
        else                                     nodes[0].setRight(newNode);
    }

    public void remove(T data)
    {
        Node<T>[] nodes = traverseTo(data);

        if (nodes[1] == null) return;

        if (nodes[0] == null) 
        {
            if (root.isLeaf())        { root = null;         return; }
            if (root.left () == null) { root = root.right(); return; }
            if (root.right() == null) { root = root.left (); return; }

            Node<T>[] minimum = traverseToMinimum(root.left());

            root.setData(minimum[1].data());

            minimum[0].setLeft(minimum[1].right());

            return;
        }

        if (nodes[1].left() != null && nodes[1].right() != null)
        {
            Node<T>[] minimum = traverseToMinimum(nodes[1].left());

            nodes[1].setData(minimum[1].data());

            minimum[0].setLeft(minimum[1].right()); 

            return;
        }

        Node<T> newChild = null;

        if      (nodes[1].isLeaf())        newChild = null;
        else if (nodes[1].left () == null) newChild = nodes[1].right();
        else if (nodes[1].right() == null) newChild = nodes[1].left ();

        if   (nodes[0].data().greaterThan(nodes[1].data())) nodes[0].setLeft (newChild);
        else                                                nodes[0].setRight(newChild);
    }

    public T search(T data)
    {
        Node<T>[] nodes = traverseTo(data);

        return nodes[1] == null ? null : nodes[1].data();
    }

    public String toString()
    {
        return root == null ? "" : root.toString();
    }

    private Node<T>[] traverseTo(T data)
    {
        @SuppressWarnings("unchecked")
        Node<T>[] result = new Node[] { null, root };
        
        while (result[1] != null)
        {
            result[0] = result[1];

            if (result[1].data().equals(data)) break;

            result[1] = result[1].data().greaterThan(data) ? result[1].left() : 
                                                             result[1].right();
        }

        return result;
    }

    @SuppressWarnings("unchecked")
    private Node<T>[] traverseToMinimum(Node<T> data)
    {
        Node<T> previous = null;
        Node<T> current = data;

        while (current.left() != null)
        {
            previous = current;

            current = current.left();
        }

        return new Node[] { previous, current };
    }
}
