package com.zondy.spark.leetcode.Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    private int v;//图中的节点数
    private LinkedList<Integer>[] adj;
    public Graph(int v) {
        this.v = v;
        this.adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }
    public void addEdge(int s,int t){
        adj[s].add(t);
        adj[t].add(s);
    }
    public void print(int[] prev,int s,int t){
        if (prev[t]!=-1&&t!=s){
            print(prev,s,prev[t]);
        }
        System.out.println(t+" ");
    }
    //广度优先
    public void bfs(int s, int t) {
        //queue用来存储已经访问过的但是其相邻接点还没被访问的节点
        Queue<Integer> queue = new LinkedList<Integer>();
        //用来存储已近被访问过的节点
        boolean[] visited = new boolean[this.v];
        //用来存储前一个节点
        int[] pre = new int[this.v];
        visited[s] = true;
        queue.add(s);
        Arrays.fill(pre, -1);
        while (!queue.isEmpty()){
            //将队首元素出队，并获得该元素
            Integer poll = queue.poll();
            //当前队列中第一个元素的相邻元素集合
            LinkedList<Integer> integers = this.adj[poll];
            for (int i = 0; i < integers.size(); i++) {
                //如果该元素被访问过了则不作任何处理
                if (visited[integers.get(i)]) continue;
                //未被访问过则保存该元素前一个节点的信息
                pre[integers.get(i)] = poll;
                //如果该元素等于终止元素则打印，结束方法
                if (integers.get(i)==t){
                    print(pre,s,t);
                    return;
                }
                //该元素未被访问过且不为终止元素则标记为已访问且将该元素入栈
                visited[integers.get(i)] = true;
                queue.offer(integers.get(i));
            }
        }
    }

boolean found = false; // 全局变量或者类成员变量
    public void dfs(int s, int t) {
        found = false;
        int[] pre = new int[v];
        boolean[] visited = new boolean[v];
        Arrays.fill(pre,-1);
        reDFS(pre,visited,s,t);
        print(pre,s,t);

    }
    public void reDFS(int[] pre,boolean[] visited,int s, int t){
        //不加found的话找到了结果还会继续循环，因为return只能返回一层递归
        if (found==true)return;
        visited[s] = true;
        LinkedList<Integer> integers = adj[s];
        for (int i = 0; i < adj[s].size(); i++) {
            if (!visited[integers.get(i)]){
                pre[integers.get(i)] = s;
                if (integers.get(i)==t){
                    found = true;
                    return;
                }
                reDFS(pre,visited,integers.get(i),t);
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(8);
        graph.addEdge(0,1);
        graph.addEdge(0,3);
        graph.addEdge(1,2);
        graph.addEdge(1,4);
        graph.addEdge(2,5);
        graph.addEdge(4,5);
        graph.addEdge(4,6);
        graph.addEdge(5,7);
        graph.addEdge(6,7);
//        graph.bfs(0,6);

        // 广度优先
        graph.dfs(0, 6);

    }
}
