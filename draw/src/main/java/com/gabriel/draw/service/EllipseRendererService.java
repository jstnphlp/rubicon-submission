package com.gabriel.draw.service;

import com.gabriel.drawfx.model.Shape;
import com.gabriel.drawfx.service.RendererService;
import java.awt.*;

public class EllipseRendererService implements RendererService {
    @Override
    public void render(Graphics g, Shape shape, boolean xor) {
        if (xor) {
            g.setXORMode(Color.white);
        }
        g.setColor(shape.getColor());

        Point start = shape.getLocation();
        Point end = shape.getEnd();

        int x = Math.min(start.x, end.x);
        int y = Math.min(start.y, end.y);
        int width = Math.abs(start.x - end.x);
        int height = Math.abs(start.y - end.y);

        g.drawOval(x, y, width, height);

        if (xor) {
            g.setPaintMode();
        }
    }
}