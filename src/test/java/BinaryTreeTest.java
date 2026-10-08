import datastructures.BinaryTree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BinaryTreeTest {

    BinaryTree<Integer, Integer> emptyBinaryTree = new BinaryTree<>(null);
    BinaryTree<Integer, Integer> binaryTree = new BinaryTree<>(null);


    @BeforeEach
    void InitTree() {
        binaryTree.insert(50, 50);
        binaryTree.insert(30, 30);
        binaryTree.insert(70, 70);
        binaryTree.insert(20, 20);
        binaryTree.insert(40, 40);
        binaryTree.insert(60, 60);
        binaryTree.insert(80, 80);
        binaryTree.insert(35, 35);
        binaryTree.insert(85, 85);
    }

    @Test
    void deleteNodeFromEmptyTreeTest() {
        Assertions.assertFalse(emptyBinaryTree.delete(0));
    }

    @Test
    void deleteSoloNodeTest() {
        emptyBinaryTree.insert(9, 9);

        Assertions.assertTrue(emptyBinaryTree.delete(9));
        Assertions.assertTrue(emptyBinaryTree.inOrderIterative().isEmpty());
        Assertions.assertEquals(0, emptyBinaryTree.getSize());
    }

    @Test
    void deleteNotExistNodeTest() {
        emptyBinaryTree.insert(9, 9);

        Assertions.assertFalse(emptyBinaryTree.delete(10));
        Assertions.assertFalse(emptyBinaryTree.inOrderIterative().isEmpty());
        Assertions.assertEquals(1, emptyBinaryTree.getSize());
        Assertions.assertTrue(emptyBinaryTree.inOrderIterative().contains(9));
    }

    @Test
    void deleteLeafNodeTest() {
        Assertions.assertTrue(binaryTree.delete(35));
        List<Integer> actualAllNodes = binaryTree.inOrderIterative();
        Assertions.assertFalse(actualAllNodes.contains(35));
        Assertions.assertEquals(8, binaryTree.getSize());
        Assertions.assertTrue(actualAllNodes.containsAll(List.of(50, 30, 70, 20, 85, 60, 80, 40)));
    }

    @Test
    void deleteNodeWithLeftChildrenTest() {
        Assertions.assertTrue(binaryTree.delete(40));
        List<Integer> actualAllNodes = binaryTree.inOrderIterative();
        Assertions.assertFalse(actualAllNodes.contains(40));
        Assertions.assertEquals(8, binaryTree.getSize());
        Assertions.assertTrue(actualAllNodes.containsAll(List.of(50, 30, 70, 20, 85, 60, 80, 35)));
    }

    @Test
    void deleteNodeWithRightChildrenTest() {
        Assertions.assertTrue(binaryTree.delete(80));
        List<Integer> actualAllNodes = binaryTree.inOrderIterative();
        Assertions.assertFalse(actualAllNodes.contains(80));
        Assertions.assertEquals(8, binaryTree.getSize());
        Assertions.assertTrue(actualAllNodes.containsAll(List.of(50, 30, 70, 20, 85, 60, 40, 35)));
    }

    @Test
    void deleteNodeWithTwoChildrenTest(){
        Assertions.assertTrue(binaryTree.delete(30));
        List<Integer> actualAllNodes = binaryTree.inOrderIterative();
        Assertions.assertFalse(actualAllNodes.contains(30));
        Assertions.assertEquals(8, binaryTree.getSize());
        Assertions.assertTrue(actualAllNodes.containsAll(List.of(50, 70, 20, 40, 60, 80, 35,85)));
    }

    @Test
    void deleteNodeWithTwoChildrenSuccessorRightChildTest(){
        Assertions.assertTrue(binaryTree.delete(70));
        List<Integer> actualAllNodes = binaryTree.inOrderIterative();
        Assertions.assertFalse(actualAllNodes.contains(70));
        Assertions.assertEquals(8, binaryTree.getSize());
        Assertions.assertTrue(actualAllNodes.containsAll(List.of(50,30, 20, 40, 60, 80, 35,85)));
    }

    @Test
    void deleteRootTwoChildren (){
        Assertions.assertTrue(binaryTree.delete(50));
        List<Integer> actualAllNodes = binaryTree.inOrderIterative();
        Assertions.assertFalse(actualAllNodes.contains(50));
        Assertions.assertEquals(8, binaryTree.getSize());
        Assertions.assertTrue(actualAllNodes.containsAll(List.of(70,30, 20, 40, 60, 80, 35,85)));
    }

    @Test
    void deleteNull(){
        Assertions.assertThrows(NullPointerException.class, () -> binaryTree.delete(null));
    }


}
