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

    public DrawingFrame(AppService appService) {
        this.appService = appService;
        this.drawingView = new DrawingView(appService);
    }

    public DrawingView getDrawingView() {
        return drawingView;
    }
}
