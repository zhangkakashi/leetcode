package clone.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;

	UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}
};

public class ColoneGraph {
	Map<UndirectedGraphNode, UndirectedGraphNode> m = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null) {
			return null;
		}

		UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
		m.put(node, newNode);
		List<UndirectedGraphNode> l = node.neighbors;
		for (int i = 0; i < l.size(); i++) {
			if (m.containsKey(l.get(i))) {
				newNode.neighbors.add(m.get(l.get(i)));
			} else {
				newNode.neighbors.add(cloneGraph(l.get(i)));
			}
		}

		return newNode;

	}
}
