package com.gabriel.draw.view;

import com.gabriel.drawfx.ShapeMode;
import com.gabriel.drawfx.service.AppService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuBar extends JMenuBar implements ActionListener {
    private AppService appService;

    private JMenuItem lineMenu = new JMenuItem("Line");
    private JMenuItem rectMenu = new JMenuItem("Rectangle");
    private JMenuItem ellMenu = new JMenuItem("Ellipse");


    public MenuBar(AppService appService) {
        super();
        this.appService = appService;

        JMenu editMenu = new JMenu("Edit");
        add(editMenu);

        JMenu drawMenu = new JMenu("Shapes");
        editMenu.add(drawMenu);

        drawMenu.add(lineMenu);
        lineMenu.addActionListener(e -> appService.setShapeMode(ShapeMode.Line));

        drawMenu.add(rectMenu);
        rectMenu.addActionListener(e -> appService.setShapeMode(ShapeMode.Rectangle));

        drawMenu.add(ellMenu);
        ellMenu.addActionListener(e -> appService.setShapeMode(ShapeMode.Ellipse));


    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
