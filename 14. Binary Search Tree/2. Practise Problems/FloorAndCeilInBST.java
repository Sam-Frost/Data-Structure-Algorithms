
import java.util.List;

public class FloorAndCeilInBST {

    public List<Integer> floorCeilOfBST(TreeNode root, int key) {
        int floor = -1;
        int ceil = -1;

        while (root != null) {

            if (root.data < key) {
                floor = root.data;
                root = root.right;
            } else if (root.data > key) {
                ceil = root.data;
                root = root.left;
            } else {
                return List.of(key, key);
            }
        }

        return List.of(floor, ceil);
    }
}
