import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.Format;
import java.text.SimpleDateFormat;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

class ListListener implements ListSelectionListener  {

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		// TODO Auto-generated method stub
		/*
		// show a dialog for edit task, when we click on the task
				listWithTasks.addListSelectionListener(new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent evtT) {
						//JFrame to edit User
						JFrame editTaskFrame = new JFrame("Edit the task");
						editTaskFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //clicking on X - do nothing
						editTaskFrame.setSize(350, 350);
						editTaskFrame.setLocation(600, 200);
						JComboBox selectTask = new JComboBox(tasksList);
						JComboBox assignedTo = new JComboBox(usersList);
						JTextField taskName = new JTextField(25);
					    JTextField taskDescription = new JTextField(30);
					    JCheckBox repeatableEachYear = new JCheckBox("Repeatable each year");
					    JTextField start = new JTextField(30);
					    JTextField end = new JTextField(30);
					    JPanel okCancelPanel = new JPanel();
					    JButton deleteTask = new JButton("Delete task");
					    JButton okButton = new JButton("OK");
					    JButton cancelButton = new JButton("Cancel");
					    Task editTask = (Task)listWithTasks.getSelectedValue();
						JPanel taskPanel = new JPanel();

						if (listWithTasks.getSelectedValue() != null) {
				    		taskName.setText(((Task)listWithTasks.getSelectedValue()).getNameTask());
				    		taskDescription.setText(((Task)listWithTasks.getSelectedValue()).getDescriptionTask());
				    		Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
				    		System.out.println(((Task)listWithTasks.getSelectedValue()).getStartTime().toString());
							String startFormatted = formatter.format(((Task)listWithTasks.getSelectedValue()).getStartTime());
							String endFormatted = formatter.format(((Task)listWithTasks.getSelectedValue()).getEndTime());
				    		start.setText(startFormatted);
				    		end.setText(endFormatted);
				    		assignedTo.setSelectedItem(((Task)listWithTasks.getSelectedValue()).getAssignedTo());
						}
					
					    taskPanel.add(new JLabel("Edit name of task:"));
					    taskPanel.add(taskName);
					    taskPanel.add(Box.createVerticalStrut(15)); // a spacer
					    taskPanel.add(new JLabel("Edit description of task:"));
					    taskPanel.add(taskDescription);
					    taskPanel.add(new JLabel("Choose the user:"));
					    taskPanel.add(assignedTo);
					    taskPanel.add(new JLabel("Edit start time. Enter yyyy-MM-dd HH:mm:ss")); 
					    taskPanel.add(start); // change to field where user can select the date and time
					    taskPanel.add(new JLabel("Edit end time. Enter yyyy-MM-dd HH:mm:ss"));
					    taskPanel.add(end); // change to field where user can select the date and time
					    taskPanel.add(deleteTask);
					    taskPanel.add(repeatableEachYear);

					    okButton.setEnabled(false);
						cancelButton.setEnabled(true);
						okCancelPanel.add(okButton);
						okCancelPanel.add(cancelButton);
						okCancelPanel.setLayout(new FlowLayout());
						taskPanel.add(Box.createRigidArea(new Dimension(0,20)));
						taskPanel.setLayout(new BoxLayout(taskPanel, BoxLayout.Y_AXIS));
						
						editTaskFrame.add(taskPanel, BorderLayout.CENTER);
						editTaskFrame.add(okCancelPanel, BorderLayout.PAGE_END);
						
						if (evtT.getValueIsAdjusting() == false && listWithTasks.getSelectedValue() != null) {
							System.out.println("set it visible");
							editTaskFrame.setVisible(true);
						}
						
						//button OK become clickable when all the text fields have been completed
						enableOKButtonTask(taskName, taskDescription, start, end, okButton);
						taskName.addKeyListener(new KeyAdapter() {
					        public void keyReleased(KeyEvent e) {
					        	enableOKButtonTask(taskName, taskDescription, start, end, okButton);
					        }
						});
						taskDescription.addKeyListener(new KeyAdapter() {
					        public void keyReleased(KeyEvent e) {
					        	enableOKButtonTask(taskName, taskDescription, start, end, okButton);
					        }
						});
						start.addKeyListener(new KeyAdapter() {
					        public void keyReleased(KeyEvent e) {
					        	enableOKButtonTask(taskName, taskDescription, start, end, okButton);
					        }
						});
						end.addKeyListener(new KeyAdapter() {
					        public void keyReleased(KeyEvent e) {
					        	enableOKButtonTask(taskName, taskDescription, start, end, okButton);
					        }
						});
						
						// button Cancel close the frame to edit user
						cancelButton.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent arg0) {
								// TODO Auto-generated method stub
								editTaskFrame.dispose();
							}
						});
						
						// button OK to save the changed task's name, description, start, end time
						okButton.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent arg0) {
								// TODO Auto-generated method stub

								editTask.setNameTask(taskName.getText());
								editTask.setDescriptionTask(taskDescription.getText());
								editTask.setStartTime(start.getText());
								editTask.setEndTime(end.getText());
								editTask.setAssignedTo((User)assignedTo.getSelectedItem());
								System.out.println("Name of task: " + taskName.getText());
								System.out.println("Description of task: " + taskDescription.getText());
								System.out.println("Start: " + editTask.getStartTime());
								System.out.println("End: " + editTask.getEndTime());
								System.out.println("Assigned to: " + editTask.getAssignedTo());
								Task t = TaskDAO.updateTask(editTask, users);
								    if (t != null) {
								    	editTask.setNameTask(t.getNameTask());
									    editTask.setDescriptionTask(t.getDescriptionTask());
									    editTask.setStartTime(t.getStartTime());
									    editTask.setEndTime(t.getEndTime());
									    editTask.setAssignedTo(t.getAssignedTo());
								    }
							    editTaskFrame.dispose();
							    }
						});
						
						// button to delete the task from the list of tasks
					    deleteTask.addActionListener(new ActionListener() {
					    	@Override
							public void actionPerformed(ActionEvent arg0) {
					    		int i = tasksList.getIndexOf(editTask);
					    		boolean result = TaskDAO.deleteTask(editTask); 
					    		if (result == true) {
					    			tasksList.removeElementAt(i);
					    		}
					    		editTaskFrame.dispose();
					    	}
						});
					    System.out.println("Selected from " + evtT.getFirstIndex() + " to " + evtT.getLastIndex());	 
					}
				});	
				*/
	}

}
