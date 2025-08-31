package com.gabriel.draw.view;

import com.gabriel.draw.controller.DrawingWindowController;
import com.gabriel.drawfx.ShapeMode;
import com.gabriel.drawfx.model.Drawing;
import com.gabriel.drawfx.service.AppService;

import javax.swing.*;
import java.awt.*;

public class DrawingFrame extends JFrame {
    private final AppService appService;
    private final DrawingView drawingView;
    private JToolBar toolBar; // store reference so it won’t duplicate

    public DrawingFrame(AppService appService) {
        this.appService = appService;
        this.drawingView = new DrawingView(appService);

        initUI();
    }

    private void initUI() {
        setTitle("Drawing App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // ✅ Create toolbar only once
        if (toolBar == null) {
            toolBar = new JToolBar();
            JButton lineButton = new JButton("Line");
            lineButton.addActionListener(e -> appService.setShapeMode(ShapeMode.Line));

            JButton rectButton = new JButton("Rectangle");
            rectButton.addActionListener(e -> appService.setShapeMode(ShapeMode.Rectangle));

            JButton ellButton = new JButton("Circle");
            ellButton.addActionListener(e -> appService.setShapeMode(ShapeMode.Ellipse));

            toolBar.add(lineButton);
            toolBar.add(rectButton);
            toolBar.add(ellButton);

            add(toolBar, BorderLayout.NORTH);
        }

        // ✅ Ensure DrawingView is only added once
        getContentPane().add(drawingView, BorderLayout.CENTER);

        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public DrawingView getDrawingView() {
        return drawingView;
    }
}
