package com.educational.testing;

public class SegmentTree {
    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4,5,6};
        int[] tree = new int[24];
        buildTree(tree, 1, 0,5, a);
        for(int i=0;i<24;i++){
           // System.out.println(tree[i]);
        }
        System.out.println(query(tree, 1, 0, 5, 3, 4));
    }

    private static void buildTree(int[] tree, int tindex, int start, int end, int[] a) {
        if(start == end){
            tree[tindex] = a[start];
        }else {
            int mid = (start+end)/2;
            buildTree(tree, 2*tindex, start, mid, a);
            buildTree(tree, 2*tindex+1, mid+1, end, a);
            tree[tindex] = tree[2*tindex]+tree[2*tindex+1];
        }
    }

    private static int query(int[] tree, int tIndex, int ns, int ne, int qs, int qe){
        // No overlap
        if(qe<ns || qs>ne){
          return 0;
        }

        // complete overrlap
        if(ns>=qs && ne<=qe){
            return tree[tIndex];
        }

        // partial overlap
        int mid = (ns+ne)/2;
        int left = query(tree, 2*tIndex, ns, mid, qs, qe);
        int right = query(tree, 2*tIndex+1, mid+1, ne, qs, qe);
        return left+right;

    }

}
