package test;

public class Tree {
    public static void main(String[] params) {
        tree root =
                new tree(20,
                        new tree(7,
                                new tree(4, null, new tree(6)), new tree(9)),
                        new tree(35,
                                new tree(31, new tree(28), null),
                                new tree(40, new tree(38), new tree(52))));

        System.out.println("Сумма дерева: " + root.sum());
    }

    static class tree {
        int value;
        tree left;
        tree right;

        public tree(int value, tree left, tree right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public tree(int value) {
            this.value = value;
        }

        public int sum() {
            int summ = value;

            if (left != null) {
                summ += left.sum();
            }

            if (right != null) {
                summ += right.sum();
            }
            return summ;
        }
    }
}