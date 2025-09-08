
import { useState } from 'react';
import './App.css';
import TaskItem from './Components/TaskItem';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

function App() {
  const [newTask, setNewTask] = useState("");
  const [myTasks, setMyTasks] = useState([
    { name: "implementing project with react", completed: false },
    { name: "reading", completed: false },
    { name: "writing", completed: false }
  ]);
 
  function handleInput(e) {
    setNewTask(e.target.value);
  }

  function addTask() {
    if (!newTask.trim()) {
      toast.error("Task name cannot be empty");
      return;
    }

    const alreadyExists = myTasks.some(task => task.name.toLowerCase() === newTask.toLowerCase());
    if (alreadyExists) {
      toast.warning(`Task "${newTask}" already exists!`);
      return;
    }

    const newTaskObj = { name: newTask, completed: false };
    setMyTasks(prev => [...prev, newTaskObj]);
    toast.success(`Task "${newTask}" added successfully!`);
    setNewTask("");
  }

  function deleteTask(taskName) {
    const afterDeletion = myTasks.filter(task => task.name !== taskName);
    setMyTasks(afterDeletion);
    toast.info(`Task "${taskName}" deleted.`);
  }

  function completeTask(taskName) {
    const updatedTasks = myTasks.map(task =>
      task.name === taskName ? { ...task, completed: !task.completed } : task
    );
    setMyTasks(updatedTasks);
    toast.success(`Task "${taskName}" marked as ${updatedTasks.find(task => task.name === taskName).completed ? "complete" : "incomplete"}.`);
  }

  return (
    <div className='main-body'>
      <div className='todo-list-mainDiv'>
        <h3>My TODO List</h3>

        <div className='todo-task-input-div'>
          <input
            type='text'
            placeholder='To do task'
            onChange={handleInput}
            value={newTask}
            className='task-input'
          />
          <button className='add-button' onClick={addTask}>+</button>
        </div>

        <ul className='tasks-list'>
          {myTasks.map((task, index) => (
            <TaskItem
              key={index}
              task={task}
              deleteTask={deleteTask}
              completeTask={completeTask}
            />
          ))}
        </ul>

        <ToastContainer position="top-right" autoClose={2000} />
      </div>
    </div>
  );
}

export default App;
