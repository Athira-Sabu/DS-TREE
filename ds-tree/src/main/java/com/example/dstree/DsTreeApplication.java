package com.example.dstree;

import com.example.dstree.bst.BST;
import com.example.dstree.bst.Node;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

//@SpringBootApplication
public class DsTreeApplication {

	public static void main(String[] args) {

		//SpringApplication.run(DsTreeApplication.class, args);
		Node rootNode = null;
		BST bst = new BST();

		List<Integer> integers = Arrays.asList(8, 3, 1, 6, 4, 7, 8, 10, 14, 13);
		for (Integer val: integers) {
			rootNode = bst.insertElement(rootNode, val);
		}
		System.out.println("rootnode   "+ rootNode);

		rootNode = bst.delete(rootNode, 14);
		System.out.println("rootnode   "+ rootNode);
	}

}
