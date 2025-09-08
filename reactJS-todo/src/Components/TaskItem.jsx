
import React from "react";

function TaskItem({ task, deleteTask, completeTask }) {
  return (
    <li className={`task ${task.completed ? "completed" : ""}`}>
      <span className="task-text">{task.name}</span>
      <div className="task-buttons">
        <button className="btn edit" onClick={() => completeTask(task.name)}>
          {task.completed ? "Undo" : "Complete"}
        </button>
        <button className="btn delete" onClick={() => deleteTask(task.name)}>
          Delete
        </button>
      </div>
    </li>
  );
}

export default TaskItem;
