import { useState, useRef } from "react"
import TodoSubmitForm from "./component/TodoSubmitForm";
import TodoList from "./component/TodoList";

function App() {
  const initialState = [
    {
      id: 1,
      value: '할일 1',
      completed: true
    },
    {
      id: 2,
      value: '할일 2',
      completed: false
    },
    {
      id: 3,
      value: '할일 3',
      completed: false
    }
  ]

  const idRecorder = useRef(4);
  const [todos, setTodos] = useState(initialState);

  const removeTodo = (id) => {
    const filtered = todos.filter(todo => todo.id !== id);
    setTodos(filtered);
  }

  const toggleTodo = (id) => {
    const updated = todos.map(todo =>
      todo.id === id ? { ...todo, completed: !todo.completed } : todo
    );
    setTodos(updated);
  }

  const addTodo = (value) => {
    const newTodos = [{ id: idRecorder.current++, value: value, completed: false }, ...todos];
    setTodos(newTodos);
  }

  return (
    <>
      <TodoSubmitForm addTodo={addTodo} />
      <TodoList todos={todos} removeTodo={removeTodo} toggleTodo={toggleTodo} />
    </>
  )
}

export default App;