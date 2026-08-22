<h2><a href="https://www.geeksforgeeks.org/problems/operations-on-binary-min-heap/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=operations-on-binary-min-heap">Binary Heap Operations</a></h2><h3>Difficulty Level : Difficulty: Medium</h3><hr><div class="problems_problem_content__Xm_eO" style="--text-color: var(--problem-text-color);"><p><span style="font-size: 18px;">Given an initially empty Binary Min Heap and a list of queries. Process each query by performing the corresponding heap operation.</span></p>
<p><span style="font-size: 18px;">The queries are of the following types:</span></p>
<ul>
<li><span style="font-size: 18px;"><strong>[1, x]:</strong> Insert the value x into the Binary Min Heap.</span></li>
<li><span style="font-size: 18px;"><strong>[2, x]:</strong> Delete the element present at index x in the current Binary Min Heap. If the index is invalid, ignore the query.</span></li>
<li><span style="font-size: 18px;"><strong>[3]:</strong> Remove and return the minimum element from the Binary Min Heap. If the heap is empty, return -1.</span></li>
</ul>
<p><span style="font-size: 18px;">Implement the following methods:</span></p>
<ul>
<li><span style="font-size: 18px;"><strong>insertKey(x):</strong> Inserts x into the Binary Min Heap.</span></li>
<li><span style="font-size: 18px;"><strong>deleteKey(i):</strong> Deletes the element at index i from the Binary Min Heap.</span></li>
<li><span style="font-size: 18px;"><strong>extractMin():</strong>&nbsp;Removes and returns the minimum element from the Binary Min Heap, or -1 if the heap is empty.</span></li>
</ul>
<p><span style="font-size: 18px;">The driver code will invoke these methods according to the given queries.</span></p>
<p><span style="font-size: 18px;"><strong>Examples :</strong></span></p>
<pre><span style="font-size: 18px;"><strong>Input: </strong>queries[][] = [[1, 4], [1, 2], [3], [1, 6], [2, 0], [3], [3]]</span><span style="font-size: 18px;">
<strong>Output: </strong>[2, 6, -1]<strong>
Explanation:</strong>
- Initially, the Min Heap is empty.
- Insert 4. The heap contains 4.
- Insert 2. The heap is rearranged to satisfy the Min Heap property, with 2 at the root.
- Extract the minimum element. The value 2 is removed and printed.
- Insert 6. The heap contains 4 and 6.
- Delete the element at index 0. The value 4 is removed, leaving only 6 in the heap.
- Extract the minimum element. The value 6 is removed and printed.
- Extract the minimum element again. Since the heap is empty, -1 is returned.</span>
</pre>
<pre><span style="font-size: 18px;"><strong style="font-size: 18px;">Input: </strong><span style="font-size: 18px;">queries[][] = [[1, 8], [1, 9], [2, 1], [3], [3]]
</span><strong style="font-size: 18px;">Output: </strong><span style="font-size: 18px;">[8, -1]<br></span><strong style="font-size: 18px;">Explanation:<br></strong><span style="font-size: 18px;">- Initially, the Min Heap is empty.
- Insert 8. The heap contains 8.
- Insert 9. The heap contains 8 and 9.
- Delete the element at index 1. The value 9 is removed, leaving only 8 in the heap.
- Extract the minimum element. The value 8 is removed and printed.
- Extract the minimum element again. Since the heap is empty, -1 is returned.</span></span></pre>
</div><p><span style=font-size:18px><strong>Company Tags : </strong><br><code>Amazon</code>&nbsp;<code>Microsoft</code>&nbsp;<code>Samsung</code>&nbsp;<code>Ola Cabs</code>&nbsp;<code>Walmart</code>&nbsp;<code>Synopsys</code>&nbsp;<br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Heap</code>&nbsp;<code>Design-Pattern</code>&nbsp;