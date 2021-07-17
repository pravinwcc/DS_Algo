package datastructure.treeset;

/** class TreeSet **/

class TreeSet

{

    private TreeSetNode root;

    private int size;

 

    /** constructor **/

    public TreeSet()

    {

        root = null;

        size = 0;

    }

 

    /** function to check if empty **/

    public boolean isEmpty()

    {

        return root == null;

    }

 

    /** function to clear **/

    public void clear()

    {

        root = null;

        size = 0;

    }

 

    /** function to insert an element **/

    public void add(String ele)

    {

        root = insert(root, ele);

    }

 

    /** function to insert an element **/

    private TreeSetNode insert(TreeSetNode r, String ele)

    {

        if (r == null)

            r = new TreeSetNode(ele, null, null);

        else

        {

            if (ele.compareTo(r.data) < 0)

                r.left = insert(r.left, ele);

            else if (ele.compareTo(r.data) > 0)

                r.right = insert(r.right, ele);

        }

        return r;

    }

 

    /** Functions to count number of nodes **/

    public int countNodes()

    {

        return countNodes(root);

    }

    /** Function to count number of nodes recursively **/

    private int countNodes(TreeSetNode r)

    {

        if (r == null)

            return 0;

        else

        {

            int l = 1;

            l += countNodes(r.left);

            l += countNodes(r.right);

            return l;

        }

    }

 

    /** Functions to search for an element **/

    public boolean contains(String ele)

    {

        return contains(root, ele);

    }

    /** Function to search for an element recursively **/

    private boolean contains(TreeSetNode r, String ele)

    {

        boolean found = false;

        while ((r != null) && !found)

        {

            if (ele.compareTo(r.data) < 0)

                r = r.left;

            else if (ele.compareTo(r.data) > 0)

                r = r.right;

            else

            {

                found = true;

                break;

            }

            found = contains(r, ele);

        }

        return found;

    }

 

    /** Function to delete data **/

    public void delete(String ele)

    {

        if (isEmpty())

            System.out.println("Tree Empty");

        else if (contains(ele) == false)

            System.out.println("Error : "+ ele +" is not present");

        else

        {

            root = delete(root, ele);

            System.out.println(ele +" deleted from the tree set");

        }

    }

    /** Function to delete element **/

    private TreeSetNode delete(TreeSetNode r, String ele)

    {

        TreeSetNode p, p2, n;

        if (r.data.equals(ele))

        {

            TreeSetNode lt, rt;

            lt = r.left;

            rt = r.right;

            if (lt == null && rt == null)

                return null;

            else if (lt == null)

            {

                p = rt;

                return p;

            }

            else if (rt == null)

            {

                p = lt;

                return p;

            }

            else

            {

                p2 = rt;

                p = rt;

                while (p.left != null)

                    p = p.left;

                p.left = lt;

                return p2;

            }

        }

        if (ele.compareTo(r.data) < 0)

        {

            n = delete(r.left, ele);

            r.left = n;

        }

        else

        {

            n = delete(r.right, ele);

            r.right = n;             

        }

        return r;

    }  

 

    /** function toString() **/

    public String toString()

    {

        return "[ "+ inorder(root, "") +"]";        

    }

    private String inorder(TreeSetNode r, String str)

    {

        if (r != null)

            return str + inorder(r.left, str) + r.data +" "+ inorder(r.right, str);

        else

            return "";

    }    

}
