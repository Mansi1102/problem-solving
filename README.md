# problem-solving
A collection of Java implementations for classic data structures and algorithms, organized by topic. Useful for interview prep and practice.

# Graph

## ⚔️ BFS vs DFS (Quick Comparison)

| Aspect | BFS | DFS |
|--------|-----|-----|
| Traversal | Level by level | Depth first |
| Data structure | Queue | Stack / Recursion |
| Shortest path | ✅ Yes (unweighted) | ❌ No |
| Memory | High | Low |
| Backtracking | ❌ | ✅ |
| Cycle detection | ✅ | ✅ |

## 🧠 Interview Decision Rule (Very Important)

| Question Type | Algorithm |
|---------------|-----------|
| "minimum / shortest / nearest" | BFS |
| "all paths / detect cycle / dependency" | DFS |