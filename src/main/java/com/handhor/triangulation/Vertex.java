package com.handhor.triangulation;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Ігор on 24.11.16.
 */
public class Vertex implements Comparable<Vertex> {
    float x, y;
    boolean isFront, isBack;
    Set<Vertex> neig = new HashSet<>();

    public Vertex(float x, float y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Vertex o) {
        return ((x - o.x) > 0) ?  1:  -1;
    }

    public boolean isBetween(Vertex v1, Vertex v2) {
        float min = Math.min(v1.y, v2.y);
        float max = Math.max(v1.y, v2.y);
        return (min < y && y < max);
    }

    //used for sorting set by Y in descendant order
    public static Comparator<Vertex> yComparator = new Comparator<Vertex>() {
        @Override
        public int compare(Vertex o1, Vertex o2) {
            return ((o2.y - o1.y) > 0) ?  1:  -1;
        }
    };

    public static Comparator<Vertex> xComparator = new Comparator<Vertex>() {
        @Override
        public int compare(Vertex o1, Vertex o2) {
            return ((o1.x - o2.x) > 0) ?  1:  -1;
        }
    };
}
