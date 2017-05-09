package BG.UI;

import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.*;
import java.io.File;
import java.util.*;
import BG.FileManagers.*;

public class ClassRunnerApplet extends JFrame implements ActionListener
{

  //UI Elements
  JPanel mainPanel;

  JButton browseButton;
  JLabel browseDirectory;
  JScrollPane optionsScrollPane;
  DefaultListModel<String> optionsModel;
  JList optionsList;
  JButton runButton;

  JScrollPane outputScollPane;
  DefaultListModel<String> outputModel;
  JList outputList;
  JButton saveButton;

  public ClassRunnerApplet()
  {
    setup(1000,500);
  }
  private void setup(int width, int height)
  {

    //Containers
    mainPanel = new JPanel(new GridBagLayout());
    mainPanel.setPreferredSize(new Dimension(width, height));

    //Constraints

    GridBagConstraints c = new GridBagConstraints();
    c.fill = GridBagConstraints.HORIZONTAL;
    //Elements
    browseDirectory = new JLabel("Empty:");
    browseDirectory.setBackground(Color.WHITE);
    c.gridx = 0;
    c.gridy = 0;
    c.gridwidth = 2;
    c.weightx = 0.5;
    c.weighty = 0.5;
    c.insets = new Insets(5,0,0,5);
    mainPanel.add(browseDirectory,c);
    browseButton = new JButton("Browse");
    browseButton.setActionCommand("browse");
    c.gridx = 2;
    c.gridwidth = 1;
    c.weightx = 0.1;
    c.weighty = 0.5;
    mainPanel.add(browseButton,c);

    optionsModel = new DefaultListModel();
    optionsList = new JList(optionsModel);
    //optionsList.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    optionsList.setVisibleRowCount(25);
    optionsScrollPane = new JScrollPane(optionsList);
    c.gridx = 0;
    c.gridy = 1;
    c.gridwidth = 3;
    c.gridheight = 3;
    c.weightx = 0.9;
    c.weighty = 1;
    mainPanel.add(optionsScrollPane,c);

    runButton = new JButton("Run");
    runButton.setActionCommand("run");
    c.gridx = 2;
    c.gridy = 4;
    c.gridwidth = 1;
    c.gridheight = 1;
    c.weightx = 0.1;
    c.weighty = 0.5;
    mainPanel.add(runButton,c);

    outputModel = new DefaultListModel();
    outputList = new JList(outputModel);
    outputList.setVisibleRowCount(25);
    outputScollPane = new JScrollPane(outputList);
    //outputList.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    c.gridx = 3;
    c.gridy = 1;
    c.gridheight = 3;
    c.gridwidth = 3;
    c.weightx = 1;
    c.weighty = 1;
    mainPanel.add(outputScollPane,c);
    //CreateGlue
    c.gridy = 4;
    c.gridwidth = 2;
    c.gridheight = 1;
    c.weightx = 0.5;
    c.weighty = 0.5;
    mainPanel.add(Box.createGlue(),c);

    saveButton = new JButton("Save");
    saveButton.setActionCommand("save");
    c.gridx = 5;
    c.gridy = 4;
    c.gridwidth = 1;
    c.gridheight = 1;
    c.weightx = 0.1;
    c.weighty = 0.5;
    mainPanel.add(saveButton,c);

    browseButton.addActionListener(this);
    runButton.addActionListener(this);
    saveButton.addActionListener(this);

    Container contentPane = getContentPane();
    contentPane.add(mainPanel);

    setTitle("Class Runner");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    pack();
    setVisible(true);
  }

  public void browseFunction()
  {
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    int returnValue = fileChooser.showOpenDialog(null);
    File selectedFile = null;
    if(returnValue == JFileChooser.APPROVE_OPTION)
    {
      selectedFile = fileChooser.getSelectedFile();
      browseDirectory.setText(selectedFile.toPath().toString());
    }
    if(selectedFile != null)
    {
      //Add Removal from list here.
      optionsModel.clear();
      List<File> contents = JavaFileManager.getContents(selectedFile);
      for(File f : contents)
      {
        if(f.getName().contains(".class") && JavaFileManager.isMainClass(selectedFile,f.getName()))
        {
          //System.out.println(JavaFileManager.isMainClass(f));
          optionsModel.addElement(f.getName());
        }
      }
    }
    else
    {
      System.out.println("File not found");
    }
  }
  public void runFunction()
  {

  }
  public void saveFunction()
  {

  }
  public void actionPerformed(ActionEvent e)
  {
    if("browse".equals(e.getActionCommand()))
    {
      browseFunction();
    }
    else if("run".equals(e.getActionCommand()))
    {
      System.out.println("Run Button Clicked");
    }
    else
    {
      System.out.println("Save Button Clicked");
    }
  }
}
