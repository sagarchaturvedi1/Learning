    def levelOrder_iter(self,root):
  	     #Write your code here
        res = []
        if root is None:
            return
        else:
            #print(myTree.height(root))
            values = []
            values.append(root)
            while len(values) > 0:
                nod = values.pop(0)
                res.append(str(nod.data))
                if nod.left is not None:
                    values.append(nod.left)
                if nod.right is not None:
                    values.append(nod.right)

        #print(res)            
        print(" ".join(res))

    def levelOrder(self,root):
        h = myTree.height(root)
        print(h)
        for level in range(1,h+1):
            myTree.bfs(root, level)

    def bfs(self,root, level):
        if root is None:
            return
        if level==1:
            print(root.data)
        if level > 1:
            myTree.bfs(root.left, level-1)
            myTree.bfs(root.right, level-1)

    def height(self,root):
        if root is None:
            return 0
        return 1+max(myTree.height(root.left),myTree.height(root.right))
