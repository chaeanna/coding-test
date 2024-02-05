import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {
    String data;
    Node lt, rt;

    public Node(String val) {
        this.data = val;
    }
}

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        Tree tree = new Tree();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String p = st.nextToken();
            String lc = st.nextToken();
            String rc = st.nextToken();

            tree.createNode(p, lc, rc);
        }

        tree.preOrder(tree.root);
        System.out.println();
        tree.inOrder(tree.root);
        System.out.println();
        tree.postOrder(tree.root);

    }
}

class Tree {
    Node root = new Node(".");
    public void createNode(String p, String lc, String rc) {
        if (root.data.equals(".")) {
            if (!p.equals(".")) {
                root = new Node(p);
            }
            if (!lc.equals(".")) {
                root.lt = new Node(lc);
            }
            if (!rc.equals(".")) {
                root.rt = new Node(rc);
            }
        } else {
            // 존재할 경우
            searchNode(root, p, lc, rc);
        }
    }

    public void searchNode(Node node, String p, String lc, String rc) {
        if (node == null) {
            return;
        } else if (p.equals(node.data)) {
            // 노드를 찾을 경우
            if (!lc.equals(".")) {
                node.lt = new Node(lc);
            }
            if (!rc.equals(".")) {
                node.rt = new Node(rc);
            }
        }

        // 자식 노드 알아보기
        searchNode(node.lt, p, lc, rc);
        searchNode(node.rt, p, lc, rc);
    }

    public void preOrder(Node node) {
        // 자식이 하나뿐인 노드도 있을 수 있음.
        System.out.print(node.data);
        if (node.lt != null) {
            preOrder(node.lt);
        }
        if (node.rt != null) {
            preOrder(node.rt);
        }

    }

    public void inOrder(Node node) {
        // 자식이 하나뿐인 노드도 있을 수 있음.
        if (node.lt != null) {
            inOrder(node.lt);
        }
        System.out.print(node.data);
        if (node.rt != null) {
            inOrder(node.rt);
        }
    }

    public void postOrder(Node node) {
        // 자식이 하나뿐인 노드도 있을 수 있음.
        if (node.lt != null) {
            postOrder(node.lt);
        }
        if (node.rt != null) {
            postOrder(node.rt);
        }
        System.out.print(node.data);
    }

}