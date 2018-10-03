package com.handhor.triangulation;

/**
 * Created by Ігор on 01.12.16.
 */
public class Vector {
    float x, y;

    public Vector (Vertex start, Vertex end) {
        x = end.x - start.x;
        y = end.y - start.y;
    }

    public Vector (float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float scalarProduct(Vector o) {
        return (x * o.x + y * o.y) / (module() * o.module());
    }

    public float module() {
        return (float)Math.sqrt(x * x + y * y);
    }
}
