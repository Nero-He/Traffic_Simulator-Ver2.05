//Window and Panel
import Panel.SimulationPanel;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;


public class Main {

        private static final int Window_Width = 1920;
        private static final int Window_height = 1080;
        private static SimulationPanel simulationPanel = new SimulationPanel();
       // private static EditorPanel editorPanel = new EditorPanel();
        private static final int scale = 8;

    public static void main(String[] args) {
        JFrame mainWindow = new JFrame("Traffic simulator");
        mainWindow.setLayout(new BorderLayout());
        mainWindow.setSize(Window_Width, Window_height);

        //Status
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(2, 0));
        bottomPanel.setBorder(BorderFactory.createLoweredBevelBorder());
        JLabel modeLabel = new JLabel(" Mode: ");
        bottomPanel.add(modeLabel);

        JLabel statusLabel = new JLabel("Status: ");
        bottomPanel.add(statusLabel);
        mainWindow.add(bottomPanel, BorderLayout.SOUTH);

        //Menu
        JMenuBar menuBar = new JMenuBar();
        mainWindow.add(menuBar, BorderLayout.NORTH);

        //Edit
        JMenu editMenu = new JMenu("Editor");
        MenuListener cityListen = new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                @Override
                public void menuSelected (MenuEvent e){
                    modeLabel.setText("Edit Mode");
                    mainWindow.repaint();
                }
            }

            @Override
            public void menuDeselected(MenuEvent e) {

            }

            @Override
            public void menuCanceled(MenuEvent e) {


            }
        };
        editMenu.addMenuListener(cityListen);
        menuBar.add(editMenu);

        JMenuItem newMapItem = new JMenuItem("New!");
        // newMapItem.addActionListener(e ->{})
        editMenu.add(newMapItem);

        JMenuItem openMapItem = new JMenuItem("Open");
        openMapItem.addActionListener(e -> {
        });
        editMenu.add(openMapItem);

        JMenuItem exitButtonItem = new JMenuItem("Exit");
        exitButtonItem.addActionListener(e -> System.exit(0));
        editMenu.add(exitButtonItem);

        JMenu simulatorMenu = new JMenu("Simulation");
        MenuListener simListener = new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                modeLabel.setText("Mode: Simulation");
                mainWindow.repaint();
            }

            @Override
            public void menuDeselected(MenuEvent e) {

            }

            @Override
            public void menuCanceled(MenuEvent e) {

            }
        };
        simulatorMenu.addMenuListener(simListener);


        JMenuItem loadSimItem = new JMenuItem("Load Map");
        simulatorMenu.add(loadSimItem);

        JMenuItem SpawnItem = new JMenuItem("Add New Vehicles");
        SpawnItem.setEnabled(false);
        simulatorMenu.add(SpawnItem);

        JMenuItem StartSimulation = new JMenuItem("Start");
        StartSimulation.setEnabled(false);
        StartSimulation.addActionListener(e -> {
            simulationPanel.simulate();
            statusLabel.setText("Status: Simulation Started");
            simulationPanel.setStopSim(false);
            mainWindow.validate();
            mainWindow.repaint();
        });
        simulatorMenu.add(StartSimulation);
    }







}

