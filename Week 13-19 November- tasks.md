1. Add a listener to the Tasks List and show a dialog when we click on the task. The Dialog looks the same as the dialog for Add a new Task, but it allows to edit the task. 
- get the selected task with Task t = (Task)name_of_list.getSelectedItem().
- t.setName(text_field_for_name.getText())
- t.setDescription()
- t.setStartTime
- t.setEndTime
- t.setAssignedTo
- basically we edited the task
2. Add a listener to the Users List (listSelectionListener) and show a dialog with name and surname. 
3. Add a Delete button in the dialog that shows up when clicking on a task from the list + listener for the button (removeElementAt).
4. For the Users list the same thing, add a Delete button in the dialog + listener. Use removeElement. 
 
